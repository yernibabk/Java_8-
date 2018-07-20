package safaribooks_java8;

public class MethodReference {

	interface IMovie {
		public boolean check(int id);
	}

	public void testStaticMethodReference() {

		IMovie m1 = (id) -> id < 100 ? true : false;
		IMovie m2 = MethodReference::isClassic;
	}

	public static boolean isClassic(int mid) {
		boolean classicVal = false;
		if (mid < 100) {
			return classicVal = true;
		}
		return classicVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodReference client = new MethodReference();

	}

}
