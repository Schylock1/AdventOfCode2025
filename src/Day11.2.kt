import java.util.Scanner

//////////////////////////////////////
// Funktioniert nicht: läuft endlos //
//////////////////////////////////////

fun main(){
    val sc = Scanner(System.`in`)
    val lines = mutableListOf<Pair<String, MutableList<String>>>()
    var line = sc.nextLine()
    while(line.isNotEmpty()){
        val splittedLine = line.split(" ").toMutableList()
        val key = splittedLine.removeAt(0).removeSuffix(":")
        lines.add(Pair(key, splittedLine))
        line = sc.nextLine()
    }

    val rootNode = lines.removeAt(lines.indexOfFirst { it.first == "svr" })
    val root = Node(rootNode.first)
    rootNode.second.forEach { root.addChild(makeTree2(lines, it)) }

    println(findLeafsThroughDacFft("out", root))

}

fun makeTree2(lines: MutableList<Pair<String, MutableList<String>>>, key: String): Node<String> {
    if (key.equals("svr") || key.equals("out")) return Node(key)
    val thisNode = lines[lines.indexOfFirst { it.first == key }]
    val node = Node(thisNode.first)
    thisNode.second.forEach { if (!node.hasThisParentOrSelf(it)) node.addChild(makeTree2(lines, it)) }
    return node
}

fun findLeafsThroughDacFft(key: String, node: Node<String>): Int {
    if (node.value.equals(key)) {
        if (node.hasThisParentOrSelf("dac") && node.hasThisParentOrSelf("fft")) return 1
        else return 0
    }
    var count = 0
    node.children.forEach { count += (findLeafsThroughDacFft(key, it)) }
    return count
}