package CS.bean;

import java.util.HashSet;
import java.util.Set;

public class College {
	private String Coid;
	private String Coname;
	private Set<Course> course=new HashSet<Course>();
	private Set<Student> student=new HashSet<Student>();
	private Set<Teacher> teacher=new HashSet<Teacher>();
	public College() {
		super();
	}
	public College(String coid, String coname) {
		super();
		Coid = coid;
		Coname = coname;
	}
	
	@Override
	public String toString() {
		return "College [Coid=" + Coid + ", Coname=" + Coname + "]";
	}
	public String getCoid() {
		return Coid;
	}
	public void setCoid(String coid) {
		Coid = coid;
	}
	public String getConame() {
		return Coname;
	}
	public void setConame(String coname) {
		Coname = coname;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public Set<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	
	
}
