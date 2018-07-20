package safaribooks_java8;

public class RunnableExample {

	public void methodAcceptingRunnable(Runnable r) {
	 System.out.println(r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = () -> System.out.println("from Run");
		new RunnableExample().methodAcceptingRunnable(runnable);
		
	}

}
