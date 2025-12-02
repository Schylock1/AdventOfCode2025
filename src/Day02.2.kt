import java.util.Scanner

private var value: Long = 0

fun main() {
    val sc = Scanner(System.`in`)
    val firsts = mutableListOf<String>()
    val seconds = mutableListOf<String>()

    val line = sc.nextLine()

    line.split(",", "-").forEachIndexed { i, it ->
        if (i%2 == 0){
            firsts.add(it)
        } else {
            seconds.add(it)
        }
    }

    for (i in 0..firsts.size-1){
        for (j in firsts[i].toLong()..seconds[i].toLong()){
            if (j>10) {
                checkValid2(j.toString())
            }
        }
    }

    println(value)
}

fun checkValid2(numbers: String) {
    var invalid = false
    for (i in 1..numbers.length){
        if (numbers.length%i == 0 && i!=numbers.length){
            val partials = mutableListOf<String>()
            for (j in 0..<numbers.length/i){
//                println("j: $j")
                partials.add(numbers.substring(i*j,i*(j+1)))
            }
//            println("Partials: $partials")
//            println("i: $i")
            var everyPartEquals = true
            for (p in 0..partials.size-2){
                if (partials[p] != partials[p+1]){
                    everyPartEquals = false
                    break
                }
            }
            if (everyPartEquals){
                invalid = true
                break
            }
        }
    }
    if (invalid) {
        println("id: $numbers")
        value += numbers.toLong()
    }
}