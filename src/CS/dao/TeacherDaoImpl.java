package CS.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import CS.bean.Pager;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.util.HibernateUtil;


public class TeacherDaoImpl implements TeacherDao{

	public void Update(Teacher t) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Teacher teacher=(Teacher)session.get(Teacher.class, t.getTid());
		teacher.setTname(t.getTname());
		teacher.setPassword1(t.getPassword1());
		teacher.setPassword2(t.getPassword2());
		teacher.setTcollege(t.getTcollege());
		session.update(teacher);
		tx.commit();
		HibernateUtil.closeSession(session);	}

	public List<Teacher> TeacherList() {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from Teacher");
		List<Teacher> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	public List<Teacher> TeacherList(String coid) {
		Session session =HibernateUtil.getSession();
		String Hql="from Teacher where coid=?";
		Query query=session.createQuery(Hql);
		query.setString(0, coid);
		List<Teacher>list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	@Override
	public Teacher login(String Tid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String Hql="from Teacher where tid=?";
		Query query = session.createQuery(Hql);
		query.setString(0, Tid);
		Teacher tea=(Teacher)query.uniqueResult();
		HibernateUtil.closeSession(session);
		return tea;
	}

	@Override
	public void addTea(Teacher tea) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.save(tea);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public Pager<Teacher> findTeacher(Teacher searchModel, int pageNum) {
		Pager<Teacher> result = null;
		String Tid=null;
		String Tname=null;
		String Coid=null;
		// 存放查询参数
		Map<String, String> paramMap = new HashMap<String, String>();
		
		Tid = searchModel.getTid();
		Tname = searchModel.getTname();
		if(searchModel.getTcollege()!=null){
			Coid = searchModel.getTcollege().getCoid();
		}
		
		StringBuilder hql = new StringBuilder(
				"from Teacher where 1=1");
		StringBuilder countHql = new StringBuilder(
				"select count(tid)  from Teacher where 1=1 ");

		if (Tid != null && !Tid.equals("")) {
			hql.append(" and tid like :%"+Tid+"% ");
			countHql.append("  and tid like :%"+Tid+"% ");
//			paramMap.put("Sid", "%"+Sid+"%");
		}
		if (Tname != null && !Tname.equals("")) {
			hql.append(" and tname like :%"+Tname+"% ");
			countHql.append("  tname sid like :%"+Tname+"% ");
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
		List<Teacher> teacherList = new ArrayList<Teacher>();
	
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
			teacherList = hqlQuery.list();
			// 获取总计条数
			List<?> countResult = countHqlQuery.list();
			int totalRecord = ((Number)countResult.get(0)).intValue();
			
			//获取总页数
			int totalPage = totalRecord / Pager.pageSize;
			if(totalRecord % Pager.pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new Pager<Teacher>( pageNum,totalRecord, totalPage, teacherList);
			
		} catch (Exception e) {
//			throw new RuntimeException("查询所有数据异常！", e);
			e.printStackTrace();
		} finally{
			HibernateUtil.closeSession(session);
		}
		return result;
	}

	@Override
	public void DelTea(String Tid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Teacher tea=(Teacher) session.get(Teacher.class, Tid);
		session.delete(tea);
		tx.commit();
		HibernateUtil.closeSession(session);
		
	}

}
