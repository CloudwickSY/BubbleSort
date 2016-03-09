package Sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortUnittests {

	@Test
	public void testRandomGenerator() {
		assertEquals("failure - random generator failure", BubbleSort.randInt(1, 1), 1);
	}

	@Test
	public void testSetGet() {
		BubbleSort<Integer> bs = new BubbleSort<Integer>(Integer.class, 1);
		bs.set(0, 1);
		assertEquals("failure - random set/get failure", bs.get(0).intValue(), 1);
	}

	@Test
	public void testSort() {
		BubbleSort<Integer> bs = new BubbleSort<Integer>(Integer.class, 3);
		bs.set(0, 1);
		bs.set(1, 0);
		bs.set(2, 3);
		bs.sort();
		assertEquals("failure - sort failure", bs.get(0).intValue(), 0);
	}

	@Test
	public void testToString() {
		BubbleSort<Integer> bs = new BubbleSort<Integer>(Integer.class, 3);
		bs.set(0, 1);
		bs.set(1, 0);
		bs.set(2, 3);
		bs.sort();
		assertEquals("failure - toString failure", bs.toSting(), "0, 1, 3, ");
	}
}
