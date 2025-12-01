import java.util.Scanner

var pointer = 50
var counter = 0

fun main() {
    val sc = Scanner(System.`in`)
    val lr = mutableListOf<String>()
    val numbers = mutableListOf<Int>()
    var line = sc.nextLine()
    while(line.isNotEmpty()) {
        lr.add(line.first().toString())
        numbers.add(line.drop(1).toInt())
        line = sc.nextLine()
    }

    numbers.forEachIndexed { i, _ ->
        while (numbers[i] >= 100){
            numbers[i] -= 100
            counter++
        }
    }

    numbers.forEachIndexed { i, _ ->
        if (lr[i].equals("L")){
            numbers[i] *= (-1)
        }
        rotate(numbers[i])
    }
    println("Answer: $counter")
}

fun rotate(i: Int) {
    val pointerPrev = pointer
    pointer += i
    if (pointer !in 1..99){
        if (pointerPrev != 0){
            counter++
        }
        pointer = pointer.mod(100)
    }
}