import java.util.Scanner
import kotlin.sequences.forEach

fun main(){
    val sc = Scanner(System.`in`)
    val lists = mutableListOf<Triple<MutableList<Boolean>, MutableList<MutableList<Int>>, MutableList<Int>>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        val splittedLine = line.split(" ")
        val firstList = mutableListOf<Boolean>()
        val secondList = mutableListOf<MutableList<Int>>()
        val thirdList = mutableListOf<Int>()

        val splittedFirst = splittedLine.first().split("")
        splittedFirst.forEach {
            if (it.equals("#")) firstList.add(true)
            else if (it.equals(".")) firstList.add(false)
        }

        val splittedLast = splittedLine.last().split("{", "}", ",")
        splittedLast.forEach {
            if (it.isNotEmpty()) thirdList.add(it.toInt())
        }

        for (i in 1..<splittedLine.size-1){
            val splittedMidLine = splittedLine[i].split("(", ")", ",")
            val toAddToList = mutableListOf<Int>()
            splittedMidLine.forEach {
                if (it.isNotEmpty()) toAddToList.add(it.toInt())
            }
            secondList.add(toAddToList)
        }

        lists.add(Triple(firstList, secondList, thirdList))
        line = sc.nextLine()
    }
    var result = 0
    var count = 0

    lists.forEach { list ->
        var missedLine = true
        singleLine@
        for (i in 1..list.second.size){
            // ToDo: jedes Element kann auch mehrfach verwendet werden
            val combinations = list.second.combinations(i)
            combinations.forEach { combination ->
                val boolList = list.first.toMutableList()
                val joltageList = list.third.toMutableList()
                combination.toList().forEach { toToggleList ->
                    toToggleList.forEach { toToggle ->
                        boolList[toToggle] = !boolList[toToggle]
                        joltageList[toToggle] -= 1
                    }
                }
                var allOff = true
                boolList.forEach { bool ->
                    if (bool) allOff = false
                }
                var allJoltageZero = true
                joltageList.forEach { joltage ->
                    if (joltage != 0) allJoltageZero = false
                }
                if (allOff && allJoltageZero) {
                    result += i
                    count++
                    missedLine = false
                    break@singleLine
                }
            }
        }
        if (missedLine) println("MissedLine: $list")
    }
    println("Count: $count")
    println("Anzahl lines: ${lists.size}")
    println("Result: $result")
}
