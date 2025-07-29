package vo;

public class User5VO {
	private String name;
	private String ge;
	private int age;
	private String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGe() {
		return ge;
	}

	public void setGe(String ge) {
		this.ge = ge;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User4VO [name=" + name + ", ge=" + ge + ", age=" + age + ", addr=" + addr + "]";
	}

}
