package com.socgen.java8_concepts;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		//opt.ifPresent(System.out::println);
		System.out.println(opt.orElse("No Name"));
		System.out.println(opt.orElseGet(OptionalExample::getData));
	}
	
	private static String getData() {
		return "some Data";
	}
}
