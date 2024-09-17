package org.example.lolseplltimerserver.testfile

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.example.lolseplltimerserver.*
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@SpringBootTest
@AutoConfigureMockMvc
class LinerTest {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun testGetJsonLineList() {
        assertEquals(
            """[{"name":"top","flag":false},{"name":"jg","flag":false},{"name":"mid","flag":false},{"name":"bot","flag":false},{"name":"sup","flag":false}]""".trimIndent()
            , getJsonLineList()
        )
    }

    @Test
    fun testJGFlagOn(){
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/useFlash")
                .content("""
                    {
                      "name": "jg",
                      "flag": true
                    }
                """.trimIndent())
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk())


        assertEquals(
            """[{"name":"top","flag":false},{"name":"jg","flag":true},{"name":"mid","flag":false},{"name":"bot","flag":false},{"name":"sup","flag":false}]""".trimIndent()
            , getJsonLineList()
        )
    }

    @Test
    fun testLinerToJson(){
        var liner = Liner("jg")
        val mapper = jacksonObjectMapper()
        val json = mapper.writeValueAsString(liner)

        assertEquals("""{"name":"jg","flash":{"flashCoolTime":300,"coolTime":300,"on":true}}""", json)
    }

    @Test
    fun testJsonToLinerList(){
        val json = """[{"name":"top","flash":{"flashCoolTime":300,"coolTime":300,"on":true}},
                  {"name":"jg","flash":{"flashCoolTime":300,"coolTime":300,"on":false}},
                  {"name":"mid","flash":{"flashCoolTime":300,"coolTime":300,"on":false}},
                  {"name":"bot","flash":{"flashCoolTime":300,"coolTime":300,"on":true}},
                  {"name":"sup","flash":{"flashCoolTime":300,"coolTime":300,"on":true}}]"""

        val mapper = jacksonObjectMapper()

        // JSON을 List<Liner>로 역직렬화
        val liners: List<Liner> = mapper.readValue(json)
        val result = liners.associateBy { it.name }

        // 예상 결과와 비교
        val expectedLineList = mapOf(
            "top" to Liner("top", Flash(300, 300, true)),
            "jg" to Liner("jg", Flash(300, 300, false)),
            "mid" to Liner("mid", Flash(300, 300, false)),
            "bot" to Liner("bot", Flash(300, 300, true)),
            "sup" to Liner("sup", Flash(300, 300, true))
        )

        assertNotEquals(expectedLineList, lineList)
        assertEquals(expectedLineList, result)
    }
}
