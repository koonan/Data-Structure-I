package eg.edu.alexu.csd.ds.queue.cs37;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.ds.queue.MyLinkedList;
import eg.edu.alexu.csd.ds.queue.MyQueue;

public class queue_linkedlist implements MyQueue {
	MyLinkedList Queue = new dlinkedlist();

	@Override
	public void enqueue(Object element) {
		// TODO Auto-generated method stub
		Queue.add(element);
	}

	@Override
	public Object dequeu() throws RuntimeErrorException{
		// TODO Auto-generated method stub
		if(!Queue.isEmpty()){
			Object get =Queue.get(0);
			Queue.remove(0);
			return get;
		}
		else{
			throw new RuntimeErrorException(null);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Queue.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Queue.size();
	}

}
