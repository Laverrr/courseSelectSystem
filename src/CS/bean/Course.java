package CS.bean;

import java.util.HashSet;
import java.util.Set;

/*
 * 项目�?
 */
public class Course {
	private String Cid;
	private String Cname;
	private College Ccollege;
	private Teacher teacher;
	private Set<Student> students = new HashSet<Student>();


	@Override
	public String toString() {
		return "Course [Cid=" + Cid + ", Cname=" + Cname + ", Ccollege="
				+ Ccollege + "]";
	}



	public Course(String cid, String cname, College ccollege) {
		super();
		Cid = cid;
		Cname = cname;
		Ccollege = ccollege;
	}

	
	
	public Course(String cid, String cname, College ccollege, Teacher teacher) {
		super();
		Cid = cid;
		Cname = cname;
		Ccollege = ccollege;
		this.teacher = teacher;
	}



	public Course(String cid, String cname, College ccollege, Set<Student> students) {
		super();
		Cid = cid;
		Cname = cname;
		Ccollege = ccollege;
		this.students = students;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public College getCcollege() {
		return Ccollege;
	}

	public void setCcollege(College ccollege) {
		Ccollege = ccollege;
	}

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public Course() {
		super();
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}



}
