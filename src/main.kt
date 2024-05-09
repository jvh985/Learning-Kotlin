import java.math.BigDecimal
import PriorityQueue

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


}

fun calculateShipping(total:BigDecimal): BigDecimal {
    val shippingCost:BigDecimal

    if(total < 35.00.toBigDecimal()) {
        shippingCost = 5.00.toBigDecimal()
    }
    else shippingCost = 0.00.toBigDecimal()

    return shippingCost
}

// sorting algorithms

fun mergeSort (myArray: IntArray) {
    if (myArray.size <= 1) return

    // logic to split the array
    val middleOfArray = myArray.size / 2
    val leftArray = myArray.copyOfRange(0, middleOfArray)
    val rightArray = myArray.copyOfRange(middleOfArray, myArray.size)

    // recursion to get to 1 element in each half, then sort with merge()
    mergeSort(leftArray)
    mergeSort(rightArray)

    // will sort each half of the array and then final pass will merge both together
    merge(myArray, leftArray, rightArray)
}

fun merge(array: IntArray, leftArray: IntArray, rightArray: IntArray) {
    var i = 0
    var j = 0
    var k = 0

    while (i < leftArray.size && j < rightArray.size){
        if (leftArray[i] <= rightArray[j]){
            array[k] = leftArray[i]
            i++
        }
        else {
            array[k] = rightArray[j]
            j++
        }
        k++
    }

    while (i < leftArray.size) {
        array[k] = leftArray[i]
        i++
        k++
    }

    while (j < rightArray.size) {
        array[k] = rightArray[j]
        j++
        k++
    }
}
