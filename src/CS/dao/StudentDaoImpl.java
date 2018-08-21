package CS.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import CS.bean.Course;
import CS.bean.Pager;
import CS.bean.Student;
import CS.util.HibernateUtil;


public class StudentDaoImpl implements StudentDao{
	

	public void update(Student s) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String Hql="from Student where sid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, s.getSid());
		Student stu=(Student) query.uniqueResult();
		stu.setSname(s.getSname());
		stu.setPassword1(s.getPassword1());
		stu.setPassword2(s.getPassword2());
		stu.setScollege(s.getScollege());
		session.update(stu);
		tx.commit();
		HibernateUtil.closeSession(session);

	}

	public Student login(String Sid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String Hql="from Student where sid=?";
		Query query = session.createQuery(Hql);
		query.setString(0, Sid);
		Student stu=(Student)query.uniqueResult();
		HibernateUtil.closeSession(session);
		return stu;
	}

	public List<Student> StudentList() {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from Student");
		List<Student> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	public List<Student> StudentList(String coid) {
		Session session =HibernateUtil.getSession();
		String Hql="from Student where coid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, coid);
		List<Student>list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	@Override
	public void addStu(Student stu) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.save(stu);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum) {
		Pager<Student> result = null;
		String Sid=null;
		String Sname=null;
		String Coid=null;
		// 存放查询参数
		Map<String, String> paramMap = new HashMap<String, String>();
		
		Sid = searchModel.getSid();
		Sname = searchModel.getSname();
		if(searchModel.getScollege()!=null){
			Coid = searchModel.getScollege().getCoid();
		}
		
		StringBuilder hql = new StringBuilder(
				"from Student where 1=1");
		StringBuilder countHql = new StringBuilder(
				"select count(sid)  from Student where 1=1 ");

		if (Sid != null && !Sid.equals("")) {
			hql.append(" and sid like :%"+Sid+"% ");
			countHql.append("  and sid like :%"+Sid+"% ");
//			paramMap.put("Sid", "%"+Sid+"%");
		}
		if (Sname != null && !Sname.equals("")) {
			hql.append(" and sname like :%"+Sname+"% ");
			countHql.append("  sname sid like :%"+Sname+"% ");
//			paramMap.put("Sname", "%"+Sname+"%");
		}
		if (Coid != null && !Coid.equals("")) {
			hql.append(" and coid like :%"+Coid+"% ");
			countHql.append("  and coid like :%"+Coid+"% ");
//			paramMap.put("Coid", "%"+Coid+"%");
		}

		
		// 起始索引
		int fromIndex	= Pager.pageSize * (pageNum -1);
		
		// 存放所有查询出的学生对象
		List<Student> studentList = new ArrayList<Student>();
	
		Session session =null;
		
		try {
				
			session  = HibernateUtil.getSession();
			
			// 获取query对象
			Query hqlQuery = session.createQuery(hql.toString());
			Query countHqlQuery = session.createQuery(countHql.toString());
			
			//设置查询参数
//			hqlQuery.setString(0,"%" + Sid + "%");
//			hqlQuery.setString(1,"%" + Sname + "%");
//			hqlQuery.setString(2,"%" + Coid + "%");
//			
//			countHqlQuery.setString(0,"%" + Sid + "%");
//			countHqlQuery.setString(1,"%" + Sname + "%");
//			countHqlQuery.setString(2,"%" + Coid + "%");
			
			
			
			// 从第几条记录开始查询
			hqlQuery.setFirstResult(fromIndex);
			
			// 一共查询多少条记录
			hqlQuery.setMaxResults(Pager.pageSize);
			
			// 获取查询的结果
			studentList = hqlQuery.list();
			// 获取总计条数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number)countResult.get(0)).intValue();
			
			//获取总页数
			int totalPage = totalRecord / Pager.pageSize;
			if(totalRecord % Pager.pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new Pager<Student>( pageNum,totalRecord, totalPage, studentList);
			
		} catch (Exception e) {
//			throw new RuntimeException("查询所有数据异常！", e);
			e.printStackTrace();
		} finally{
			HibernateUtil.closeSession(session);
		}
		return result;
	}

	@Override
	public void delStu(String Sid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Student stu=(Student) session.get(Student.class, Sid);
		session.delete(stu);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void addCourse(String Sid,Course course) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Student student=(Student) session.get(Student.class, Sid);
		student.getCourse().add(course);
		session.merge(student);
//		session.saveOrUpdate(student);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void cancelCourse(String Sid, String Cid) {
		// TODO Auto-generated method stub
		System.out.println(Sid+"*************************");
		System.out.println(Cid+"*************************");
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Student student=(Student) session.get(Student.class, Sid);
		Set<Course> courses=student.getCourse();
		Iterator<Course> it=courses.iterator();
		while(it.hasNext()){
			Course course=it.next();
			if(course.getCid().equals(Cid)){
				student.getCourse().remove(course);
				break;
			}
		}
		session.update(student);
		tx.commit();
		HibernateUtil.closeSession(session);
	}


}
