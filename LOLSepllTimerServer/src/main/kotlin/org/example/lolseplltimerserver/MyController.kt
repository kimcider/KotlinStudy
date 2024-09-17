package org.example.lolseplltimerserver

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
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
    fun testValue(@RequestBody newValue: String): String{
        val modifiedMessage = "$newValue test"
        MyWebSocketHandler.sessions.filter { it.isOpen }.forEach { session ->
            try {
                session.sendMessage(TextMessage(modifiedMessage))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return newValue + "body is different"
    }

    @PostMapping("/useFlash")
    fun useFlash(@RequestBody json: String){
        val mapper = jacksonObjectMapper()
        val liner: Liner = mapper.readValue(json)

        lineList[liner.name]!!.flash.on = liner.flash.on

        MyWebSocketHandler.sessions.filter { it.isOpen }.forEach { session ->
            try {
                session.sendMessage(TextMessage(getJsonLineList()))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    @PostMapping("/flashOn")
    fun flashOn(@RequestBody json: String){
        val mapper = jacksonObjectMapper()
        val liner: Liner = mapper.readValue(json)

        lineList[liner.name]!!.flash.on = liner.flash.on
    }
}