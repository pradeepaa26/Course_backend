package com.revature.coursems.repository.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.repository.CourseRepository;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.Login;
import com.revature.coursems.exception.DatabaseServiceException;


@Repository
public class CourseRepositoryImpl implements CourseRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCourse(Course course) throws DatabaseServiceException {
		Session session = this.sessionFactory.getCurrentSession();
		// Here begin transaction
		session.beginTransaction();
		 try {

			// Here put course details into doc course
			if (course.getDocObj() != null)
				course.getDocObj().forEach(docObj -> docObj.setCourse(course));
			// session.save(course);
			// here course details are inserted into the courseSubscribedVido
			if (course.getCourseSubscribedVideo() != null)
				course.getCourseSubscribedVideo()
						.forEach(courseSubscribedVideoObj -> courseSubscribedVideoObj.setCourse(course));
			session.save(course);
			// Here changes get permanent
			session.getTransaction().commit();
			session.close();
		}
		catch(PersistenceException e){
			if(e.getCause().toString().contains("ConstraintViolationException"))
				throw new DatabaseServiceException("The course you are trying to insert already exists.");
			throw new DatabaseServiceException("Insertion failed");
		}

		 finally {
			
		}

	}

	@Override
	public List<Course> findAllCourses() throws DatabaseServiceException {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			// return session.createQuery("SELECT cou FROM Course cou JOIN FETCH
			// cou.categoryObj cat JOIN FETCH cou.levelObj lvl JOIN FETCH cou.docObj doc
			// JOIN FETCH cou.courseSubscribedVideo csv",Course.class).getResultList();
			List<Course> courses = session.createQuery(
					"SELECT cou FROM Course cou JOIN FETCH cou.categoryObj cat JOIN FETCH cou.levelObj lvl",
					Course.class).getResultList();
			// List<Course> courses =session.createQuery("select cou from Course
			// cou",Course.class).getResultList();
			System.err.println("courses=>" + courses);
			return courses;
			// return session.createQuery("From Course",Course.class).getResultList();
		} catch (HibernateException e) {
			throw new DatabaseServiceException("Fetching course details Failed");
		}

	}

	@Override
	public Course deleteById(int id) throws DatabaseServiceException {

		Session session = this.sessionFactory.getCurrentSession();
		Course obj;
		try {
			session.beginTransaction();
			 obj = session.get(Course.class, id);
				if(obj!=null)
					session.delete(obj);
				session.getTransaction().commit();
				session.close();
				return obj;
				
		} catch (HibernateException e) {
			throw new DatabaseServiceException("Deletion Failed");
		}
		
		
	}

	@Override
	public Course findCourseById(int id) throws DatabaseServiceException {
		Course course;
		try{
		Session session = this.sessionFactory.getCurrentSession();
		List<Course> courses = session.createQuery(
				"SELECT cou FROM Course cou JOIN FETCH cou.categoryObj cat JOIN FETCH cou.levelObj lvl where cou.id="
						+ id,
				Course.class).getResultList();
				if(courses.isEmpty())
					course=null;
				else
					course=courses.get(0);
		return course;
		}
		catch(HibernateException e){
			throw new DatabaseServiceException("The requested course cannot be FETCHED");
		}
	}

	@Override
	public void update(Course course) throws DatabaseServiceException {
		try {
		Session session = this.sessionFactory.getCurrentSession();
		
			course.getDocObj().forEach(docObj -> docObj.setCourse(course));
			if (course.getCourseSubscribedVideo() != null)
				course.getCourseSubscribedVideo()
						.forEach(courseSubscribedVideoObj -> courseSubscribedVideoObj.setCourse(course));

			session.beginTransaction();
			// Course updatedCourse = (Course) session.merge(course);
			session.saveOrUpdate(course);
			session.getTransaction().commit();
			session.close();
		} 
		catch (HibernateException e) {
			throw new DatabaseServiceException("Updation for requested course cannot be completed.");
		}
		 finally {
			
		}

	}

	@Override
	public List<Level> viewLevels() throws DatabaseServiceException  {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("From Level", Level.class).getResultList();
		}
		catch(HibernateException e){
			throw new DatabaseServiceException("Levels cannot be FETCHED");
		}
	}

	@Override
	public List<Category> viewCategories() throws DatabaseServiceException {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("From Category", Category.class).getResultList();
		}
		catch(HibernateException e){
			throw new DatabaseServiceException("Categories cannot be FETCHED");
		}
	}

	@Override
	public Course switchStatus(int id) throws DatabaseServiceException {
		try{
			Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Course course = session.get(Course.class, id);
		if(course!=null)
		{	
		if (course.getIsActive())
			course.setIsActive(false);
		else
			course.setIsActive(true);
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		}
		session.close();
		return course;
	}
		catch(HibernateException e){
			throw new DatabaseServiceException("Categories cannot be FETCHED");
		}
	
	}

	@Override
	public Level viewLevelById(int id) throws DatabaseServiceException {
	try
		{	
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Level level = session.get(Level.class, id);
		session.getTransaction().commit();
		// session.close();

		return level;
	}
	catch(HibernateException e){
		throw new DatabaseServiceException("REQUESTED LEVEL cannot be FETCHED");
	}
	}

	@Override
	public Category viewCategoryById(int id) throws DatabaseServiceException {
		Category category;
		try	
		{
			Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		  category = session.get(Category.class, id);
		 System.err.println(category);
		
		session.getTransaction().commit();
		
		// session.close();
		return category;
	}
	catch(HibernateException e){
		System.err.println("category cannot be fetched");
		throw new DatabaseServiceException(" Requested Category cannot be FETCHED");
	}

	}

	@Override
	public List<Doc> viewDocByCourseId(int id) throws DatabaseServiceException {
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Doc> listOfDocs  = session.createQuery("SELECT doc FROM Doc doc where doc.course.id="+ id,Doc.class).getResultList();
		
		return listOfDocs;
		}
		catch(HibernateException e){
			throw new DatabaseServiceException(" Requested document cannot be FETCHED");
		}
	}

	@Override
	public String login(Login login ) throws DatabaseServiceException {
		{
			Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		// Query query=session.createQuery("SELECT login FROM Login login where login.userId=:userId");

		// List<Login> l=
		String password=session.createQuery("SELECT login.password FROM Login login where login.userId="+login.getUserId(),Login.class).toString();
		// String password=l.get(0).getPassword();
		if(password.equals(login.getPassword()))
		return "login successful";
		else 
		return "login failed";
	}
	
	}

}
