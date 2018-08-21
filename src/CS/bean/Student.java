package CS.bean;

import java.util.HashSet;
import java.util.Set;
/*
 * å‘˜å·¥ç±?
 */
public class Student {
	private String Sid;
	private String Sname;
	private String Password1;
	private String Password2;
	private College Scollege;
	// æ·»åŠ ä¸?¸ªé¡¹ç›®çš„é›†å?
	private Set<Course> course = new HashSet<Course>();





	@Override
	public String toString() {
		return "Student [Sid=" + Sid + ", Sname=" + Sname + ", Password1="
				+ Password1 + "]";
	}



	public Student(String sid, String sname, String password1,String password2, College scollege) {
		super();
		Sid = sid;
		Sname = sname;
		Password1 = password1;
		Password2 = password2;
		Scollege = scollege;
	}
	
	

	public Student(String sid, String sname, String password1,String password2, College scollege,
			Set<Course> course) {
		super();
		Sid = sid;
		Sname = sname;
		Password1 = password1;
		Password2 = password2;
		Scollege = scollege;
		this.course = course;
	}



	public Student() {
		super();
	}

	public String getSid() {
		return Sid;
	}

	public void setSid(String sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}



	public String getPassword1() {
		return Password1;
	}



	public void setPassword1(String password1) {
		Password1 = password1;
	}



	public String getPassword2() {
		return Password2;
	}



	public void setPassword2(String password2) {
		Password2 = password2;
	}



	public College getScollege() {
		return Scollege;
	}

	public void setScollege(College scollege) {
		Scollege = scollege;
	}

	

}
