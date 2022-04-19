import java.util.*
import kotlin.random.Random

class Solver(private var arr: MutableList<Double>) {

    private fun abs(arr: List<Double>): Double {
        val groups = arr.windowed(k, k).map { it.sum() }
        return groups.maxOf { it } - groups.minOf { it }
    }

    fun solve(): Pair<Double, List<Double>> {
        stupidSort()
        shuffling()
        randomSwap()
        return abs(arr) to arr
    }

    private fun Double.update(tmp: MutableList<Double>): Double {
        val cur = abs(tmp)
        if (cur < this) {
            arr = tmp
            return cur
        }
        return this
    }

    private fun shuffling() {
        var ans = abs(arr)
        repeat(iterations / 100) {
            ans = ans.update(arr.shuffled().toMutableList())
        }
    }

    private fun stupidSort() {
        val res = mutableListOf<Double>()
        val temp = LinkedList(arr.sorted())
        while (temp.isNotEmpty()) {
            res += temp.pollFirst()
            if (temp.isNotEmpty())
                res += temp.pollLast()
        }
        if (abs(arr) > abs(res)) {
            arr = res
        }
    }

    private fun randomSwap() {
        fun rand() = Random.nextInt(0, arr.size)
        var ans = abs(arr)
        repeat(iterations) {
            val tmp = arr.toMutableList()
            val (i, j) = rand() to rand()
            tmp[i] = tmp[j].also { tmp[j] = tmp[i] }
            ans = ans.update(tmp)
        }
    }
}