package org.example.lolseplltimerserver

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val lineList = mapOf(Pair("top", Liner("top")), Pair("jg", Liner("jg")), Pair("mid", Liner("mid")), Pair("bot", Liner("bot")), Pair("sup", Liner("sup")))

fun getJsonLineList(): String {
    var newList = lineList.values.toList()
    val mapper = jacksonObjectMapper()
    val json = mapper.writeValueAsString(newList)
    return json
}


class Liner(val name: String) {
    var flag = false
}