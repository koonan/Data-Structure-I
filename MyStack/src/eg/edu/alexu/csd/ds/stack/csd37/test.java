package eg.edu.alexu.csd.ds.stack.csd37;

import junit.framework.Assert;

import org.junit.Test;

import eg.edu.alexu.csd.ds.stack.MyStack;





@SuppressWarnings("deprecation")
public class test {

	@Test
	public void test1() {
		MyStack s=new stack();
		s.add(0,'a');
		s.add(1,'b');
		s.add(2,'c');
		s.add(1,'h');
		s.add(0,'x');
		s.add(5,'z');
		Assert.assertEquals(6,s.size());
		
	}
	@Test
	public void test2() {
		MyStack l=new stack();
		l.add(0,'a');
		l.add(1,'b');
		l.add(2,'c');
		l.add(1,'h');
		l.add(0,'x');
		l.add(5,'z');
		Assert.assertEquals(false,l.isEmpty());
		
	}
	@Test
	public void test3() {
		MyStack l=new stack();
		l.add(0,'a');
		l.add(1,'b');
		l.add(2,'c');
		l.add(1,'h');
		l.add(0,'x');
		l.add(5,'z');
		Assert.assertEquals('z',l.peek());
	}
	@Test
	public void test4() {
		MyStack l=new stack();
		l.add(0,'a');
		l.add(1,'b');
		l.add(2,'c');
		l.add(1,'h');
		l.add(0,'x');
		l.pop();
		l.pop();
		Assert.assertEquals('h',l.peek());
	}
	@Test
	public void test5() {
		MyStack l=new stack();
		l.push('a');
		l.push('b');
		l.push('c');
		l.push('h');
		l.add(0,'z');
		Assert.assertEquals('h',l.peek());
	}
	@Test
	public void test6() {
		MyStack l=new stack();
		l.push('a');
		l.push('b');
		l.push('c');
		l.push('h');
		l.add(0,'z');
		try 
		{	
			l.add(7,'z');
			Assert.fail();
		}
		catch (Exception e) 
		{
		}
		
	}
	@Test
	public void test7() {
		MyStack l=new stack();
	
		try {
			l.peek();
			Assert.fail();
		}
		catch (Exception e) 
		{
		}
	}
	@Test
	public void test8() {
		MyStack l=new stack();
		
		try {
			l.peek();
			Assert.fail();
		}
		catch (Exception e) 
		{
		}
		
	}
	@Test
	public void test9() {
		MyStack l=new stack();
		l.push('A');
		l.push('B');
		l.push('C');
		l.push('D');
		l.add(3,'E');
		l.pop() ;
		l.pop() ;
		Assert.assertEquals('C',l.peek());
	}
	
}

