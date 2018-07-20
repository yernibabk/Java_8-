package safaribooks_java8;

public class Student {
	
private String sName;
private int sNo;


public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public int getsNo() {
	return sNo;
}
public void setsNo(int sNo) {
	this.sNo = sNo;
}

public boolean hasTeacher() {
	return true;
}
@Override
public String toString() {
	return "Student [sName=" + sName + ", sNo=" + sNo + "]";
}

}
