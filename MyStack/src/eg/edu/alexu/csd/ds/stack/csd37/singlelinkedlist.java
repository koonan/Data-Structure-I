package eg.edu.alexu.csd.ds.stack.csd37;

import eg.edu.alexu.csd.ds.stack.MyLinkedList;

public class singlelinkedlist implements MyLinkedList {
	private listnode head = null;
	private int size = 0;
	listnode getHead() {
		return head;
	}

	public void setHead(listnode head) {
		this.head = head;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public void add(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index <= getSize()) {

			listnode newnode = new listnode(element);
			if (index == 0) {
				newnode.next = getHead();
				setHead(newnode);
			} else {
				listnode i = getHead();
				for (int count = 0; count < index - 1; count++) {
					i = i.next;
				}
				newnode.next = i.next;
				i.next = newnode;
			}
			setSize(getSize() + 1);
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		listnode newnode = new listnode(element);
		newnode.next = null;
		listnode i = getHead();
		if (getHead() != null) {
			while (i.next != null) {
				i = i.next;
			}
			i.next = newnode;
		} else {
			setHead(newnode);
		}
		setSize(getSize() + 1);
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		listnode i = getHead();
		for (int index1 = 0; index < getSize(); index1++) {
			if (index1 == index) {
				return i.value;
			}
			i = i.next;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void set(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		listnode i = getHead();
		if (getHead() != null && index < getSize()) {
			for (int i1 = 0; i1 < getSize(); i1++) {
				if (i1 == index) {
					i.value = element;
					return;
				}
				i = i.next;
			}
		}

		throw new IndexOutOfBoundsException();

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		setHead(null);
		setSize(0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (getHead() == null) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (getHead() != null && index <= getSize() - 1) {
			if (index == 0) {
				setHead(getHead().next);
			}

			else {
				listnode i = getHead();
				for (int count = 0; count < index - 1; count++) {
					i = i.next;
				}
				listnode j = i.next;
				i.next = j.next;
				setSize(getSize() - 1);
			}
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		listnode i = getHead();
		int k = 0;
		while (i != null) {
			k++;
			i = i.next;
		}
		return k;
	}

	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		MyLinkedList sublist = new singlelinkedlist();

		if (getHead() == null) {
			return sublist;
		} else if (fromIndex < 0 || fromIndex > getSize() - 1 || toIndex < 0
				|| toIndex > getSize() - 1) {
			throw new IndexOutOfBoundsException();
		}
		listnode i = getHead();
		int j = 0;
		for (int counter = 0; counter < fromIndex; counter++) {
			i = i.next;
		}

		for (int counter = fromIndex; counter <= toIndex; counter++) {
			sublist.add(j, i.value);
			i = i.next;
			j++;
		}
		return sublist;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		listnode i = getHead();
		if (getHead() == null) {
			return false;
		}
		for (int index = 0; index < getSize(); index++) {
			if (o == i.value) {
				return true;
			}
			i = i.next;
		}
		return false;
	}

	public void print() {
		// TODO Auto-generated method stub
		listnode i = getHead();
		while (i.next != null) {
			System.out.println(i.value);
			i = i.next;
		}
	}
	

	

}
