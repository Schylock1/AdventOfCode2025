import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    var lists = mutableListOf<String>()
    var line = sc.nextLine()
    while (line.isNotEmpty()){
        lists.add(line)
        line = sc.nextLine()
    }
    var operatorLine = lists.removeLast()

    var result: Long = 0
    var operator = operatorLine.first()
    val listOfNumbersToCountWith = mutableListOf<Int>()
    var firstTime = true

    fun endSingleProblem(){
        var toAddToFinal: Long = 0
        if (operator.equals('+')){
            listOfNumbersToCountWith.forEach { toAddToFinal += it }
            println("+ with: $toAddToFinal")
        } else if(operator.equals('*')){
            if (toAddToFinal.toInt() == 0) toAddToFinal++
            listOfNumbersToCountWith.forEach { toAddToFinal *= it }
            println("* with: $toAddToFinal")
        } else throw Exception()
        result += toAddToFinal
        listOfNumbersToCountWith.clear()

        if (operatorLine.isNotEmpty()){
            operator = operatorLine.first()
        }
    }

    do {
        if (!firstTime && (operatorLine.isEmpty() || !operatorLine.first().equals(' '))){
            endSingleProblem()
        }
        firstTime = false
        if (operatorLine.isEmpty()){
            break
        }
        operatorLine = operatorLine.drop(1)
        val listOfSingleLines = mutableListOf<String>()
        repeat(4){ listOfSingleLines.add("") }
        lists.forEachIndexed { i, it ->
            listOfSingleLines[i] += it.first()
            lists[i] = lists[i].drop(1)
        }
        var number = ""
        listOfSingleLines.forEach {
            if (!it.equals(" ")) number += it
        }
        if (number.isNotEmpty()){
            listOfNumbersToCountWith.add(number.toInt())
        }
    } while (true)

    println(result)


}