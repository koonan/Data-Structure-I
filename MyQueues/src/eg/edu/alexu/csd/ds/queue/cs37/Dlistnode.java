package eg.edu.alexu.csd.ds.queue.cs37;

public class Dlistnode {

	public Object value;
	public Dlistnode next;
	public Dlistnode prev;
	public Dlistnode(Object s,Dlistnode a,Dlistnode b) {
		this.prev=a;
		this.next=b;
		this.value= s;
	}
	 public Dlistnode()
	    {
	        next = null;
	        prev = null;
	        value = 0;
	    }
	 /* Function to set link to next node */
    public void setLinkNext(Dlistnode n)
    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrev(Dlistnode p)
    {
        prev = p;
    }    
    /* Funtion to get link to next node */
    public Dlistnode getLinkNext()
    {
        return next;
    }
    /* Function to get link to previous node */
    public Dlistnode getLinkPrev()
    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(Object d)
    {
        value = d;
    }
    /* Function to get data from node */
    public Object getData()
    {
        return value;
    }
}
