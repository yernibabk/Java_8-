package com.socgen.java8_concepts;

public class VAVRFunctionExample {

	
	public static void main(String[] args) {
		
		Function2<Integer,Integer,Integer> f1 = (x,y) -> x/y; //Partial Function
		
		System.out.println(f1.apply(8,5));
		
		Function2<Integer,Integer, Option<Integer>> f2 = Function2.lift(f1);
		System.out.println(f2.apply(8,2).get());
		
		
	}
}
