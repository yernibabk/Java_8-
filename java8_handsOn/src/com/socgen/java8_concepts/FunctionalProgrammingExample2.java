package com.socgen.java8_concepts;

import java.util.function.Function;

interface Operation<T,R>{
	R apply(T t);
	
	default <V> Operation<V,R> compose(Operation<? super V, ? extends T> before){
		return (V v) -> apply(before.apply(v));
	}
	
}

public class FunctionalProgrammingExample2 {

	public static void main(String[] args) {
		//Function<Input data type,Output data type)
		Function<Integer,Integer> f1 = (t) -> t+2;
		Function<Integer,Integer> f2 = (t) -> t*2;
		
		System.out.println(f1.apply(5));
		System.out.println(f1.apply(3));
		
		System.out.println(f1.compose(f2).apply(3));
		System.out.println(f1.andThen(f2).apply(3));
}
}


