package dto.bank;

public class CustomerDTO {

	private String c_id;
	private String c_name;
	private int c_type;
	private String c_hp;
	private String c_addr;

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_type() {
		return c_type;
	}

	public void setC_type(int c_type) {
		this.c_type = c_type;
	}

	public String getC_hp() {
		return c_hp;
	}

	public void setC_hp(String c_hp) {
		this.c_hp = c_hp;
	}

	public String getC_addr() {
		return c_addr;
	}

	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}

	@Override
	public String toString() {
		return "CustomerDTO [c_id=" + c_id + ", c_name=" + c_name + ", c_type=" + c_type + ", c_hp=" + c_hp
				+ ", c_addr=" + c_addr + "]";
	}

}
