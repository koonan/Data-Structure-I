package eg.edu.alexu.csd.ds.queue.cs37;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.ds.queue.MyLinkedList;

public class dlinkedlist implements MyLinkedList {
	private int size;
	private Dlistnode header, trailer;

	public dlinkedlist() {
		size = 0;
		header = new Dlistnode(null, null, null); // create header
		trailer = new Dlistnode(null, header, null); // create trailer
		header.next = trailer; // make header and trailer point to each other
	}

	@Override
	public void add(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

		/*
		 * Dlistnode newnode = new Dlistnode(element, null, null); if (index ==
		 * 0) { addfirst(newnode);
		 * 
		 * } else if (index > 0 && index <= size) { Dlistnode i = getfirst();
		 * for (int counter = 0; counter < index - 1; counter++) { i =
		 * getnext(i); } addafter(i, newnode);
		 * 
		 * } else { throw new IndexOutOfBoundsException(); }
		 */
		Dlistnode newnode = new Dlistnode(element, null, null);
		if (index == 0) {
			Dlistnode n = header.next;
			newnode.next = n;
			header.next = newnode;
			newnode.prev = header;
			n.prev = newnode;
			size++;
		} else if (index == size - 1) {
			add(element);
		} else if (index > 0 && index <= size) {
			Dlistnode i = header.next;
			for (int counter = 0; counter < index - 1; counter++) {
				i = i.next;
			}
			Dlistnode w = i.next;
			newnode.prev = i;
			newnode.next = w;
			i.next = newnode;
			w.prev = newnode;
			size++;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		Dlistnode newnode = new Dlistnode(element, null, null);

		if (size == 0) {
			Dlistnode i = header;
			newnode.next = trailer;
			newnode.prev = i;
			i.next = newnode;
			trailer.prev = newnode;
			size++;
		} else {
			Dlistnode i = trailer.prev;
			newnode.next = trailer;
			newnode.prev = i;
			i.next = newnode;
			trailer.prev = newnode;
			size++;
		}
	}

	@Override
	public Object get(int index) throws RuntimeException {
		// TODO Auto-generated method stub

		if (header.next == trailer) {
			throw new RuntimeErrorException(null);

		} else if (index < 0 || index >= size) {
			throw new RuntimeErrorException(null);
		} else {
			Dlistnode i = header.next;
			for (int counter = 0; counter < index; counter++) {
				i = i.next;
			}

			return i.value;
		}
	}

	@Override
	public void set(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index == 0) {
			Dlistnode i = header.next;
			i.value = element;
		} else if (index < size && index > 0) {
			Dlistnode i = header.next;
			for (int count = 0; count < index; count++) {
				i = i.next;
			}
			i.value = element;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		header.next = trailer;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index == 0 && header.next != trailer) {
			Dlistnode i = header.next;
			Dlistnode j = i.next;
			header.next = j;
			j.prev = header;
			i.next = null;
			i.prev = null;
			size--;
		} else if (index < size) {
			Dlistnode i = header.next;
			for (int count = 0; count < index; count++) {
				i = i.next;
			}
			Dlistnode w = i.next;
			Dlistnode z = i.prev;
			w.prev = z;
			z.next = w;
			i.next = null;
			i.prev = null;
			size--;

		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MyLinkedList list = new dlinkedlist();
		if (header.next == trailer) {
			return list;
		}
		if (fromIndex < 0 || fromIndex > size - 1 || toIndex < 0
				|| toIndex > size - 1 || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		Dlistnode i = header.next;
		int j = 0;
		for (int counter = 0; counter < fromIndex; counter++) {
			i = i.next;
		}

		for (int counter = fromIndex; counter <= toIndex; counter++) {
			list.add(j, i.value);
			i = i.next;
			j++;
		}
		return list;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (header.next == trailer) {
			return false;
		} else {
			Dlistnode i = header.next;
			for (int count = 0; count < size; count++) {
				if (i.value == o) {
					return true;
				}
				i = i.next;
			}
			return false;
		}

	}

	/*
	 * public Dlistnode getfirst() throws IndexOutOfBoundsException { if
	 * (isEmpty()) throw new IndexOutOfBoundsException("not exixt"); return
	 * header.getLinkNext(); }
	 * 
	 * public Dlistnode getlast() throws IndexOutOfBoundsException { if
	 * (isEmpty()) throw new IndexOutOfBoundsException("not exixt"); return
	 * trailer.getLinkPrev(); }
	 * 
	 * public Dlistnode getprev(Dlistnode req) throws IndexOutOfBoundsException
	 * { if (req == header) { throw new IndexOutOfBoundsException(); } return
	 * req.getLinkPrev(); }
	 * 
	 * public Dlistnode getnext(Dlistnode req) throws IndexOutOfBoundsException
	 * { if (req == trailer) { throw new IndexOutOfBoundsException(); } return
	 * req.getLinkNext(); }
	 * 
	 * public void addbefore(Dlistnode v, Dlistnode z) { Dlistnode u =
	 * getprev(v); z.setLinkPrev(u); z.setLinkNext(v); v.setLinkPrev(z); if (u
	 * == header) { header.setLinkNext(z); } else { v.prev.setLinkNext(z); }
	 * size++; }
	 * 
	 * public void addafter(Dlistnode b, Dlistnode a) { Dlistnode c =
	 * getnext(b); a.setLinkPrev(b); a.setLinkNext(c); c.setLinkPrev(a);
	 * b.setLinkNext(a); size++; }
	 * 
	 * public void addfirst(Dlistnode v) { addafter(header, v); }
	 * 
	 * public void addlast(Dlistnode v) { addbefore(trailer, v); }
	 * 
	 * public void print() { // TODO Auto-generated method stub Dlistnode i =
	 * header.next; while (i.next != trailer) { System.out.println(i.value); i =
	 * i.next; } }
	 */
}
