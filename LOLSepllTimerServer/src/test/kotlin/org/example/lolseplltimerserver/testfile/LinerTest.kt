package org.example.lolseplltimerserver.testfile

import org.example.lolseplltimerserver.MyController
import org.example.lolseplltimerserver.getJsonLineList
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.test.assertEquals

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
}
