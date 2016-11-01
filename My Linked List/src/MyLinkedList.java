
public class MyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.add(1,0); //1
		l.add(2,1); //1,2
		l.print();
		System.out.println();
		l.add(3, 3); //operation not valid !
		l.push(3); //1,2,3
		l.print();
		System.out.println();
		System.out.println("Size = " +l.length());
		l.remove(3); //Operation not valid !
		l.remove(2); //1,2
		l.print();
		System.out.println();
		System.out.println("size= "+l.length());
		l.pop();//1
		l.print();
	//	l.clear();  // clear Linked List
	//	l.print();
		System.out.println();
		System.out.println("size= "+l.length());
		l.add(2, 1); //1 2
		System.out.println(l.search(2)); //-1 for not found
		System.out.println(l.search(5));
		l.clear();
		l.print(); //empty
		
		
	}

}
