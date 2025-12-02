import java.util.Scanner

val value: Long = 0

fun main() {
    val sc = Scanner(System.`in`)
    val firsts = mutableListOf<Long>()
    val seconds = mutableListOf<Long>()
    val ranges = mutableListOf<String>()

    val line = sc.nextLine()

    line.split(",", "-").forEachIndexed { i, it ->
        if (i%2 == 0){
            firsts.add(it.toLong())
        } else {
            seconds.add(it.toLong())
        }
    }

    val numbers: List<Int> = firsts[0].toString().map { it.digitToInt() }

    println(numbers)

    println(ranges)
    println(firsts)
    println(seconds)
}