package dto.college;

import java.sql.Date;

public class StudentDTO {
	private String stdno;
	private String name;
	private Date birth;
	private String major;
	private Date enr_date;

	public String getStdno() {
		return stdno;
	}

	public void setStdno(String stdno) {
		this.stdno = stdno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getEnr_date() {
		return enr_date;
	}

	public void setEnr_date(Date enr_date) {
		this.enr_date = enr_date;
	}

	@Override
	public String toString() {
		return "StudentDTO [stdno=" + stdno + ", name=" + name + ", birth=" + birth + ", major=" + major + ", enr_date="
				+ enr_date + "]";
	}

}
