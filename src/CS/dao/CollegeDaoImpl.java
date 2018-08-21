package CS.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import CS.bean.College;
import CS.bean.Pager;
import CS.util.HibernateUtil;

public class CollegeDaoImpl implements CollegeDao{

	public List<College> CollegeList() {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from College");
		List<College> list=query.list();
		HibernateUtil.closeSession(session);
		return list;
	}

	@Override
	public College findCollege(String Coid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String hql="from College where coid=?";
		Query query=session.createQuery(hql);
		query.setString(0, Coid);
		College college=(College)query.uniqueResult();
		HibernateUtil.closeSession(session);
		return college;
	}

	@Override
	public Pager<College> findCollege(College searchModel, int pageNum) {
		// TODO Auto-generated method stub
				Pager<College> result = null;
				String Coid=null;
				String Coname=null;
				// 存放查询参数
				Map<String, String> paramMap = new HashMap<String, String>();
				
				Coid = searchModel.getCoid();
				Coname = searchModel.getConame();
				
				StringBuilder hql = new StringBuilder(
						"from College where 1=1");
				StringBuilder countHql = new StringBuilder(
						"select count(coid)  from College where 1=1 ");

				if (Coid != null && !Coid.equals("")) {
					hql.append(" and coid like :%"+Coid+"% ");
					countHql.append("  and coid like :%"+Coid+"% ");
//					paramMap.put("Sid", "%"+Sid+"%");
				}
				if (Coname != null && !Coname.equals("")) {
					hql.append(" and coname like :%"+Coname+"% ");
					countHql.append("  coname sid like :%"+Coname+"% ");
//					paramMap.put("Sname", "%"+Sname+"%");
				}
				

				
				// 起始索引
				int fromIndex	= Pager.pageSize * (pageNum -1);
				
				// 存放所有查询出的学生对象
				List<College> collegetList = new ArrayList<College>();
			
				Session session =null;
				
				try {
						
					session  = HibernateUtil.getSession();
					
					// 获取query对象
					Query hqlQuery = session.createQuery(hql.toString());
					Query countHqlQuery = session.createQuery(countHql.toString());
					
					//设置查询参数
//					hqlQuery.setString(0,"%" + Sid + "%");
//					hqlQuery.setString(1,"%" + Sname + "%");
//					hqlQuery.setString(2,"%" + Coid + "%");
//					
//					countHqlQuery.setString(0,"%" + Sid + "%");
//					countHqlQuery.setString(1,"%" + Sname + "%");
//					countHqlQuery.setString(2,"%" + Coid + "%");
					
					
					
					// 从第几条记录开始查询
					hqlQuery.setFirstResult(fromIndex);
					
					// 一共查询多少条记录
					hqlQuery.setMaxResults(Pager.pageSize);
					
					// 获取查询的结果
					collegetList = hqlQuery.list();
					// 获取总计条数
					List<?> countResult = countHqlQuery.list();
					int totalRecord = ((Number)countResult.get(0)).intValue();
					
					//获取总页数
					int totalPage = totalRecord / Pager.pageSize;
					if(totalRecord % Pager.pageSize !=0){
						totalPage++;
					}
					
					// 组装pager对象
					result = new Pager<College>( pageNum,totalRecord, totalPage, collegetList);
					
				} catch (Exception e) {
//					throw new RuntimeException("查询所有数据异常！", e);
					e.printStackTrace();
				} finally{
					HibernateUtil.closeSession(session);
				}
				return result;
	}

	@Override
	public void delCollege(String Coid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		
		Transaction tx=session.beginTransaction();
		System.out.println(Coid);
		College college=(College) session.get(College.class, Coid);
		System.out.println(college);
		session.delete(college);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void addCollege(College college) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(college);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void updateCollege(College newCollege) {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		College college=(College) session.get(College.class, newCollege.getCoid());
		college.setConame(newCollege.getConame());
		session.merge(college);
		tx.commit();
		HibernateUtil.closeSession(session);
	}





}
