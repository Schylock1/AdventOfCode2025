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

    lines.forEachIndexed { i, it ->
        var biggest = 0
        var secondBiggest = 0
        for (j in 0..lines[i].size-2){
            biggest = Math.max(biggest, lines[i][j])
        }
        for (j in lines[i].indexOf(biggest)+1..lines[i].size-1){
            secondBiggest = Math.max(secondBiggest, lines[i][j])
        }
        counter += (biggest.toString()+secondBiggest.toString()).toInt()
    }
    println(counter)
}