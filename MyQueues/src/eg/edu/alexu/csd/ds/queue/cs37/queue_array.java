package eg.edu.alexu.csd.ds.queue.cs37;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.ds.queue.MyQueue;

public class queue_array implements MyQueue {
	private int front, rear;
	private int maxsize;
	private Object array [];
	public queue_array(int n){
		front=rear=-1;
		maxsize=n;	
		array= new Object[maxsize];
	}
	@Override
	public void enqueue(Object element) throws RuntimeErrorException{
		// TODO Auto-generated method stub
		if(size()==maxsize-1){
			throw new RuntimeErrorException(null);
		}
		rear=(rear+1)%maxsize;
		array[rear]=element;
	}
	@Override
	public Object dequeu() throws RuntimeException{
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new RuntimeErrorException(null);
		}
		else{
			front=(front+1)%maxsize;
			Object get =array[front];
			array[front]=null;
			return get;
		}
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (front==rear);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ((maxsize-front+rear)%maxsize);
	}
	public boolean isFull(){
		return (front==(rear+1)%maxsize);
	}
	
}
