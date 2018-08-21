package CS.service;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Pager;
import CS.bean.Student;
import CS.dao.CollegeDaoImpl;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindStudentAction extends ActionSupport implements ModelDriven<Student>{
	
	private List<Student> students=new ArrayList<Student>();
	
	private Student stu= new Student();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session= request.getSession();
//		Student student=(Student) session.getAttribute("student");

		String Sid=stu.getSid();
		String Sname = stu.getSname(); //学生姓名
		String Coid=request.getParameter("coid");
		
		//设置当前页，默认为第一页
		String pageNumStr = request.getParameter("pageNum"); 
		int pageNum = Pager.defaultPage; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		// 组装查询条件
		Student searchModel = new Student(); 
		searchModel.setSid(Sid);
		searchModel.setSname(Sname);
		CollegeDaoImpl collegeDao=new CollegeDaoImpl(); 
		searchModel.setScollege(collegeDao.findCollege(Coid));
		//调用dao 获取查询结果
		StudentDaoImpl stuDao=new StudentDaoImpl();
		System.out.println(searchModel);
		System.out.println(pageNum);
		Pager<Student> result = stuDao.findStudent(searchModel,pageNum);
		session.setAttribute("result", result);
		students=result.getDataList();
		System.out.println(students);
		return super.execute();
	}
	
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
