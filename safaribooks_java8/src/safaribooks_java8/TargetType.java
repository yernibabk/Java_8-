package safaribooks_java8;

public class TargetType {
	
	public interface Email {
		public String constructEmail(String domain);
	}
	
	Email mail = (String name) -> name+"@socgen.com";
	
	public String getMail(String name, Email mail) {
		System.out.println("name:"+name+"mail:"+mail);
		return null;
	}
	
	public static void main(String args[]) {
		new TargetType().getMail("Mrs.", (String name) -> name+"@socgen.com");
	}

}
