import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

const val leftConnections = 1000

fun main(){
    val sc = Scanner(System.`in`)
    val list = mutableListOf<Triple<Int, Int, Int>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        list.add(listToTriple(line.split(",")))
        line = sc.nextLine()
    }
    var pairs = mutableListOf<Pair<Triple<Int, Int, Int>, Triple<Int, Int, Int>>>()
    for (i in 0..<list.size){
        for (j in i+1..<list.size){
            pairs.add(Pair(list[i],list[j]))
        }
    }
    pairs.sortBy { sqrt((it.first.first - it.second.first).toDouble().pow(2.0) + (it.first.second - it.second.second).toDouble().pow(2.0) + (it.first.third - it.second.third).toDouble().pow(2.0)) }
    pairs = pairs.take(leftConnections).toMutableList()

    //Merge junction boxes
    val circuits = mutableListOf<MutableList<Triple<Int, Int, Int>>>()
    for (i in 0..<pairs.size){
        var added = false
        for (j in 0..<circuits.size){
            if (circuits[j].contains(pairs[i].first) || circuits[j].contains(pairs[i].second)){
                circuits[j].add(pairs[i].first)
                circuits[j].add(pairs[i].second)
                added = true
            }
        }
        if (!added) {
            circuits.add(mutableListOf(pairs[i].first, pairs[i].second))
        }
    }

    circuits.forEachIndexed { i, _ -> circuits[i] = circuits[i].distinct().toMutableList() }

    var beforeMergeSize = 0
    circuits.forEach {
        beforeMergeSize += it.size
    }
    println("Total Triples before Merge: $beforeMergeSize")

    //Merge circuits
    var somethingChanged = true
    while (somethingChanged) {
        somethingChanged = false
        var index = 0
        while (index < circuits.size-1){
            var j = index+1
            while (j < circuits.size){
                for (k in 0..<circuits[j].size){
                    if (circuits[index].contains(circuits[j][k])){
                        circuits[index] = circuits[index].plus(circuits[j]).toMutableList()
                        circuits.removeAt(j)
                        somethingChanged = true
                        j--
                        break
                    }
                }
                j++
            }
            index++
        }
    }

    circuits.forEachIndexed { i, _ -> circuits[i] = circuits[i].distinct().toMutableList() }
    circuits.sortByDescending { it.size }

    circuits.forEach { println("${it.size}: $it") }

    var totalSize = 0
    circuits.forEach {
        totalSize += it.size
    }
    println("Total Triples by the end: $totalSize")

    println("Biggest: ${circuits[0].size}")
    println("SecondBiggest: ${circuits[1].size}")
    println("ThirdBiggest: ${circuits[2].size}")
    println("Multiplied: ${circuits[0].size*circuits[1].size*circuits[2].size}")
}



fun listToTriple(list: List<String>): Triple<Int, Int, Int> {
    return Triple(list[0].toInt(), list[1].toInt(), list[2].toInt())
}