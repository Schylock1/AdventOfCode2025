import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)

    var lines = mutableListOf<MutableList<Boolean>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()){
        lines.add(line.toString().map { (it == '@') } as MutableList<Boolean>)
        line = sc.nextLine()
    }

    var counter = 0

    val result = lines.toMutableList()

    var somethingChanged = true
    while (somethingChanged){
        somethingChanged = false

        lines.forEachIndexed { i, line ->
            line.forEachIndexed { j, it ->
                if (it && accessable(lines, i, j)) {
                    counter++
                    result[i][j] = false
                    somethingChanged = true
                }
            }
        }
        lines = result.toMutableList()
    }

    println(counter)
}