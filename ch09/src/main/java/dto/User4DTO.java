package dto;

/*
 * DTO(Data Transfer Object)
 *  - 컴포넌트(Controller, Service, DAO)간 데이터 이동 객체
 *  - DB 테이블 인스턴스(Row or Entity) 객체
 *  - VO(Value Object) 객체와 비슷
 */
public class User4DTO {
	private String name;
	private String gender;
	private int age;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User4DTO [name=" + name + ", gender=" + gender + ", age=" + age + ", address=" + address + "]";
	}

}
