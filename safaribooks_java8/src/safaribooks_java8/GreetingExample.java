package safaribooks_java8;

public class GreetingExample {

	interface GreetMessage {
		public String sayHello(String msg);
	}
	
	public void testGreeting(String name, GreetMessage gm) {
		String result = gm.sayHello(name);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//(String msg) -> "Hello"+ gm
		new GreetingExample().testGreeting("Babu", (String msg) -> "Hello, "+msg);
		
		//(String p) -> !p.isEmpty() ? "Howdy"+p : "Did you mis something?"
		new GreetingExample().testGreeting("", (String p) -> !p.isEmpty() ? "Howdy"+p : "Did you mis something?");
		
	}

}
