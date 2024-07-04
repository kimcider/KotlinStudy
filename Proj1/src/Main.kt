fun testCondition(i : Int) = i < 100
fun main1() {
    var i = 0
    while(testCondition(i)){
        print(".")
        i += 10
    }
}

fun main2(){
    for(c in "Kotlin"){
        print("$c")
    }
}

fun main3(){
    for(i in 1 .. 10){
        print("$i ")
    }
}

fun main4(){
    for(i in 1 until 10){
        print("$i ")
    }
}

fun inNumRange(n : Int) = n in 50 .. 100
fun notLowerCase(ch : Char) = ch !in 'a' .. 'z'
fun main(){
    val i1 = 11
    val i2 = 100
    val c1 = 'K'
    val c2 = 'k'

    println("$i1 ${inNumRange(i1)}")
    println("$i2 ${inNumRange(i2)}")
    println("$c1 ${notLowerCase(c1)}")
    println("$c2 ${notLowerCase(c2)}")
}