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

    lines.forEach { it ->
        var biggest = 0
        var secondBiggest = 0
        it.forEach { number ->
            if (number >= biggest){
                secondBiggest = biggest
                biggest = number
            } else if (number >= secondBiggest){
                secondBiggest = number
            }
        }
        println("Biggest: $biggest")
        println("SecondBiggest: $secondBiggest")

        if (it.indexOf(biggest) <= it.indexOf(secondBiggest) ){
            counter += (biggest.toString()+secondBiggest.toString()).toInt()
        } else {
            counter += (secondBiggest.toString()+biggest.toString()).toInt()
        }


    }
    println(counter)
}