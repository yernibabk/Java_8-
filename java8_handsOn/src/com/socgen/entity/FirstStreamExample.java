package com.socgen.entity;

import java.util.Arrays;
import java.util.List;

public class FirstStreamExample {
	
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
				new Product(100,"iphone X",99000.00,"mobile"),
				new Product(101,"Sony Bravia",125000.00,"tv"),
				new Product(102,"one +5T",45000.00,"mobile"),
				new Product(103,"Logitech",450.00,"computer"),
				new Product(104,"LG OLED",87000.00,"tv")
				);
		
		//traverse through product stream using consumer
		products.stream().forEach(p -> System.out.println(p.getName()));
		products.stream().forEach(System.out::println);
		System.out.println("************************");
		//transform using map
		Function<Product,String> f = p->p.getName();
		products.stream().map(f).forEach(System.out::println);
		System.out.println("************************");
		//Using Method Reference
		products.stream().map(Product :: getCategory).distinct().forEach(System.out::println);
		System.out.println("************************");
		//Print all mobiles
		products.stream().filter(p -> p.getCategory().equals("mobile")).map(f).forEach(System.out::println);
		System.out.println("************************");
		//Reduce as terminal operation.
		//Get the total cost of all tvs
		//Function<Input data type,Output data type)
		Function<Product,Double> f1 = p->p.getPrice();
		double total =  products.stream()
								.filter(p -> p.getCategory() != null) //for additional null check
								.filter(p -> p.getCategory().equals("tv"))
								.map(f1)
								.reduce(0.0,(first,second) -> first+second);
		System.out.println(total);
		System.out.println("************************");
		products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.sorted((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice())) //Sorting based on price
				.forEach(System.out::println);
		System.out.println("************************");
		//Collectors
		//Used to collect and then perform operations
		List<Product> tvs = products.stream()
									.filter(p->p.getCategory().equalsIgnoreCase("tv"))
									.collect(Collectors.toList());
		tvs.forEach(System.out::println);
		System.out.println("************************");
		
		Map<String, List<Product>> productMap = products.stream().collect(Collectors.groupingBy(Product :: getCategory));
		
		productMap.forEach((k,v) -> {
			System.out.println("Products of type"+k);
			v.forEach(p->System.out.println(p.getName() + "," + p.getPrice()));
		});
		
		System.out.println("************************");
		Map<String,Long> a = products.stream().collect(Collectors.groupingBy(Product :: getCategory, Collectors.counting()));
		System.out.println(a);
		System.out.println("************************");
		//Parallel stream for multiple threads
		products.parallelStream()
				.filter(p ->{
						System.out.println("Filter"+Thread.currentThread());
						return p.getCategory().equalsIgnoreCase("tv");
				})
				.sorted( (p1,p2) ->{
					System.out.println("Filter"+Thread.currentThread());
					return Double.compare(p1.getPrice(), p2.getPrice());
				})
				.forEach( p -> {
					System.out.println("For Each "+Thread.currentThread());
					System.out.println(p.getPrice());
				});
		System.out.println("************************");
		Stream<Product> ps = products.stream().filter(p-> p.getPrice() > 50000);
		ps.parallel().forEach(System.out::println); //Need to mention parallel if we want to make already defined stream work parallel 
		
		System.out.println("************************");
		int x = 100;
		products.stream().map(p->{
			int y = x+15; //the outer variables can be accessed inside(beauty - as it was not possible before to access the outer variables inside anonymous classes) 
			// only for access but not for mutation(when the outer variable is used inside,
			//the compiler instantly makes the outer variable as final - thus making it only accessible but cannot be modifiable.
			return p.getCategory();
		}).forEach(System.out::println);
		System.out.println("************************");
		//Integer Stream
		IntStream istream = IntStream.iterate(1,i->i+1);
			istream.skip(5)
				.limit(50)
				.forEach(System.out::println);
		System.out.println("************************");
		//Usage of FlatMap
		Stream<List<Integer>> s = Stream.of(Arrays.asList{1,4,7,9}, Arrays.asList{21.34.3127.49});
		//Stream<Integer> si = s.flatMap(p->p.stream());
		
	
	}

