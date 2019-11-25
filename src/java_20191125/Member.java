package java_20191125;

public class Member {
	private String name;
	private String zipcode;
	private String address1;
	private String address2;
	private String ssn;
	private String password;
	private String email;
	private int age;
	private double height;
	
	// alt+ shift +s +r => tab*3 => enter
	// 마우스 : 우클릭 > source > generate getter/setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		//this
		//1.자기자신객체 = this.
		//2.다른 생성자 호출 = this(매개변수>갯수에 따라 호출하며); << 생성자에서만 호출 가능.
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
