package com.revature.coursems.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Login;
import com.revature.coursems.exception.DatabaseServiceException;
import com.revature.coursems.repository.CourseRepository;

;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> findAllCourses() throws DatabaseServiceException {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Course> courses = session.createQuery(
					"SELECT course FROM Course course JOIN FETCH course.categoryObj category JOIN FETCH course.levelObj level",
					Course.class).getResultList();
			return courses;
		} catch (Exception e) {
			throw new DatabaseServiceException("Error in fetching data from db");
		}

	}

	@Override
	public Course findCourseById(int id) throws DatabaseServiceException{
		Session session = this.sessionFactory.getCurrentSession();
		try {
		List<Course> courses = session.createQuery(
				"SELECT cou FROM Course cou JOIN FETCH cou.categoryObj cat JOIN FETCH cou.levelObj lvl where cou.id="
						+ id,
				Course.class).getResultList();
		return courses.get(0);
		}catch(Exception e)
		{
			throw new DatabaseServiceException("Erro Id not found in db");
		}
	}

	@Override
	public void saveCourse(Course course) throws DatabaseServiceException {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			if (course.getDocObj() != null)
				course.getDocObj().forEach(docObj -> docObj.setCourse(course));
			if (course.getCourseSubscribedVideo() != null)
				course.getCourseSubscribedVideo()
						.forEach(courseSubscribedVideoObj -> courseSubscribedVideoObj.setCourse(course));
			session.save(course); //here changes become permanent
			session.getTransaction().commit();
            session.close();
		}
		catch (Exception e) {
			throw new DatabaseServiceException("Error in inserting to db");
		}
	}

	@Override
	public void deleteById(int id) throws DatabaseServiceException {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Course obj=findCourseById(id);
			//Course obj = session.get(Course.class, id);
			if (obj != null) {
				session.delete(obj);
				session.getTransaction().commit();
				session.close();
			}
		} catch (Exception e) {
			throw new DatabaseServiceException("Error in deleting from db");
		}
	}

	@Override
	public void update(Course course) throws DatabaseServiceException {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			if (course.getDocObj() != null)
			course.getDocObj().forEach(docObj -> docObj.setCourse(course));
			if (course.getCourseSubscribedVideo() != null)
				course.getCourseSubscribedVideo()
						.forEach(courseSubscribedVideoObj -> courseSubscribedVideoObj.setCourse(course));

			session.beginTransaction();
			session.saveOrUpdate(course);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			throw new DatabaseServiceException("Error in Updating to db");
		}
	}

	@Override
	public List<Level> viewLevels() throws DatabaseServiceException{
		try {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("From Level", Level.class).getResultList();
		}catch(Exception e) {
			throw new DatabaseServiceException("Error in finding data from db");
		}

	}

	@Override
	public List<Category> viewCategories()throws DatabaseServiceException {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("From Category", Category.class).getResultList();
	}catch(Exception e)
		{
		throw new DatabaseServiceException("Error in finding data from db");
		}
	}
	@Override
	public void switchStatus(int id) throws DatabaseServiceException {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Course obj=findCourseById(id);
		if(obj!=null) {
		Course course = session.get(Course.class, id);
		if (course.getIsActive())
			course.setIsActive(false);
		else
			course.setIsActive(true);
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		session.close();
		}
	}catch(Exception e) {
		throw new DatabaseServiceException("Error status not found in db");
	}
	}

	@Override
	public Level viewLevelById(int id) throws DatabaseServiceException {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		Level level = session.get(Level.class, id);
		return level;
		}catch(Exception e)
		{
			throw new DatabaseServiceException("Error categoory id not found in db");
		}
	}

	@Override
	public Category viewCategoryById(int id) throws  DatabaseServiceException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Category category = session.get(Category.class, id);
			return category;
			}catch(Exception e)
			{
				throw new DatabaseServiceException("Error categoory id not found in db");
			}
	}
	
	@Override
	public List<Doc> viewDocByCourseId(int id) throws DatabaseServiceException  {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		List<Doc> listOfDocs = session.createQuery("SELECT doc FROM Doc doc where doc.course.id=" + id, Doc.class)
				.getResultList();
		return listOfDocs;
	}catch(Exception e) {
		throw new DatabaseServiceException("Error in finding mapped documents");	
	}
	}
	@Override
	public List<CourseSubscribedVideo> viewVideoByCourseId(int id) throws DatabaseServiceException  {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		List<CourseSubscribedVideo> listOfCourseSubscribedVideos = session.createQuery("SELECT csv FROM CourseSubscribedVideo csv where csv.course.id=" + id, CourseSubscribedVideo.class)
				.getResultList();
		return listOfCourseSubscribedVideos;
	}catch(Exception e) {
		throw new DatabaseServiceException("Error in finding the mapped videos");
	}
	}
	
	@Override
	public void deleteCourseVideoMappingById(int id) throws DatabaseServiceException {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
			CourseSubscribedVideo courseSubscribedVideo = session.get(CourseSubscribedVideo.class, id);
			if (courseSubscribedVideo != null) {
				session.delete(courseSubscribedVideo);
				session.getTransaction().commit();
				session.close();
			}
			else {
				throw new DatabaseServiceException("Maping id not found");
			}
		}catch(Exception e) {
	      throw new DatabaseServiceException(e.getMessage());	
	}
}
	@Override
	public String login(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String password = session
				.createQuery("SELECT login.password FROM Login login where login.userId=" + login.getUserId(),
						Login.class)
				.toString();
		if (password.equals(login.getPassword()))
			return "login successful";
		else
			return "login failed";

	}



}
