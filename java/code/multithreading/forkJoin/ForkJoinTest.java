package forkJoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
	public static void main(String[] args){
		final int SIZE = 10000000;
		double[] numbers = new double[SIZE];
		for(int i=0;i<SIZE;i++) numbers[i] = Math.random();
		Counter counter = new Counter(numbers,0,numbers.length,
				new Filter(){
			public boolean accept(double x) {return x > 0.5;}
		});
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println(counter.join());
	}
}


