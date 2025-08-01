package dto.library;

import java.sql.Date;

public class MemberDTO {
	private int member_id;
	private String name;
	private String address;
	private String hp;
	private Date join_date;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "CourseDTO [member_id=" + member_id + ", name=" + name + ", address=" + address + ", hp=" + hp
				+ ", join_date=" + join_date + "]";
	}

}
