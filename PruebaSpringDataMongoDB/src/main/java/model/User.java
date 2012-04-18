package model;

public class User {
	 
	private String id;
	private String firstname;
	private String lastname;
	private int age;
	public User() {
		
	}
	public User(String id1,String firstname1,String lastname1,int age1) {
		id=id1;
		firstname=firstname1;
		lastname=lastname1;
		age=age1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	
	@Override
	public String toString() {
		return "["+id+","+firstname+","+lastname+","+age+"]";
		
	}
 
	 
}