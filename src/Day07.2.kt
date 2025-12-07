import java.util.Scanner

val differentTimelines = mutableListOf<MutableList<MutableList<String>>>()

fun main() {
    val sc = Scanner(System.`in`)
    val lines = mutableListOf<MutableList<String>>()
    var nextLine = sc.nextLine()
    while (nextLine.isNotEmpty()) {
        lines.add(nextLine.split("").toMutableList())
        lines.last().removeFirst()
        lines.last().removeLast()
        nextLine = sc.nextLine()
    }

    lines[0].forEachIndexed { i, s -> if (s.equals("S")) lines[0][i] = "|"}
//    println(lines)
    timelines(lines, 1)

    println(differentTimelines.distinct().size)

}

fun timelines(lines: MutableList<MutableList<String>>, lineIndex: Int){
    var elementIndex = 0
    while (elementIndex <= lines[0].size){
        if (lineIndex == lines.size){
            differentTimelines.add(lines)
            println("added")
            return
        }
        if (elementIndex == lines[lineIndex].size){
            timelines(lines, lineIndex+1)
            return
        }
        if (lines[lineIndex][elementIndex].equals("^") && lines[lineIndex-1][elementIndex].equals("|")){
            val leftTimelineLines = copyOfMMS(lines)
            val rightTimelineLines = copyOfMMS(lines)
            leftTimelineLines[lineIndex][elementIndex-1] = "|"
//        println("Left version:  $leftTimelineLines")
            rightTimelineLines[lineIndex][elementIndex+1] = "|"
//        println("Right version: $rightTimelineLines")
            timelines(leftTimelineLines, lineIndex+1)
            timelines(rightTimelineLines, lineIndex+1)
            return
        }
        if (lines[lineIndex][elementIndex].equals(".") && lines[lineIndex-1][elementIndex].equals("|")) {
            lines[lineIndex][elementIndex] = "|"
            timelines(lines, lineIndex+1)
            return
        }
        elementIndex++
    }
}

fun copyOfMMS(lines: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    val copy = mutableListOf<MutableList<String>>()
    lines.forEach { copy.add(it.toMutableList()) }
    return copy
}