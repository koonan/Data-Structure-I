public interface ILinkedList {
	void add(int element,int index);
	//to add element to Lnkedlist in any valid index 
	
	void push (int element);
	//to set element to the tail
	
	int remove (int index);
	//to remova element;
	
	int pop ();
	//Remove the element in the tail and return it 
	
	void print ();
	//to print LinkedList
	
	int search(int element);
	//search for element in LinkedList

}
