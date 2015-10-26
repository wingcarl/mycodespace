package forkJoin;

import java.util.concurrent.RecursiveTask;

public class Counter extends RecursiveTask<Integer>{
	public static final int THRESHOLD = 100;
	private double[] values;
	private int from;
	private int to;
	private Filter filter;
	
	public Counter(double[] values, int from, int to, Filter filter) {
		super();
		this.values = values;
		this.from = from;
		this.to = to;
		this.filter = filter;
	}

	@Override
	protected Integer compute() {
		if(to - from < THRESHOLD){
			int count = 0;
			for(int i=from; i<to; i++){
				if(filter.accept(values[i])) count++;
			}
			return count;
		}else{
			int mid = (from + to)/2;
			Counter first = new Counter(values,from,mid,filter);
			Counter second = new Counter(values,mid,to,filter);
			invokeAll(first,second);
			return first.join()+second.join();
		}
		
	}
}
