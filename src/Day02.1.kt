import java.util.Scanner

var value: Long = 0

fun main() {
    val sc = Scanner(System.`in`)
    val firsts = mutableListOf<Long>()
    val seconds = mutableListOf<Long>()

    val line = sc.nextLine()

    line.split(",", "-").forEachIndexed { i, it ->
        if (i%2 == 0){
            firsts.add(it.toLong())
        } else {
            seconds.add(it.toLong())
        }
    }

    for (i in 0..firsts.size-1){
        println(i)
        if (firsts[i].toString().length%2 == 1 && seconds[i].toString().length%2 == 1){
            continue
        }
        for (j in firsts[i]..seconds[i]){
            checkValid(j)
        }
    }

    println(value)
}

fun checkValid(id: Long) {
    val numbers = id.toString()
    if (numbers.length%2 == 1) return

    val firstHalf = numbers.substring(0, numbers.length/2)
    val secondHalf = numbers.substring(numbers.length/2)

    if (firstHalf == secondHalf) {
        value += id
    }
}