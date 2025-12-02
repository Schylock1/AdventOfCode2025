import java.util.Scanner

private var value: Long = 0

fun main() {
    val sc = Scanner(System.`in`)
    val firsts = mutableListOf<String>()
    val seconds = mutableListOf<String>()

    val line = sc.nextLine()

    line.split(",", "-").forEachIndexed { i, it ->
        if (i%2 == 0){
            firsts.add(it)
        } else {
            seconds.add(it)
        }
    }

    for (i in 0..firsts.size-1){
        if (firsts[i].length%2 == 1 && seconds[i].length%2 == 1){
            continue
        }
        for (j in firsts[i].toLong()..seconds[i].toLong()){
            checkValid(j.toString())
        }
    }

    println(value)
}

fun checkValid(numbers: String) {
    if (numbers.length%2 == 1) return

    val firstHalf = numbers.substring(0, numbers.length/2)
    val secondHalf = numbers.substring(numbers.length/2)

    if (firstHalf == secondHalf) {
        value += numbers.toLong()
    }
}