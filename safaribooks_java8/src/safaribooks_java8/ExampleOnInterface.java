package safaribooks_java8;

public class ExampleOnInterface {

	interface Employee {
		
		public Employee find(int id);
		
		default boolean isExec() {
			return true;
		}
		
		static int getSal() {
			return 1000;
		}
	}
	
	public static void main(String[] args) {
		
		class EmployeeImpl implements Employee {
			
			@Override
			public Employee find(int id) {
				boolean val = isExec();
				return null;
			}
		}
		
		EmployeeImpl impl = new EmployeeImpl();
		System.out.println("val:"+impl.isExec());
		System.out.print(Employee.getSal());

	}

}
