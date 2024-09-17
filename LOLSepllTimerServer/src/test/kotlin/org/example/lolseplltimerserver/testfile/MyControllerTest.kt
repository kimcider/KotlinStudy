package org.example.lolseplltimerserver.testfile


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.example.lolseplltimerserver.Liner
import org.example.lolseplltimerserver.MyController
import org.example.lolseplltimerserver.getJsonLineList
import org.example.lolseplltimerserver.lineList
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
class MyControllerTest {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun testUseFlash(){
        var liner = Liner("jg")
        val mapper = jacksonObjectMapper()
        var json = mapper.writeValueAsString(liner)
        assertEquals("""{"name":"jg","flash":{"flashCoolTime":300,"coolTime":300,"on":true}}""", json)
        liner.flash.on = false
        json = mapper.writeValueAsString(liner)
        assertEquals("""{"name":"jg","flash":{"flashCoolTime":300,"coolTime":300,"on":false}}""", json)

        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/useFlash")
                .content(json)
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk())

        liner = lineList["jg"]!!
        json = mapper.writeValueAsString(liner)
        assertEquals("""{"name":"jg","flash":{"flashCoolTime":300,"coolTime":300,"on":false}}""", json)

    }
}
