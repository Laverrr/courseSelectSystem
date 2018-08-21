package CS.service;


import CS.bean.Course;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseAction extends ActionSupport implements ModelDriven<Course>{
	
	Course course = new Course();

	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}


}
