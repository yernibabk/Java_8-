package com.socgen.java8_concepts;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

	public static void main(String[] args) {
		
		int[] values = { 45,2,6,27,2,36,72,763,32};
		//int[] values = {10,10,10,10,10,10};
		int cpus = Runtime.getRuntime().availableProcessors();
		ForkJoinPool forkJoin = new ForkJoinPool(cpus);
		int result = forkJoin.invoke(new Sum(values,0,values.length));
		System.out.println(result);
		
	}
	
}

class Sum extends RecursiveTask<Integer> {
	
	private int[] data;
	private int start;
	private int end;
	private static int THRESHOLD = 3;
	
	public Sum(int[] data, int start, int end) {
		
		super();
		this.data = data;
		this.start = start ;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		if(end-start < THRESHOLD) {
			int total = 0 ;
			for ( int i= start; i < end ;i++) 
				{
					total += data[i];
				}
			return total;
		}
		else {
			System.out.println(Thread.currentThread());
			//int len = values.length;
			int mid = start + (end-start)/2;
			System.out.println("mid"+mid);
			Sum leftTask = new Sum(data,start,mid);
			Sum rightTask = new Sum(data,mid,end);
			
			int leftAns = leftTask.compute();
			rightTask.fork();
			
			int rightAns = rightTask.join();
			return leftAns+rightAns;
			
		}
	}
}