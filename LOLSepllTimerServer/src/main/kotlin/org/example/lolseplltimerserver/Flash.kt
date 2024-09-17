package org.example.lolseplltimerserver
data class Flash(
    val flashCoolTime: Int = 300,
    var coolTime: Int = flashCoolTime,
    var on : Boolean = true)