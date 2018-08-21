package CS.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static ServiceRegistry serviceRegistry;

	static {
		// 鍒涘缓Configuration瀵硅薄锛岃鍙杊ibernate.cfg.xml鏂囦欢锛屽畬鎴愬垵濮嬪寲
		Configuration config = new Configuration().configure();
		serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory=config.buildSessionFactory(serviceRegistry);
	}
	
	//鑾峰彇SessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//鑾峰彇Session
	public static Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	
	//鍏抽棴Session
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}
