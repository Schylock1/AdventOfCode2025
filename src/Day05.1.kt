import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val ranges = mutableListOf<Pair<Long, Long>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        val splittedLine = line.split("-")
        ranges.add(Pair(splittedLine[0].toLong(), splittedLine[1].toLong()))
        line = sc.nextLine()
    }
    val ids = mutableListOf<Long>()
    line = sc.nextLine()
    while (line.isNotEmpty()) {
        ids.add(line.toLong())
        line = sc.nextLine()
    }

    var counter = 0

    ids.forEach { id ->
        if (isInRange(ranges, id)) counter++
    }

    println("Counter: $counter")
}

fun isInRange(ranges: List<Pair<Long, Long>>, id: Long): Boolean {
    ranges.forEach {
        if (id in it.first..it.second) return true
    }
    return false
}