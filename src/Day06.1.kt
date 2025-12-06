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

    lists.forEach { line ->
        line.removeAll { it.isEmpty() }
    }
    operator.removeAll{ it.isEmpty() }

    var counter: Long = 0

    for (i in 0..<lists[0].size){
        var smallCount: Long = 0
        for (j in 0..<lists.size){
            if (operator[i].equals("+")){
                smallCount += lists[j][i].toLong()
            } else {
                if (smallCount < 1) smallCount++
                smallCount *= lists[j][i].toLong()
            }
        }
        counter += smallCount
//        println("SmallCount: $smallCount")
    }

    println(counter)
}