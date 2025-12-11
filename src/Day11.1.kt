import java.util.Scanner

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

    val rootNode = lines.removeAt(lines.indexOfFirst { it.first == "you" })
    val root = Node(rootNode.first)
    rootNode.second.forEach { root.addChild(makeTree(lines, it)) }

    println(findLeafs("out", root))

}

fun makeTree(lines: MutableList<Pair<String, MutableList<String>>>, key: String): Node<String> {
    if (key.equals("out") || key.equals("you")) return Node(key)
    val thisNode = lines[lines.indexOfFirst { it.first == key }]
    val node = Node(thisNode.first)
    thisNode.second.forEach { if (!node.hasThisParentOrSelf(it)) node.addChild(makeTree(lines, it)) }
    return node
}

fun findLeafs(key: String, node: Node<String>): Int {
    if (node.value.equals(key)) return 1
    var count = 0
    node.children.forEach { count += (findLeafs(key, it)) }
    return count
}

data class Node<String>(var value: String) {
    var parent: Node<String>? = null
    var children: MutableList<Node<String>> = mutableListOf()

    fun addChild(node: Node<String>) {
        children.add(node)
        node.parent = this
    }

    fun hasThisParentOrSelf(key: String): Boolean {
        if (value!!.equals(key)) return true
        if (parent == null) return false
        return parent!!.hasThisParentOrSelf(key)
    }
}