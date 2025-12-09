import java.util.Scanner
import kotlin.math.abs

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

    val maxPair = pairs.maxBy { (abs(it.first.first - it.second.first).toLong() + 1) * (abs(it.first.second - it.second.second) + 1) }
    println((abs(maxPair.first.first - maxPair.second.first).toLong() + 1) * (abs(maxPair.first.second - maxPair.second.second) + 1))
}