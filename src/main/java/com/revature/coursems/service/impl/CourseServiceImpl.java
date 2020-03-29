package com.revature.coursems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Login;
import com.revature.coursems.domain.updateDTO;
import com.revature.coursems.exception.BusinessServiceException;
import com.revature.coursems.exception.DatabaseServiceException;
import com.revature.coursems.repository.CourseRepository;
import com.revature.coursems.service.CourseService;
import com.revature.coursems.domain.Doc;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void saveCourse(Course course) throws  BusinessServiceException {
		try {
			courseRepository.saveCourse(course);
		} 
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Course already exists");
		}

	}

	@Override
	public List<Course> findAllCourses() throws BusinessServiceException {
		List<Course> courses;
		try {
			courses=courseRepository.findAllCourses();
			if(courses.isEmpty())
				throw new BusinessServiceException("courses not found");
			else
				return courses;
		} catch (DatabaseServiceException e) {
			throw new BusinessServiceException("requested courses cannot be FETCHED");
		}

	}

	@Override
	public Course deleteById(int id) throws BusinessServiceException {
		try {
			Course course=courseRepository.deleteById(id);
			if(course!=null)
			return course;
			else
			throw new BusinessServiceException("requested course for deletion does not exists"); 	
		}
		 catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Deletion of the requested course FAILED");
		}
	}

	@Override
	public void update(updateDTO updateDTOObj) throws BusinessServiceException {
		try {
			Course course = new Course();
			course.setId(updateDTOObj.getId());
			course.setName(updateDTOObj.getName());
			System.out.println("----level id==>" + updateDTOObj.getLevelId());

			Level level = courseRepository.viewLevelById(updateDTOObj.getLevelId());
			System.out.println("-----level obj==>" + level);
			course.setLevelObj(level);
			Category category = courseRepository.viewCategoryById(updateDTOObj.getCategoryId());
			course.setCategoryObj(category);
			course.setDocObj(updateDTOObj.getDocObj());
			course.setCourseSubscribedVideo(updateDTOObj.getCourseSubscribedVideo());
			course.setTag(updateDTOObj.getTag());
			course.setSlug(updateDTOObj.getSlug());
			course.setIsActive(updateDTOObj.getIsActive());
			course.setIsLevelOverride(updateDTOObj.getIsLevelOverride());
			course.setAvailableFor(updateDTOObj.getAvailableFor());
			course.setDescription(updateDTOObj.getDescription());
			course.setMetaKey(updateDTOObj.getMetaKey());
			course.setMetaDesc(updateDTOObj.getMetaDesc());
			course.setCourse_icon(updateDTOObj.getCourse_icon());
			course.setCreatedBy(updateDTOObj.getCreatedBy());
			course.setModifiedBy(updateDTOObj.getModifiedBy());
			course.setCreatedOn(updateDTOObj.getCreatedOn());
			course.setModifiedOn(updateDTOObj.getModifiedOn());
		//	course.setVersion(updateDTOObj.getVersion());
			course.setCompletionActivityPoints(updateDTOObj.getCompletionActivityPoints());
			course.setEnrollmentActivityPoints(updateDTOObj.getEnrollmentActivityPoints());
			courseRepository.update(course);
		} 
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("UPDATION  of the requested course is FAILED");  
			
		}

	}

	@Override
	public Course getCourseById(int id) throws BusinessServiceException {
		Course course;
		try{
			course=courseRepository.findCourseById(id);
			if(course != null)
				return course;
			else 
			throw new BusinessServiceException("Invalid id, course doesnt exists for the given id");
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("requested COURSE cannot be FETCHED");
		}

	}

	@Override
	public List<Level> viewLevels() throws BusinessServiceException {
		List<Level> levels;
		try
		{
			levels=courseRepository.viewLevels();
			if(levels.isEmpty())
			throw new BusinessServiceException("No levels FOUND");
			else
			return levels;
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Levels cannot be FETCHED");
		}
	}

	@Override
	public List<Category> viewCategories() throws BusinessServiceException{
		List<Category> categories;
		try
		{
			categories= courseRepository.viewCategories();
			if(categories.isEmpty())
			throw new BusinessServiceException("No categories found");
			else
			return categories;
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Categories cannot be FETCHED");
		}
	}

	@Override
	public Course switchStatus(int id) throws BusinessServiceException {
		Course course;
		try
		{
			course=courseRepository.switchStatus(id);
			if(course!=null){
				return course;
			}
			else{
				throw new BusinessServiceException("switching failed as the requested course does not exists");
			}
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Status cannot be switched");
		}
	}

	@Override
	public Level viewLevelById(int id) throws BusinessServiceException {
		Level level;
		try{
			level=courseRepository.viewLevelById(id);
			if(level !=null)
				return level;
			else
				throw new BusinessServiceException("level not found");
			
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("requested LEVEL cannot be FETCHED");
		}
	}

	@Override
	public Category viewCategoryById(int id) throws BusinessServiceException {
		Category category;
		try{
			category= courseRepository.viewCategoryById(id);
			if(category !=null)
				return category;
			else
			throw new BusinessServiceException("Category not found");
			
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("Fetching failed");
		}
		
	}

	@Override
	public List<Doc> viewDocByCourseId(int id) throws BusinessServiceException {
		List<Doc> docs=null;
		try{
		docs=courseRepository.viewDocByCourseId(id);
		if(docs.isEmpty())
			throw new BusinessServiceException("Fetched list is empty");
		return docs;
		}
		catch (DatabaseServiceException e) {
			throw new BusinessServiceException("requested DOCUMENT cannot be FETCHED");
		}
	}

	@Override
	public String login(String userId, String password) {
		Login login=new Login();
		login.setUserId(userId);
		login.setPassword(password);
		return courseRepository.login(login);
	}
}
