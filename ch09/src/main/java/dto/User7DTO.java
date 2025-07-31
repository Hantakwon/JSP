package dto;

/*
 * DTO(Data Transfer Object)
 *  - 컴포넌트(Controller, Service, DAO)간 데이터 이동 객체
 *  - DB 테이블 인스턴스(Row or Entity) 객체
 *  - VO(Value Object) 객체와 비슷
 */
public class User7DTO {
	private String id;
	private String name;
	private int age;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User7DTO [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}

}