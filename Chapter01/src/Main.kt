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
fun main5(){
    val i1 = 11
    val i2 = 100
    val c1 = 'K'
    val c2 = 'k'

    println("$i1 ${inNumRange(i1)}")
    println("$i2 ${inNumRange(i2)}")
    println("$c1 ${notLowerCase(c1)}")
    println("$c2 ${notLowerCase(c2)}")
}

fun main6(){
    val result = println("return Unit")
    println(result)
}

fun main7(){
    println(Int.MAX_VALUE)
    println(Int.MAX_VALUE + 1)
}



fun showSnake(rows: Int, columns: Int) {
    var width = (rows * columns).toString().length + 1
    var num = 0
    var straight = true

    repeat(rows) {
        repeat(columns) {
            if (straight) {
                print("%${width}d".format(num))
                num++
            } else {
                print("%${width}d".format(num))
                num--
            }
        }

        if(straight){
            num += columns - 1
        }else{
            num += columns + 1
        }
        straight = !straight
        println()

    }
}

fun main() {
    showSnake(2, 3)
    println()
    showSnake(4, 5)
}

/* Output:
   #
  ###
 #####
#######
*/