import java.io.File
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.*
import kotlin.system.measureTimeMillis

var k = 0
var iterations = 0

private fun parse(input: Scanner) = buildList {
    k = input.nextInt()
    while (input.hasNextDouble()) {
        add(input.nextDouble())
    }
    if (size % k != 0) {
        throw AssertionError(
            "Expected count of elements, that divides by $k"
        )
    }
}

fun main(args: Array<String>) {
    val argsMap = args.fold(emptyMap<String, String>() to "") { (map, lastKey), elem ->
        if (elem.startsWith('-')) map + (elem to "") to elem
        else map + (lastKey to elem) to ""
    }.first
    val input =
        if (argsMap.contains("-i")) {
            Scanner(File(argsMap["-i"]!!))
        } else {
            Scanner(System.`in`)
        }
    val output =
        if (argsMap.contains("-o")) {
            File(argsMap["-o"]!!).writer()
        } else {
            OutputStreamWriter(System.out)
        }
    iterations = argsMap["-c"]?.toInt() ?: 100000
    val attempts = argsMap["-a"]?.toInt() ?: 50
    val parallel = argsMap.contains("-p")
    val arr = parse(input)
    println(
        "Calculating with $iterations iterations and $attempts attempts in ${
            if (parallel) "parallel" else "single"
        } mode"
    )
    val ans: Pair<Double, List<Double>>
    println(
        "it took ${
            measureTimeMillis {
                ans = calc(parallel, attempts, arr)
            }
        }ms to calculate"
    )
    write(output, ans)
}

private fun calc(parallel: Boolean, attempts: Int, arr: List<Double>) =
    (if (parallel) {
        (1..attempts).toList().parallelStream()
            .map {
                Solver(arr.toList()).solve()
            }.toList()
    } else {
        List(attempts) {
            Solver(arr.toList()).solve()
        }
    }).minByOrNull { it.first } ?: throw AssertionError("Something went wrong")

private fun write(output: Writer, ans: Pair<Double, List<Double>>) = output.use {
    it.write("${ans.first}\n")
    it.write(ans.second.windowed(k, k).map { it to it.sum() }.joinToString("\n"))
    println("Result: ${ans.first}")
}