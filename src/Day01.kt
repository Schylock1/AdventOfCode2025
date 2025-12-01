import java.util.Scanner

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
    var pointer = 50
    var counter = 0
    lr.forEachIndexed { i, s ->
        if (s.equals("R")){
            pointer += numbers[i]
        } else {
            pointer -= numbers[i]
        }
        if (pointer%100 == 0){
            counter++
        }
    }
    println(counter)
}