import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val ranges = mutableListOf<Pair<Long, Long>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        val splittedLine = line.split("-")
        ranges.add(Pair(splittedLine[0].toLong(), splittedLine[1].toLong()))
        line = sc.nextLine()
    }
    ranges.sortBy { it.first }
    val nonOverlappedRanges = mutableListOf<Pair<Long, Long>>()

    for (i in 0..<ranges.size){
        if (i == ranges.size - 1) nonOverlappedRanges.add(ranges[i])
        else if (ranges[i].second < ranges[i+1].first) nonOverlappedRanges.add(ranges[i])
        else ranges[i+1] = Pair(ranges[i].first, Math.max(ranges[i].second, ranges[i+1].second))
    }

    println("Non overlapped ranges: $nonOverlappedRanges")

    var counter: Long = 0
    nonOverlappedRanges.forEach{
        counter += it.second-it.first+1
    }

    println("Counter: $counter")
}