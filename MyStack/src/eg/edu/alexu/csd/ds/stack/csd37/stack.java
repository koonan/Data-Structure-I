package eg.edu.alexu.csd.ds.stack.csd37;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.ds.stack.MyLinkedList;
import eg.edu.alexu.csd.ds.stack.MyStack;

public class stack implements MyStack {
	MyLinkedList list = new singlelinkedlist();


	@Override
	public void add(int index, Object element) throws RuntimeException {
		// TODO Auto-generated method stub
		if (index > list.size()) {
			throw new RuntimeErrorException(null);
		} else {
			list.add(list.size()-index, element);
		}
	}

	@Override
	public Object pop() throws RuntimeException {
		// TODO Auto-generated method stub
		if (list.size() == 0) {
			throw new RuntimeErrorException(null);
		}
		Object get = list.get(0);
		list.remove(0);
		return get;
	}

	@Override
	public Object peek() throws RuntimeException {
		// TODO Auto-generated method stub
		if (list.size() == 0) {
			throw new RuntimeErrorException(null);
		}
		Object get = list.get(0);
		return get;
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
			list.add(0,element);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (list.isEmpty());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (list.size());
	}
}
