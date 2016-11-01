public class LinkedList implements ILinkedList {
	private ListNode head = null;
	private ListNode tail = null;
	int size = 0;

	public void add(int element, int index) {
		ListNode newNode = new ListNode(element);
		if (index <= size) {
			if (index == 0) {
				newNode.next = head;
				head = newNode;
				size++;
			} else {
				ListNode i = head;
				for (int count = 0; count < index - 1; count++) {
					i = i.next;
				}
				newNode.next = i.next;
				i.next = newNode;
				size++;
			}
		} else {
			System.out.println("This index is not Valid !!");
		}
	}

	public void push(int element) {
		ListNode newNode = new ListNode(element);
		newNode.next = null;
		ListNode i = head;
		if (head != null) {
			while (i.next != null) {
				i = i.next;
			}
			i.next = newNode;
		} else {
			head = newNode;
		}
		size++;
	}

	public int remove(int index) {
		while (head != null && index <= size - 1) {
			if (index == 0) {
				int result = head.value;
				head = head.next;
				size--;
				return result;

			} else {
				ListNode i = head;
				for (int count = 0; count < index - 1; count++) {
					i = i.next;
				}
				int result = i.value;
				ListNode j = i.next;
				i.next = j.next;
				size--;
				return result;
			}
		}
		System.out.println("Invalid Operation");
		return 0;
	}

	public int pop() {
		ListNode i = head;
		ListNode j = head;
		while (i.next != null) {
			j = i;
			i = i.next;
		}
		j.next = null;
		size--;
		return i.value;
	}

	void clear() {
		head = null;
	}

	int length() {
		int len = size;
		return len;

	}

	public void print() {
		ListNode i = head;
		while (i != null) {
			System.out.print(i.value);
			i = i.next;
		}

	}

	public int search(int element) {
		ListNode i = head;
		int index = 0;

		do {
			if (i.value == element) {
				return index;
			}
			index++;
			i = i.next;

		} while (index < size);
		return -1;

	}

}