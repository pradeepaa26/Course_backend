package com.revature.coursems.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Login;
import com.revature.coursems.domain.updateDTO;
import com.revature.coursems.exception.BusinessServiceException;
import com.revature.coursems.exception.DatabaseServiceException;
import com.revature.coursems.repository.CourseRepository;
import com.revature.coursems.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> findAllCourses() throws BusinessServiceException {
		List<Course> course;
		try {
			course= courseRepository.findAllCourses();
			if(course.isEmpty()) {
				throw new BusinessServiceException("No records found");
		} 
			return course;
			}catch (DatabaseServiceException e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}

	@Override
	public Course getCourseById(int id) throws BusinessServiceException {
		Course course;
		try {
		course= courseRepository.findCourseById(id);
		if(course==null)
		{throw new BusinessServiceException("id not found");}
		return course;
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());
	}
	}

	@Override
	public void deleteById(int id) throws BusinessServiceException {
		try {
			 courseRepository.deleteById(id);
		} catch (DatabaseServiceException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

	@Override
	public void saveCourse(Course course) throws BusinessServiceException {
		try {
			
			LocalDateTime time = LocalDateTime.now();
			course.setCreatedOn(time);
			List<Doc> docs=course.getDocObj();
			docs.get(0).setCreatedOn(time);
			
			course.setDocObj(docs);
			course.setCreatedOn(time);
			if(course.getIsPreSignUp()==null)
				course.setIsPreSignUp(false);
			if(course.getIsSlugLogin()==null)
				course.setIsSlugLogin(false);
			if(course.getIsDashboard()==null)
				course.setIsDashboard(false);
			
			course.setIsActive(true);
			courseRepository.saveCourse(course);
		} catch (DatabaseServiceException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	
	}

	@Override
	public void update(updateDTO updateDTOObj) throws BusinessServiceException {
		try {
			LocalDateTime time = LocalDateTime.now();
			Course course = new Course();
			course.setId(updateDTOObj.getId());
			course.setName(updateDTOObj.getName());
			Level level = courseRepository.viewLevelById(updateDTOObj.getLevelId());
			course.setLevelObj(level);
			Category category = courseRepository.viewCategoryById(updateDTOObj.getCategoryId());
			course.setCategoryObj(category);
			course.setDocObj(updateDTOObj.getDocObj());
			course.setCourseSubscribedVideo(updateDTOObj.getCourseSubscribedVideo());
			course.setTag(updateDTOObj.getTag());
			course.setSlug(updateDTOObj.getSlug());
			course.setIsActive(updateDTOObj.getIsActive());
			course.setIsLevelOverride(updateDTOObj.getIsLevelOverride());
			course.setIsPreSignUp(updateDTOObj.getIsPreSignUp());
			course.setIsSlugLogin(updateDTOObj.getIsSlugLogin());
			course.setIsDashboard(updateDTOObj.getIsDashboard());
			course.setDescription(updateDTOObj.getDescription());
			course.setMetaKey(updateDTOObj.getMetaKey());
			course.setMetaDesc(updateDTOObj.getMetaDesc());
			course.setCourse_icon(updateDTOObj.getCourse_icon());
			course.setCreatedBy(updateDTOObj.getCreatedBy());
			course.setModifiedBy(updateDTOObj.getModifiedBy());
			course.setCreatedOn(updateDTOObj.getCreatedOn());
			course.setModifiedOn(time);
			course.setVersion(updateDTOObj.getVersion());
			course.setMode(updateDTOObj.getMode());
			course.setCompletionActivityPoints(updateDTOObj.getCompletionActivityPoints());
			course.setEnrollmentActivityPoints(updateDTOObj.getEnrollmentActivityPoints());
			if(updateDTOObj.getDocObj().get(0).getId()!=null){
				List<Doc> docs=updateDTOObj.getDocObj();
				docs.get(0).setCreatedOn(updateDTOObj.getDocObj().get(0).getCreatedOn());
				docs.get(0).setModifiedOn(time);
				course.setDocObj(docs);
			}
			else{
				List<Doc> docs=updateDTOObj.getDocObj();
				docs.get(0).setCreatedOn(time);
				docs.get(0).setModifiedOn(time);
				course.setDocObj(docs);
		}
		
			if(course.getId()==null || course.getName()==null)
			{
			throw new BusinessServiceException("Required fields are missing");
		}
			else {
			courseRepository.update(course);
			}
		} catch (DatabaseServiceException e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}

	@Override
	public List<Level> viewLevels() throws BusinessServiceException{
		List<Level> level;
		try {
		level= courseRepository.viewLevels();
		if(level.isEmpty())
			throw new BusinessServiceException("No records found");
		else
			return level;
	}catch(DatabaseServiceException e) {
	throw new BusinessServiceException(e.getMessage());	
	}
		}

	@Override
	public List<Category> viewCategories()throws BusinessServiceException {
		List<Category> category;
		try {
		category= courseRepository.viewCategories();
		if(category.isEmpty())
			throw new BusinessServiceException("No records available");
		else
			return category;
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());	
	}
		}

	@Override
	public void switchStatus(int id) throws BusinessServiceException {
		try {
		courseRepository.switchStatus(id);
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());
	}
	}

	@Override
	public Level viewLevelById(int id)throws BusinessServiceException {
		Level level;
		try {
			level= courseRepository.viewLevelById(id);
			if(level==null) {
				throw new BusinessServiceException("No records found");
			}
			else
				return level;
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());
	}
	}
	@Override
	public Category viewCategoryById(int id) throws BusinessServiceException {
		Category category;
		try {
			category= courseRepository.viewCategoryById(id);
			if(category==null) {
				throw new BusinessServiceException("No records found");
			}
			else
				return category;
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());
	}
	}

	@Override
	public List<Doc> viewDocByCourseId(int id) throws BusinessServiceException {
		try {
			List<Doc> doc;
           if(courseRepository.findCourseById(id)!=null) {
		       doc=courseRepository.viewDocByCourseId(id);
            }
           else {
	           throw new BusinessServiceException("Given course id not found");
              }
           return doc;
	     }catch(DatabaseServiceException e) {
		     throw new BusinessServiceException(e.getMessage());
	      }
	    }

	@Override
	public List<CourseSubscribedVideo> viewVideoByCourseId(int id) throws BusinessServiceException{
		List<CourseSubscribedVideo> courseVideo;
		try {
           if(courseRepository.findCourseById(id)!=null) {
		       courseVideo=courseRepository.viewVideoByCourseId(id);
            }
           else {
	           throw new BusinessServiceException("Given course id not found");
              }
           return courseVideo;
	     }catch(DatabaseServiceException e) {
		     throw new BusinessServiceException(e.getMessage());
	      }
	    }

	@Override
	public void deleteCourseVideoMappingById(int id) throws BusinessServiceException {
		try {
		 courseRepository.deleteCourseVideoMappingById(id);
	}catch(DatabaseServiceException e) {
		throw new BusinessServiceException(e.getMessage());
	  }
	}

	@Override
	public String login(String userId, String password) {
		Login login = new Login();
		login.setUserId(userId);
		login.setPassword(password);
		return courseRepository.login(login);
	}
}

