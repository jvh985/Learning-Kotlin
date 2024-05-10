import kotlin.random.Random

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

fun quickSort(arr: IntArray) {
    if (arr.size < 2) {
        //println("Array size < 2, returning")
        return // Base case: An empty array or an array with 1 element are already sorted
    }
    //println("Sorting array: ${arr.joinToString()}")
    modifiedQuickSort(arr, 0, arr.size - 1)
    //println("Sorted array: ${arr.joinToString()}")
}

private fun modifiedQuickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val randomIndex = randomPartition(arr, low, high) // Random index selection
        val (left, right) = threeWayPartition(arr, low, high, arr[randomIndex])

        // Recursively sort the arrays on each side of the pivot array
        modifiedQuickSort(arr, low, left -1)
        modifiedQuickSort(arr, right + 1, high)
    }
}

private fun randomPartition(arr: IntArray, low: Int, high: Int): Int {
    val randomIndex = Random.nextInt(low, high + 1)
    swap(arr, randomIndex, high)
    return partition(arr, low, high)
}

private fun partition(arr: IntArray, low: Int, high: Int): Int {
    val randomIndex = arr[high]
    var i = low - 1
    var j = low

    while(j <= high - 1) {
        if(arr[j] < randomIndex) {
            i++
            swap(arr, i, j)
        }

        j++
    }
    swap(arr, i + 1, high)
    return i + 1
}

private fun threeWayPartition(arr: IntArray, low: Int, high: Int, pivotIndex: Int): Pair<Int, Int> {
    var i = low
    var j = low
    var k = high

    while(j <= k) {
        // Kotlin uses `when` instead of `switch`
        when {
            arr[j] < pivotIndex -> {
                swap(arr, i, j)
                i++
                j++
            }
            arr[j] == pivotIndex -> j++
            else -> {
                swap(arr, j, k)
                k--
            }
        }
    }

    return i to k
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
