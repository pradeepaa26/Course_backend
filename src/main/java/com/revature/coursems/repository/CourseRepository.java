package com.revature.coursems.repository;

import java.util.List;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Login;

import exception.DatabaseServiceException;

public interface CourseRepository   {
    public void saveCourse(Course course) throws DatabaseServiceException;

	public List<Course> findAllCourses() throws DatabaseServiceException;
	public void deleteById(int id) throws DatabaseServiceException;
	public void update(Course course) throws DatabaseServiceException;
	public Course findCourseById(int id) throws DatabaseServiceException;
	public List<Level> viewLevels() throws DatabaseServiceException;
	public List<Category> viewCategories() throws DatabaseServiceException ;
	public void switchStatus(int id) throws DatabaseServiceException;
	public Level viewLevelById(int id) throws DatabaseServiceException;
	public Category viewCategoryById(int id) throws DatabaseServiceException;
	public List<Doc> viewDocByCourseId(int id) throws DatabaseServiceException;
	public String login(Login login);
	public List<CourseSubscribedVideo> viewVideoByCourseId(int id) throws DatabaseServiceException;
	public void deleteCourseVideoMappingById(int id) throws DatabaseServiceException;
}
