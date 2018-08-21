package CS.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Pager;
import CS.bean.Student;
import CS.util.HibernateUtil;



public class CourseDaoImpl implements CourseDao{

	public List<Course> CourseList() {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from Course");
		List<Course> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	public List<Course> CourseList(String coid) {
		// TODO Auto-generated method stub
		Session session =HibernateUtil.getSession();
		String Hql="from Course where coid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, coid);
		List<Course> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	public List<Course> StuCourses(String sid) {
		// TODO Auto-generated method stub
		Session session =HibernateUtil.getSession();
		String Hql="from Student where sid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, sid);
		Student s=(Student)query.uniqueResult();
		List<Course> list=new ArrayList(s.getCourse());
		HibernateUtil.closeSession(session);
		return list;
	}

	public List<Course> TeaCourses(String tid) {
		// TODO Auto-generated method stub
		Session session =HibernateUtil.getSession();
		String Hql="from Course where tid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, tid);
		List<Course> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	@Override
	public Pager<Course> findCourse(Course searchModel, int pageNum,String tname) {
		// TODO Auto-generated method stub
		Pager<Course> result = null;
		String Cid=null;
		String Cname=null;
		String Coid=null;
		String Tname=null;
		// 存放查询参数
//		Map<String, String> paramMap = new HashMap<String, String>();
		
		Cid = searchModel.getCid();
		Cname = searchModel.getCname();
		if(searchModel.getCcollege()!=null){
			Coid = searchModel.getCcollege().getCoid();
		}
		Tname=tname;
		
		StringBuilder hql = new StringBuilder(
				"from Course where 1=1");
		StringBuilder countHql = new StringBuilder(
				"select count(cid)  from Course where 1=1 ");

		if (Cid != null && !Cid.equals("")) {
			hql.append(" and cid like :%"+Cid+"% ");
			countHql.append("  and cid like :%"+Cid+"% ");
//			paramMap.put("Sid", "%"+Sid+"%");
		}
		if (Cname != null && !Cname.equals("")) {
			hql.append(" and cname like :%"+Cname+"% ");
			countHql.append("  cname sid like :%"+Cname+"% ");
//			paramMap.put("Sname", "%"+Sname+"%");
		}
		if (Coid != null && !Coid.equals("")) {
			hql.append(" and coid like '%"+Coid+"%' ");
			countHql.append("  and coid like '%"+Coid+"%' ");
//			paramMap.put("Coid", "%"+Coid+"%");
		}
		
		if (Tname != null && !Tname.equals("")) {
			Session session = HibernateUtil.getSession();
			
			String Hql="from Course where tid in"
					+ "(select tid from Teacher  where tname like :tname)";
			
			Query qurey = session.createQuery(Hql);
			
			qurey.setString("tname", Tname);
			
			List<Course> courses=qurey.list();
			
		}

		
		// 起始索引
		int fromIndex	= Pager.pageSize * (pageNum -1);
		
		// 存放所有查询出的学生对象
		List<Course> coursetList = new ArrayList<Course>();
	
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
			coursetList = hqlQuery.list();
			// 获取总计条数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number)countResult.get(0)).intValue();
			
			//获取总页数
			int totalPage = totalRecord / Pager.pageSize;
			if(totalRecord % Pager.pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new Pager<Course>( pageNum,totalRecord, totalPage, coursetList);
			
		} catch (Exception e) {
//			throw new RuntimeException("查询所有数据异常！", e);
			e.printStackTrace();
		} finally{
			HibernateUtil.closeSession(session);
		}
		return result;
	}

	@Override
	public void delCourse(String Cid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Course course=(Course) session.get(Course.class, Cid);
		session.delete(course);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		System.out.println(course+"****************");
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.merge(course);
//		session.save(course);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public Course findCourse(String cid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from Course where cid=?");
		query.setString(0, cid);
		Course course=(Course)query.uniqueResult();
		HibernateUtil.closeSession(session);
		return course;
	}

}
