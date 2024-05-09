import org.junit.Assert.assertEquals
import org.junit.Test
import PriorityQueue

class PriorityQueueTest {
    @Test
    fun `extractMax returns descending order of priority`() {
        val priorityQueue = PriorityQueue()
        priorityQueue.insert(5)
        priorityQueue.insert(80)
        priorityQueue.insert(17)
        priorityQueue.insert(32)

        assertEquals(80, priorityQueue.extractMax())
        assertEquals(5, priorityQueue.extractMax())
        assertEquals(17, priorityQueue.extractMax())
        assertEquals(32, priorityQueue.extractMax())
    }
}
