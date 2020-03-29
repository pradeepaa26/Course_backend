package com.revature.coursems.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.updateDTO;
import com.revature.coursems.exception.BusinessServiceException;
import com.revature.coursems.exception.DatabaseServiceException;



public interface CourseService {
    public void saveCourse(Course course) throws BusinessServiceException,DatabaseServiceException;

	public List<Course> findAllCourses() throws BusinessServiceException;
	
	public Course deleteById(int id) throws BusinessServiceException;
	
	public void update(updateDTO updateDTOObj) throws BusinessServiceException;
	public Course getCourseById(int id) throws BusinessServiceException;
	public List<Level> viewLevels() throws BusinessServiceException;
	public List<Category> viewCategories() throws BusinessServiceException;
	public Course switchStatus(int id) throws BusinessServiceException;
	public Level viewLevelById(int id) throws BusinessServiceException;
	public Category viewCategoryById(int id) throws BusinessServiceException;
	public List<Doc> viewDocByCourseId(int id) throws BusinessServiceException;
	public String login(String userId,String password)throws BusinessServiceException;
}
	