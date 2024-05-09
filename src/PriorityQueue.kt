import kotlin.math.max

class PriorityQueue {
    private val heap = mutableListOf<Int>()

    fun insert(priorityNum: Int) {
        heap.add(priorityNum)
        heapifyUp(heap.size -1)
    }

    fun extractMax(): Int? {
        if(heap.isEmpty()) return null

        val maxVal = heap[0]
        heap[0] = heap.last()
        heap.removeAt(heap.size -1)
        heapifyDown(0)
        return maxVal
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        var parentIndex = getParent(currentIndex)

        while(parentIndex >= 0 && heap[currentIndex] > heap[parentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = getParent(currentIndex)
        }

    }
    private fun heapifyDown(index: Int) {
        var currentIndex = index
        var leftChild = getLeftChild(currentIndex)
        var rightChild = getRightChild(currentIndex)
        var largestIndex = currentIndex

        if(leftChild < heap.size && heap[leftChild] > heap[largestIndex]) {
            largestIndex = leftChild
        }

        if(rightChild < heap.size && heap[rightChild] > heap[largestIndex]) {
            largestIndex = rightChild
        }

        if(largestIndex != currentIndex) {
            swap(currentIndex, largestIndex)
            heapifyDown(largestIndex)
        }
    }

    private fun swap(i: Int, j: Int) {
        val tempValue = heap[i]
        heap[i] = heap[j]
        heap[j] = tempValue
    }

    private fun getParent(index: Int): Int {
        return (index -1)/2
    }

    private fun getLeftChild(index: Int): Int {
        return index * 2 + 1
    }

    private fun getRightChild(index: Int): Int {
        return index * 2 + 2
    }
}