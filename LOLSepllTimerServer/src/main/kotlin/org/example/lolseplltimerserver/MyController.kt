package org.example.lolseplltimerserver

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.TextMessage
import java.io.IOException

@RestController
@RequestMapping("/")
object MyController {


    init{

    }

    @PostMapping("/test")
    fun testValue(@RequestBody newValue: String){
        val modifiedMessage = "$newValue test"
        MyWebSocketHandler.sessions.filter { it.isOpen }.forEach { session ->
            try {
                session.sendMessage(TextMessage(modifiedMessage))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    /*
    *
    data came like this

    """
        {
          "name": "top",
          "flag": true
        }
    """
    *
    * */
    @PostMapping("/useFlash")
    fun updateValue(@RequestBody newValue: String){
        val mapper = jacksonObjectMapper()
        val liner: Liner = mapper.readValue(newValue)

        lineList[liner.name]!!.flag = liner.flag

        MyWebSocketHandler.sessions.filter { it.isOpen }.forEach { session ->
            try {
                session.sendMessage(TextMessage(getJsonLineList()))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}