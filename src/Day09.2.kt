import java.util.Scanner
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(){
    val sc = Scanner(System.`in`)
    val list = mutableListOf<Pair<Int, Int>>()
    var line = sc.nextLine()

    while (line.isNotEmpty()){
        val adding = line.split(",")
        list.add(Pair(adding[0].toInt(), adding[1].toInt()))
        line = sc.nextLine()
    }

    val pairs = mutableListOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
    for (i in 0..<list.size){
        for (j in i+1..<list.size){
            pairs.add(Pair(list[i],list[j]))
        }
    }

    pairs.sortByDescending { (abs(it.first.first - it.second.first).toLong() + 1) * (abs(it.first.second - it.second.second) + 1) }

    var maxPair = Pair(Pair(0, 0), Pair(0, 0))
    for (pair in pairs){
        if (!blocked(list, pair)){
            maxPair = pair
            break
        }
    }
    println(maxPair)
    println((abs(maxPair.first.first - maxPair.second.first).toLong() + 1) * (abs(maxPair.first.second - maxPair.second.second) + 1))
}

fun blocked(list: List<Pair<Int, Int>>, pair: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
    list.forEach {
        if (it.first > min(pair.first.first, pair.second.first) &&
            it.first < max(pair.first.first, pair.second.first) &&
            it.second > min(pair.first.second, pair.second.second) &&
            it.second < max(pair.first.second, pair.second.second))
            //ToDO:
            return true
    }
    return false
}