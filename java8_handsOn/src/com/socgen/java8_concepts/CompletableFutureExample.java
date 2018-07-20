package com.socgen.java8_concepts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<List<Integer>> cf = CompletableFuture.supplyAsync(CompletableFutureExample::getData);
		Thread.sleep(100);
		cf.complete(Arrays.asList()); //Alternate Data instead of actual data - like the scenarios where actual data is not returned 
		//and instead you can use this alternate data by using complete
		
		//cf.get().forEach(System.out::println);
		
		cf.thenApply(data -> {
			return data.stream().filter(d -> d%2==0);
		}).thenAccept(result ->{
			result.forEach(System.out::println);	
		});
		
		
		
		cf.join();
		//CompletableFuture<Void> cf2 = CompletableFuture.runAsync(()-> System.out.println("Hello World"));
		
		//cf2.join();
	}
	
	private static List<Integer> getData(){
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		return Arrays.asList(45,2,65,782,89,8);
	}
}
