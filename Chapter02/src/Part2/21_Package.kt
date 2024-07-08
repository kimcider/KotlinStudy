package pythagorean
import kotlin.math.*

class RightTriangle(
    val a : Double,
    val b : Double
) {
    fun hypothenuse() = sqrt(a * a + b * b)
    fun area() = a * b / 2
}