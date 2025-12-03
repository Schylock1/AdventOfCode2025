import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val lines = mutableListOf<MutableList<Int>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        lines.add(line.toString().map { it.digitToInt() } as MutableList<Int>)
        line = sc.nextLine()
    }

    var counter: Long = 0

    lines.forEach { line ->
        var lastIndex = -1
        var counting = ""
        for (i in 12 downTo 1) {
            var biggest = 0
            for (j in lastIndex+1..line.size-i){
                if (biggest < line[j]){
                    biggest = line[j]
                    lastIndex = j
                }
            }
            counting += biggest.toString()
        }
        counter += counting.toLong()
    }
    println(counter)
}