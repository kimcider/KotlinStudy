package Part2

class House{
    var sofa : String = ""
}

fun main(){
    val house = House()

    house.sofa = "S1"
    println(house.sofa)
    house.sofa = "S2"
    println(house.sofa)
}