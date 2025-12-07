import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val lists = mutableListOf<MutableList<String>>()
    var line = sc.nextLine().split(' ').toMutableList()
    while (!(line.first().equals("+") || line.first().equals("*"))){
        lists.add(line)
        line = sc.nextLine().split(' ').toMutableList()
    }
    val operator: MutableList<String> = line

//    lists.forEach { line ->
//        line.removeAll { it.isEmpty() }
//    }
//    operator.removeAll{ it.isEmpty() }
    val operatorDistance = mutableListOf<Int>()

    var distance = 1
    for(i in 1..<operator.size){
        if(operator[i].equals("+") || operator[i].equals("*") ){
            operatorDistance.add(distance)
            distance = 1
        } else distance++
    }
    operatorDistance.add(distance)

    println("operatorDistance: $operatorDistance")
    println(lists)
    println(operator)

    // nach Länge zwischen Operatoren schauen und anhand dessen die Zahlen auffüllen






    var counter: Long = 0

    for (coloumIndex in 0..<lists[0].size) {
        var coloumCount: Long = 0
        val numbersInThisColoum = mutableListOf<Long>()
        for (k in 3 downTo 0) {
            val coloum = mutableListOf<Long>()
            for (j in 0..<lists.size) {
                coloum.add((lists[j][coloumIndex].toLong()))
            }
            var coloumNumber = ""
            coloum.forEach {
                try {
                    coloumNumber += it.toString().split("")[3 - k]
                } catch (_: IndexOutOfBoundsException) {}
            }
            if (coloumNumber.isNotEmpty()) numbersInThisColoum.add(coloumNumber.toLong())
        }
        numbersInThisColoum.forEach {
            if (operator[coloumIndex].equals("+")){
                coloumCount += it
            } else {
                if (coloumCount < 1) coloumCount++
                coloumCount *= it
            }
            println("SingleNumber: $it")
        }
        counter += coloumCount
        println("ColoumCount: $coloumCount")
    }
    println(counter)
}