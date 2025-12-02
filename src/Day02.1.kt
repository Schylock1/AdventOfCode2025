import java.util.Scanner

var value: Long = 0
val ids = mutableListOf<Long>()

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
        for (j in firsts[i]..seconds[i]){
            if (ids.contains(j)){
                continue
            }
            checkValid(j)
            ids.add(j)
        }
    }

    println(value)
}

fun checkValid(id: Long) {
    val numbers: List<Int> = id.toString().map { it.digitToInt() }
    var valid = false
    for (i in 0..numbers.size/2-1){
        if (numbers[i] != numbers[i + numbers.size/2] || numbers.size%2 == 1){
            valid = true
            break
        }
    }
    if (!valid){
        value += id
    }
}