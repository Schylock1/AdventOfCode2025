import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)

    val lines = mutableListOf<MutableList<Boolean>>()
    var line = sc.nextLine()
    while (line.isNotEmpty()){
        lines.add(line.toString().map { (it == '@') } as MutableList<Boolean>)
        line = sc.nextLine()
    }

    var counter = 0

    lines.forEachIndexed { i, line ->
        line.forEachIndexed { j, it ->
            if (it && accessable(lines, i, j)) {
                counter++
            }
        }
    }

    println(counter)
}

fun accessable(lines: MutableList<MutableList<Boolean>>, posX: Int, posY: Int): Boolean{
    var neighbours = 0
    try { if (lines[posX-1][posY-1]) neighbours++ }   catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX-1][posY]) neighbours++ } catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX-1][posY+1]) neighbours++ }   catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX][posY-1]) neighbours++ } catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX][posY+1]) neighbours++ }   catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX+1][posY-1]) neighbours++ }   catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX+1][posY]) neighbours++ } catch (_: IndexOutOfBoundsException){}
    try { if (lines[posX+1][posY+1]) neighbours++ } catch (_: IndexOutOfBoundsException){}

    return (neighbours < 4)
}