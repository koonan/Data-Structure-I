package eg.edu.alexu.csd.ds.queue;

public interface MyQueue {
	/**
	 * Inserts an item at the queue front.
	 */
	public void enqueue(Object element);
	/**
	 * Removes the object at the queue rear and returns it.
	 */
	public Object dequeu();
	/**
	 * Tests if this queue is empty.
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in the queue
	 */
	public int size();
}
