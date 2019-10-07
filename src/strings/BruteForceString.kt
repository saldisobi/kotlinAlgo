package strings

class BruteForceString {

    fun match(parent: String, sub: String) {

        for (i in 0 until parent.length) {

            for (j in 0 until sub.length) {
                if (parent[i + j] != sub[j]) {

                    break;
                }

                if (j == sub.length - 1) {
                    println("pattern fount at index $i")
                    return
                }
            }

        }

    }
}

fun main() {
    BruteForceString().match("saurach", "sau")
}