package Sorting;

import java.lang.reflect.Array;
import java.util.Random;

public class BubbleSort<E extends Comparable<E>> {
	private E[] a;

	/**
	 * Bubble sort implementation
	 * @param c the class type
	 * @param s the size of the array we wish to create
	 */
	public BubbleSort(Class<E> c, int s) {
		// Use Array native method to create array
		// of a type only known at run time
		@SuppressWarnings("unchecked")
		final E[] a = (E[]) Array.newInstance(c, s);
		this.a = a;
	}

	public static void main(String[] args) {
		int numElements = (int) Math.pow(10, 5);
		BubbleSort<Integer> bs = new BubbleSort<Integer>(Integer.class, numElements);
		// populate the array
		for (int index = 0; index < numElements; index++) {
			bs.set(index, randInt(0, numElements));
		}
		bs.print();// print the array
		double start = System.currentTimeMillis();
		bs.sort();// sort the array
		double stop = System.currentTimeMillis();
		bs.print();// print the sorted array
		System.out.println(stop - start);// print the execution time
	}

	/**
	 * Random Int generator for a specified range
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	/**
	 * This function sorts the ascending order
	 */
	public void sort() {
		int indexCur = 0, indexStop = a.length - 1, indexLastChange = 0;
		E eCur, eNext;
		while (indexCur < indexStop) {
			while (indexCur < indexStop) {
				eCur = a[indexCur];
				eNext = a[indexCur + 1];
				if (eCur.compareTo(eNext) > 0) {
					a[indexCur] = eNext;
					a[indexCur + 1] = eCur;
					indexLastChange = indexCur;
				}
				indexCur++;
			}
			indexCur = 0;
			indexStop = Math.min(indexStop - 1, indexLastChange);
		}
	}

	/**
	 * Prints to system.out the array
	 */
	public void print() {
		for (int index = 0; index < a.length; index++) {
			System.out.printf("%s, ", a[index].toString());
		}
		System.out.println();
	}

	/**
	 * Returns the element of the array at the specified index
	 * @param index the position we wish to return
	 * @return the element at the index specified
	 */
	E get(int index) {
		return a[index];
	}

	/**
	 * Sets the element of the array at the position index to be equal to the element provided
	 * @param index the index of the position we want to set
	 * @param element The element we want to set the array at the position of the index 
	 * @return the element at the index specified
	 */
	E set(int index, E element) {
		return a[index] = element;
	}
}