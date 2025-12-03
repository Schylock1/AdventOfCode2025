import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)

    val lines = mutableListOf<MutableList<Int>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()){
        lines.add(line.toString().map { it.digitToInt() } as MutableList<Int>)
        line = sc.nextLine()
    }

    var counter = 0

    lines.forEach {
        var biggest = 0
        var secondBiggest = 0
        for (j in 0..it.size-2){
            biggest = Math.max(biggest, it[j])
        }
        for (j in it.indexOf(biggest)+1..it.size-1){
            secondBiggest = Math.max(secondBiggest, it[j])
        }
        counter += (biggest.toString()+secondBiggest.toString()).toInt()
    }
    println(counter)
}