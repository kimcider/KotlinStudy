package Part2

import kotlin.math.*
import pythagorean.RightTriangle

fun main(){
    println(PI)
    println(cos(PI))
    println(cos(2 * PI))

    println(E)
    println(E.roundToInt())
    println(E.toInt())

    val rt = RightTriangle(3.0, 4.0)
    println(rt.hypothenuse())
    println(rt.area())
}