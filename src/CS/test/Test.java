package CS.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.util.HibernateUtil;


/*
 * 多对多关联关系的配置
 * 同时建立了Project和Employee之间的双向多对多关联关系
 * 关联关系的维护交由Project方来处理，并且在保存Project对象时会�?��保存Employee对象
 */
public class Test {
	public static void main(String[] args) {
		College collgeg1=new College("Co01","����ѧԺ");
		College collgeg2=new College("Co02","��ѧѧԺ");
		College collgeg3=new College("Co03","Ӣ��ѧԺ");
		
		Course course1=new Course("C001", "����", collgeg1);
		Course course2=new Course("C002", "��ѧ", collgeg2);
		Course course3=new Course("C003", "Ӣ��", collgeg3);
		Student student1=new Student("S001", "����", "123","123", collgeg1);
		Student student2=new Student("S002", "����", "321","321", collgeg2);
//		
		//参加项目1的员工有慕女神和imooc
		
//		
//		session.save(course1);
//		session.save(course2);
		

		
		Teacher t1=new Teacher("T001", "����", "123","123", collgeg1);
		Teacher t2=new Teacher("T002", "����", "321","321", collgeg2);
//		
		course1.getStudents().add(student1);
		course2.getStudents().add(student2);
		course2.getStudents().add(student1);
		
		course1.setTeacher(t1);
		course2.setTeacher(t2);
		course3.setTeacher(t2);
		
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
//		session.save(t1);
//		session.save(t2);
		session.save(course1);
		session.save(course2);
		session.save(course3);
		tx.commit();
		HibernateUtil.closeSession(session);
		
	}
}
