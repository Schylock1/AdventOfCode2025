import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val lines = mutableListOf<MutableList<String>>()
    var nextLine = sc.nextLine()
    while (nextLine.isNotEmpty()) {
        lines.add(nextLine.split("").toMutableList())
        nextLine = sc.nextLine()
    }

    var totalSplits = 0
    lines[0].forEachIndexed { i, s -> if (s.equals("S")) lines[0][i] = "|"}
    for (lineIndex in 1..<lines.size){
        lines[lineIndex].forEachIndexed { elementIndex, element ->
            if (element.equals("^")){
                if (lines[lineIndex-1][elementIndex].equals("|")) {
                    lines[lineIndex][elementIndex-1] = "|"
                    lines[lineIndex][elementIndex+1] = "|"
                    totalSplits++
                }
            } else { // "."
                if (lines[lineIndex-1][elementIndex].equals("|")) {
                    lines[lineIndex][elementIndex] = "|"
                }
            }
        }
    }
    println(totalSplits)
}