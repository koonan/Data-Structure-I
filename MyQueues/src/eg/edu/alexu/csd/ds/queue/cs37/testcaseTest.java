package eg.edu.alexu.csd.ds.queue.cs37;

import junit.framework.Assert;

import org.junit.Test;

import eg.edu.alexu.csd.ds.queue.MyQueue;

@SuppressWarnings("deprecation")
public class testcaseTest {
	MyQueue queue_array = new queue_array(5);
	MyQueue queue_linkedlist = new queue_linkedlist();

	@Test
	public void test1() {

		queue_array.enqueue(1);
		queue_array.enqueue(2);
		queue_array.enqueue(3);
		queue_array.enqueue(4);

		int expected = 1;
		for (int i = 0; i < 4; i++) {
			Assert.assertEquals(expected, queue_array.dequeu());
			expected++;
		}
	}

	@Test
	public void test2() {

		queue_linkedlist.enqueue(1);
		queue_linkedlist.enqueue(2);
		queue_linkedlist.enqueue(3);
		queue_linkedlist.enqueue(4);

		int expected = 1;
		for (int i = 0; i < 4; i++) {
			Assert.assertEquals(expected, queue_linkedlist.dequeu());
			expected++;
		}
	}

	@Test
	public void test3() {

		queue_array.enqueue(1);
		queue_array.enqueue(2);
		queue_array.enqueue(3);
		queue_array.enqueue(4);

		Assert.assertEquals(4, queue_array.size());
	}

	@Test
	public void test4() {

		queue_linkedlist.enqueue(1);
		queue_linkedlist.enqueue(2);
		queue_linkedlist.enqueue(3);
		queue_linkedlist.enqueue(4);

		Assert.assertEquals(4, queue_linkedlist.size());
	}

	@Test
	public void test5() {

		queue_array.enqueue(1);
		queue_array.enqueue(2);
		queue_array.enqueue(3);
		queue_array.enqueue(4);

		Assert.assertEquals(false, queue_array.isEmpty());
	}

	@Test
	public void test6() {

		queue_linkedlist.enqueue(1);
		queue_linkedlist.enqueue(2);
		queue_linkedlist.enqueue(3);
		queue_linkedlist.enqueue(4);

		Assert.assertEquals(false, queue_linkedlist.isEmpty());
	}

	@Test
	public void test7() {
		Assert.assertEquals(true, queue_array.isEmpty());
	}

	@Test
	public void test8() {
		Assert.assertEquals(true, queue_linkedlist.isEmpty());
	}

	@Test
	public void test9() {

		try {
			queue_array.dequeu();
			Assert.fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void test10() {

		try {
			queue_linkedlist.dequeu();
			Assert.fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void test11() {
		queue_linkedlist.enqueue(1);
		queue_linkedlist.enqueue(2);
		queue_linkedlist.enqueue(3);
		queue_linkedlist.enqueue(4);
		queue_linkedlist.dequeu();
		queue_linkedlist.dequeu();
		queue_linkedlist.dequeu();
		Assert.assertEquals(false, queue_linkedlist.isEmpty());
		Assert.assertEquals(4, queue_linkedlist.dequeu());


	}

	@Test
	public void test12() {
		queue_array.enqueue(1);
		queue_array.enqueue(2);
		queue_array.enqueue(3);
		queue_array.enqueue(4);
		queue_array.dequeu();
		queue_array.dequeu();
		queue_array.dequeu();
		Assert.assertEquals(false, queue_array.isEmpty());
		Assert.assertEquals(4, queue_array.dequeu());


	}

	@Test
	public void test13() {
		queue_array.enqueue(1);
		queue_array.enqueue(2);
		queue_array.enqueue(3);
		queue_array.enqueue(4);

		try {
			queue_array.enqueue(6);
			Assert.fail();
		} catch (Exception e) {

		}
	}

	public void test14() {

		Assert.assertEquals(0, queue_linkedlist.size());
		Assert.assertEquals(true, queue_linkedlist.isEmpty());

	}

	public void test15() {

		Assert.assertEquals(0, queue_array.size());
		Assert.assertEquals(true, queue_array.isEmpty());


	}

}
