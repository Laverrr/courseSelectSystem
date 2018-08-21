package CS.bean;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private String Tid;
	private String Tname;
	private String Password1;
	private String Password2;
	private College Tcollege;
	private Set<Course> Tcourses= new HashSet<Course>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Teacher [Tid=" + Tid + ", Tname=" + Tname + ", Password1="
				+ Password1 + "]";
	}



	public Teacher(String tid, String tname, String password1,String password2, College tcollege) {
		super();
		Tid = tid;
		Tname = tname;
		Password1 = password1;
		Password2 = password2;
		Tcollege = tcollege;
	}

	public String getTid() {
		return Tid;
	}

	public void setTid(String tid) {
		Tid = tid;
	}

	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
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

	public College getTcollege() {
		return Tcollege;
	}

	public void setTcollege(College tcollege) {
		Tcollege = tcollege;
	}

	public Set<Course> getTcourses() {
		return Tcourses;
	}

	public void setTcourses(Set<Course> tcourses) {
		Tcourses = tcourses;
	}

	
}
