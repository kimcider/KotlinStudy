package Part2

class Wombat

class Alien(name: String) {
    val greeting = "Poor $name"
}

class MutableNameAlien(var name: String)

class Scienteist(val name: String){
    override fun toString(): String {
        return "Scienteist( '$name') "
    }
}

fun main() {
    val wombat = Wombat()

    val alien = Alien("Mr. Meeseeks")
    println(alien.greeting)

    val alien1 = MutableNameAlien("Temp")
    println(alien1.name)
//    println(alien.name)

    val zeep = Scienteist("Zeep Xanflorp")
    println(zeep)

}