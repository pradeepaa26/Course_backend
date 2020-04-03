package com.revature.coursems.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Video;
import com.revature.coursems.domain.updateDTO;

import exception.BusinessServiceException;

public interface CourseService {
    public void saveCourse(Course course) throws BusinessServiceException;

	public List<Course> findAllCourses() throws BusinessServiceException;
	
	public String deleteById(int id) throws BusinessServiceException;
	
	public void update(updateDTO updateDTOObj) throws BusinessServiceException;
	public Course getCourseById(int id) throws BusinessServiceException;
	public List<Level> viewLevels();
	public List<Category> viewCategories();
	public void switchStatus(int id);
	public Level viewLevelById(int id);
	public Category viewCategoryById(int id);
	public List<Doc> viewDocByCourseId(int id);
	public String login(String userId,String password);
	public List<CourseSubscribedVideo> viewVideoByCourseId(int id);
	public String deleteCourseVideoMappingById(int id);
}
	