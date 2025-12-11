import java.util.Scanner

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
            val combinations = list.second.combinations(i)
            combinations.forEach { combination ->
                val boolList = list.first.toMutableList()
                combination.toList().forEach { toToggleList ->
                    toToggleList.forEach { toToggle ->
                        boolList[toToggle] = !boolList[toToggle]
                    }
                }
                var allOff = true
                boolList.forEach { bool ->
                    if (bool) {
                        allOff = false
                    }
                }
                if (allOff) {
                    result += i
                    count++
                    missedLine = false
//                    println(i)
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






// imports
fun <T : Any> T.repeat(times: Int? = null): Sequence<T> = sequence {
    var count = 0
    while (times == null || count++ < times) yield(this@repeat)
}

fun <T : Any> List<T>.combinations(r: Int, replace: Boolean = false): Sequence<List<T>> {
    val n = count()
    if (r > n) return sequenceOf()
    return sequence {
        var indices = if (replace) 0.repeat(r).toMutableList() else (0 until r).toMutableList()
        while (true) {
            yield(indices.map { this@combinations[it] })
            var i = r - 1
            loop@ while (i >= 0) {
                when (replace) {
                    true -> if (indices[i] != n - 1) break@loop
                    false -> if (indices[i] != i + n - r) break@loop
                }
                i--
            }
            if (i < 0) break
            when (replace) {
                true -> indices = (indices.take(i) + (indices[i] + 1).repeat(r - i)).toMutableList()
                false -> {
                    indices[i] += 1
                    (i + 1 until r).forEach { indices[it] = indices[it - 1] + 1 }
                }
            }
        }
    }
}