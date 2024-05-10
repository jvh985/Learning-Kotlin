import java.math.BigDecimal
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/*  Keyboard shortcuts:
    ⌃ ␣ :brings up completion items
    ⌥ ⏎ :brings up intentions/context actions
    ⇧shift x2 :brings up search everywhere - includes IDE actions
    ⌥ ↑ :to start selecting words, then lines, then blocks
    ⌥ ↓ :reverse of above
    ⌘ / :comments out full line of code, again will undo
    ⌥ ⌘ / :will create block comments
    ⌥ ⇧shift ↑ or ↓ :will move lines of code up or down
    ⇧shift ⌘ ↑ or ↓ :will move entire functions up or down through the code
    ⌘ - or = will collapse / expand code region
    ⌥ ⌘ T :will surround selected code to add template code ie: try/catch
    ⌃ G and ⌃ ⌘ G :will select the symbol at caret / select all symbols with the same name

*/

// Getting used to the syntax of Kotlin and Intellij IDE

fun main() {
    println("hello world")

    val name = "random person"
    val clubs = 10
    var teams = 10  // mutable type
    val total = 25.60.toBigDecimal()
    val myArray = intArrayOf(90, 2, 2, 4, 15, 82, 42, 4, 5, 22, 1)
    val stringArray = arrayOf("dog", "cat", "bird", "hippo")

    // clubs ++  error: val is read-only

    teams += 4  // teams == 14
    teams -= 2  // teams == 12
    teams *= 2  // teams == 24
    teams /= 3  // teams == 8
    teams ++    // teams == 9
    teams --    // teams == 8

    println("number of teams: $teams")
    println("number of clubs: $clubs")

    println("hello $name")

    val condition = true

    if (condition) {
        println("test for condition bool type")
    }
    else {
        println("error")
    }

    if (!condition) {
        println("condition set to false")
    }
    else{
        println("condition set to true")
    }

    val shipping: String = "%.2f".format(calculateShipping(total))

    println("Shipping cost is: $${shipping}")

    println("The original unsorted list is: ${myArray.joinToString()}")
    mergeSort(myArray)
    println("The sorted list now reads: ${myArray.joinToString()}")

    println(stringArray.joinToString(" - "))

    println("\n--------------------------------------\n")

    println(stringArray.joinToString("\n"))

    println("\n--------------------------------------\n")

    for (element in stringArray){
        println(element)
    }

    println("\n--------------------------------------\n")

    stringArray.forEach { println(it) }

    println("\n--------------------------------------\n")

    val priorityQueue = PriorityQueue()
    priorityQueue.insert(55)
    priorityQueue.insert(13)
    priorityQueue.insert(41)
    priorityQueue.insert(2)
    priorityQueue.insert(80)

    println("Max element: ${priorityQueue.extractMax()}")

    println("\n--------------------------------------\n")

    val size = 100000
    val random = Random.Default

    val jumbledArray = intArrayOf(22, 11, 44, 66, 1, 3, 65, 11, 101, 3, 11, 67, 11, 81)
    val mergeRandomArray = IntArray(size) {random.nextInt()}

    val mergeTime = measureTimeMillis {
        mergeSort(jumbledArray)
    }

    println("mergeSort sorted values: ${jumbledArray.joinToString()}")
    println("Time for mergeSort: $mergeTime milliseconds")

    val mergeTime2 = measureTimeMillis {
        mergeSort(mergeRandomArray)
    }

    println("Time for larger mergeSort: $mergeTime2 milliseconds")

    println("\n--------------------------------------\n")

    val unsortedArray = intArrayOf(1, 222, 33, 4, 67, 33, 34, 51, 111, 33, 65, 1, 29, 343)
    val quickRandomArray = IntArray(size) {random.nextInt()}

    val quickTime = measureTimeMillis {
        quickSort(unsortedArray)
    }

    println("quickSort sorted values: ${unsortedArray.joinToString()}")
    println("Time for quickSort: $quickTime milliseconds")

    val quickTime2 = measureTimeMillis {
        quickSort(quickRandomArray)
    }
    println("Time for larger quickSort: $quickTime2 milliseconds")

}

fun calculateShipping(total:BigDecimal): BigDecimal {
    val shippingCost:BigDecimal

    if(total < 35.00.toBigDecimal()) {
        shippingCost = 5.00.toBigDecimal()
    }
    else shippingCost = 0.00.toBigDecimal()

    return shippingCost
}
