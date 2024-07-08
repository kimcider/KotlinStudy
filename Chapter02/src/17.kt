class Giraffe
class Bear
class Hippo

class Dog {
    fun bark() = "yip!"
}

fun main() {
    val g1 = Giraffe()
    val g2 = Giraffe()
    val b = Bear()
    val h = Hippo()

    println(g1)
    println(g2)
    println(b)
    println(h)

    val dog = Dog()
    println(dog.bark())

}