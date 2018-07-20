package safaribooks_java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Optional is a container object used to contain not-null objects. 
 * Optional object is used to represent null with absent value. 
 * This class has various utility methods to facilitate code to handle values as ‘available’ 
 * or ‘not available’ instead of checking null values.
 * */
public class OptionalTypes {

	private void attendeesOptional() {
		List<Integer> attendees = Arrays.asList(21,2,23);
		Optional<Integer> attendeesOptional = attendees.stream().reduce(Integer::sum);
		System.out.println("attendeesOptional:"+attendeesOptional.get());
	}
	
	private void noAttendeesOptional() {
		List<Integer> attendees = Arrays.asList();
		Optional<Integer> noAttendeesOptional = attendees.stream().reduce(Integer::sum);
		
		//Exception in thread "main" java.util.NoSuchElementException: No value present
		//System.out.println("attendeesOptional:"+noAttendeesOptional.get());
		
		if(noAttendeesOptional.isPresent())
			System.out.println("noAttendeesOptional:"+noAttendeesOptional.get());
		
	}
	
	public void createOptionals() {
		
		Student student  = new Student();
		Optional<Student> optionalStudent = Optional.of(student);
		System.out.println("optionaStudent:"+optionalStudent.get());
		
/*		Student student1  = null;
		Optional<Student> optionalStudent1 = Optional.of(student1);
		System.out.println("optionaStudent:"+optionalStudent1.get()); ////Optional.of - throws NullPointerException if passed parameter is null
*/		
		student  = null;
		Optional<Student> studentOptional2 = Optional.ofNullable(student);
		System.out.println("Student can not be null:"+studentOptional2); ////Optional.ofNullable - allows passed parameter to be null.
	}
	
	private void ifElseOptionals() {
		Student student  = null;
		Student studentDefault = new Student();
		studentDefault.setsName("Rama..");
		Optional<Student> optionalStudent = Optional.ofNullable(student);
		String name = optionalStudent.orElse(studentDefault).getsName(); ////Instead of returning null value it returns default value
		
		//Optional.orElse - returns the value if present otherwise returns
		
		System.out.println("Name:"+name);
	}
	
	private void ifElseThrowOptional() throws Exception {
		Student student  = null;
		Optional<Student> studentOptional = Optional.ofNullable(student);
		studentOptional.orElseThrow(Exception::new); 
	}
	
	private void filterMapOptional() {
		Student st  = new Student();
		st.setsName("Laxmana");
		Optional<Student> stOptional = Optional.of(st);
		stOptional.filter(student -> student.hasTeacher()).ifPresent(System.out::println);
		stOptional.map(s -> s.getsName()).ifPresent(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OptionalTypes().attendeesOptional();
		new OptionalTypes().noAttendeesOptional();
		new OptionalTypes().createOptionals();
		new OptionalTypes().ifElseOptionals();
		try {
			new OptionalTypes().ifElseThrowOptional();
		} catch (Exception e) {
			System.out.println("Executed Exception:"+e);
		}
		new OptionalTypes().filterMapOptional();
	}

}
