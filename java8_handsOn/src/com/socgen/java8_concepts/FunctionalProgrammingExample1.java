package com.socgen.java8_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Consumer<T>{
	void accept(T t);
}

@FunctionalInterface
interface Predicate<T>{
	boolean test(T t);
}

public class FunctionalProgrammingExample1 {
	
	//OCP
	public static <T> List<T> filter(List<T> data, Predicate<T> predicate){
		List<T> values = new ArrayList<T>();
		for(T obj : data) {
			if(predicate.test(obj)) {
				values.add(obj);
			}
		}
		return values;
	}
	
	public static <T> void iterate(List<T> data, Consumer<T> consumer) {
		for(T obj : data) {
			consumer.accept(obj);
		}
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,66,2,7,93,25,60,12);
		/*List<Integer> evenList = filter(list,new Predicate<Integer>() {
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});*/
		
		//List<Integer> evenList = filter(list, t->t%2==0); //lambda expressions
		List<Integer> evenList =  filter(list, FunctionalProgrammingExample1  :: isEven); //Method Reference
		//System.out.println(evenList);
		iterate(evenList, t->System.out.println(t));
		iterate(evenList, System.out::println);//Method Reference - it can only be used where lambda is expected
	}
	
	private static boolean isEven(int no) {
		return no%2 == 0;
	}
}
