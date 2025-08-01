package dto.shop;

import java.sql.Date;

public class CustomerDTO {
	private String cid;
	private String name;
	private String hp;
	private String address;
	private Date rdate;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", hp=" + hp + ", address=" + address + ", rdate=" + rdate
				+ "]";
	}

}
