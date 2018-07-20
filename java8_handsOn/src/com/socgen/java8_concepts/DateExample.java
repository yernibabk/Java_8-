package com.socgen.java8_concepts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateExample {

	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate d1 = LocalDate.of(2015, 12, 25);
		System.out.println(d1);
		
		LocalDate d2 = LocalDate.now(ZoneId.of("Asia/Calcutta"));
		System.out.println(d2);
		
		LocalDate d3 =  d2.plusDays(100);
		System.out.println(d3);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
	}
}
