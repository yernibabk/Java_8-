package safaribooks_java8;

public class LambdaScope extends SuperFamily{
	
	private String member = "GRANDPA";
	public interface Family {
		String who(String member);
	}
	
	public void testMember(String member) {
		System.out.println("local member:"+member);
		System.out.println("family member:"+this.member);
		System.out.println("family member:"+super.member);
		
		Family fmly = (String name) -> {
		
			System.out.println("The Lambda member:"+name);
			System.out.println("local member:"+member);
			System.out.println("family member:"+this.member);
			System.out.println("family member:"+super.member);
			return name;
		};
		
		fmly.who(member);
		
	}
	public static void main(String[] args) {
		new LambdaScope().testMember("SON");
	}

}
