package CricketCore;

public class Cricketer {
	private String name;
	private int age;
	private String email;
	private String Phone;
	private int rating;
	
	
	public Cricketer(String name, int age, String email, String phone, int rating) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		Phone = phone;
		this.rating = rating;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", age=" + age + ", email=" + email + ", Phone=" + Phone + ", rating="
				+ rating + "]";
	}
	
	
	
	
}
