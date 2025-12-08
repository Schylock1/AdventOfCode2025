import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt


fun main(){
    val sc = Scanner(System.`in`)
    val list = mutableListOf<Triple<Int, Int, Int>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()) {
        list.add(listToTriple(line.split(",")))
        line = sc.nextLine()
    }
    val pairs = mutableListOf<Pair<Triple<Int, Int, Int>, Triple<Int, Int, Int>>>()
    for (i in 0..<list.size){
        for (j in i+1..<list.size){
            pairs.add(Pair(list[i],list[j]))
        }
    }
    pairs.sortBy { sqrt((it.first.first - it.second.first).toDouble().pow(2.0) + (it.first.second - it.second.second).toDouble().pow(2.0) + (it.first.third - it.second.third).toDouble().pow(2.0)) }

    val used = mutableListOf<Triple<Int, Int, Int>>()

    var lastPair: Pair<Triple<Int, Int, Int>, Triple<Int, Int, Int>> = pairs[0]
    while (pairs.isNotEmpty()){
        println(pairs.size)
        used.add(pairs.first().first)
        used.add(pairs.first().second)
        lastPair = pairs.first()
        pairs.removeFirst()
        var index = 0
        while (index < pairs.size){
            if (used.contains(pairs[index].first) && used.contains(pairs[index].second)){
                pairs.removeAt(index)
                index--
            }
            index++
        }
    }
    println(pairs)
    println(lastPair)
    println((lastPair.first.first.toLong() * lastPair.second.first.toLong()))
}
