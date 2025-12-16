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

    println(operatorLine)
    println(lists)

    var result: Long = 0

    while (operatorLine.isNotEmpty()){
        var operator = operatorLine.first()
        operatorLine = operatorLine.drop(1)
        val listOfSingleLines = mutableListOf<String>()
        repeat(4){ listOfSingleLines.add("") }
        do {
            lists.forEachIndexed { i, it ->
                listOfSingleLines[i] += it.first()
                lists[i] = lists[i].drop(1)
            }

        } while (!operatorLine.first().equals(" "))
    }
}