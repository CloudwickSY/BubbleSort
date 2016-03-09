package Sorting;

import java.lang.reflect.Array;
import java.util.Random;

public class BubbleSort<E extends Comparable<E>> {
	private E[] a;

	public BubbleSort(Class<E> c, int s) {
		// Use Array native method to create array
		// of a type only known at run time
		@SuppressWarnings("unchecked")
		final E[] a = (E[]) Array.newInstance(c, s);
		this.a = a;
	}
	
	public static void main(String[] args){
		int numElements = (int) Math.pow(10,3);
		BubbleSort<Integer> bs = new BubbleSort<Integer>( Integer.class, numElements);
		
		for (int index = 0; index< numElements;index++){
			bs.set(index, randInt(0,numElements));
		}
		
		bs.print();
		double start = System.currentTimeMillis();
		bs.sort();
		double stop = System.currentTimeMillis();
		bs.print();
		System.out.println(stop-start);
	}

	public static int randInt(int min, int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public void sort(){
	    	int indexCur = 0, indexStop = a.length-1, indexLastChange = 0;
	    	E eCur, eNext;
	    	while(indexCur<indexStop){
	    		while(indexCur<indexStop){
	    			eCur = a[indexCur];
	    			eNext = a[indexCur+1];
	    			if(eCur.compareTo(eNext)>0){
	    				a[indexCur] = eNext;
	    				a[indexCur+1] = eCur;
	    				indexLastChange = indexCur;
	    			}
	    			indexCur++;
	    		}
	    		indexCur = 0;
	    		indexStop = Math.min(indexStop-1, indexLastChange);
	    	}
	    }

	public void print() {
		for (int index = 0; index < a.length; index++) {
			System.out.printf("%s, ", a[index].toString());
		}
		System.out.println();
	}

	E get(int index) {
		return a[index];
	}

	E set(int index, E element) {
		return a[index] = element;
	}
}