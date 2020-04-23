package com.revature.coursems.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.exception.BusinessServiceException;
import com.revature.coursems.exception.DatabaseServiceException;
import com.revature.coursems.repository.impl.CourseRepositoryImpl;

class CourseServiceImplTest {

	@InjectMocks
	private CourseServiceImpl courseService;

	@Mock
	CourseRepositoryImpl courseRepo;

	@Spy
	List<Course> courseList = new ArrayList<Course>();

	@Spy
	List<Level> levelList = new ArrayList<Level>();

	@Spy
	List<Category> categoryList = new ArrayList<Category>();

	@Spy
	List<Doc> docList = new ArrayList<Doc>();

	@Spy
	List<CourseSubscribedVideo> courseVideoList = new ArrayList<CourseSubscribedVideo>();

	private Level levelObj;

	private Category categoryObj;

	private List<Doc> docObj;

	private List<CourseSubscribedVideo> courseSubscribedVideo;

	private int id;

	private Course courseObj;

	private int courseid;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		courseList = getCourseList();
		levelList = getLevelList();
		categoryList = getCategoryList();
		docList = getDocList();
		courseVideoList = getCourseVideoList();
	}

	public List<CourseSubscribedVideo> getCourseVideoList() {

		CourseSubscribedVideo csv = new CourseSubscribedVideo();

		csv.setId(1);
		csv.setVideoId(1);
		csv.setCourse(courseObj);

		courseVideoList.add(csv);
		return courseVideoList;
	}

	public List<Course> getCourseList() {

		Course course = new Course();

		course.setId(1);
		course.setName("Java");
		course.setLevelObj(levelObj);
		course.setCategoryObj(categoryObj);
		course.setDocObj(docObj);
		course.setCourseSubscribedVideo(courseSubscribedVideo);
		course.setTag("Class");
		course.setSlug("Java");
		course.setIsActive(true);
		course.setIsLevelOverride(true);
		course.setIsPreSignUp(true);
		course.setIsSlugLogin(true);
		course.setIsDashboard(false);
		course.setDescription("Java is a Programming Language");
		course.setMetaKey("Java");
		course.setMetaDesc("Java is a Programming Language");
		course.setCourse_icon("https://localhost:8081");
		course.setCreatedBy("Pradeepaa");
		course.setModifiedBy("Yogesh");
		LocalDateTime cDateTime = LocalDateTime.of(2020, 04, 15, 18, 45, 32);
		course.setCreatedOn(cDateTime);
		LocalDateTime mDateTime = LocalDateTime.of(2020, 04, 15, 18, 50, 45);
		course.setModifiedOn(mDateTime);
		course.setVersion(1);
		course.setMode("T");
		course.setCompletionActivityPoints(12);
		course.setEnrollmentActivityPoints(15);

		courseList.add(course);
		return courseList;

	}

	public List<Level> getLevelList() {

		Level level = new Level();
		level.setId(1);
		level.setName("Level 1");
		level.setActive(true);
		level.setCreatedBy("Pradeepaa");
		level.setModifiedBy("Yogesh");
		LocalDate cDateTime = LocalDate.of(2020, 04, 15);
		level.setCratedOn(cDateTime);
		LocalDate mDateTime = LocalDate.of(2020, 04, 15);
		level.setModifiedOn(mDateTime);

		levelList.add(level);
		return levelList;
	}

	public List<Category> getCategoryList() {
		Category category = new Category();
		category.setId(1);
		category.setName("Level 1");
		category.setActive(true);
		category.setCreatedBy("Pradeepaa");
		category.setModifiedBy("Yogesh");
		LocalDate cDateTime = LocalDate.of(2020, 04, 15);
		category.setCratedOn(cDateTime);
		LocalDate mDateTime = LocalDate.of(2020, 04, 15);
		category.setModifiedOn(mDateTime);

		categoryList.add(category);
		return categoryList;

	}

	public List<Doc> getDocList() {
		Doc doc = new Doc();
		doc.setId(1);
		doc.setName("Java");
		doc.setContent("Java is a Programming Language");
		doc.setCourse(courseObj);
		LocalDateTime cDateTime = LocalDateTime.of(2020, 04, 15, 18, 45, 32);
		doc.setCreatedOn(cDateTime);
		LocalDateTime mDateTime = LocalDateTime.of(2020, 04, 15, 19, 45, 32);
		doc.setModifiedOn(mDateTime);

		docList.add(doc);
		return docList;
	}

	@Test
	void testFindAllCourses() throws DatabaseServiceException, BusinessServiceException {
		when(courseRepo.findAllCourses()).thenReturn(courseList);
		assertNotNull(courseList);
		assertEquals(courseService.findAllCourses(), courseList);
	}

	@Test
	void testGetCourseById() throws DatabaseServiceException, BusinessServiceException {
		Course course = new Course();
		course.setName("Java");
		course.setLevelObj(levelObj);
		course.setCategoryObj(categoryObj);
		course.setDocObj(docObj);
		course.setCourseSubscribedVideo(courseSubscribedVideo);
		course.setTag("Class");
		course.setSlug("Java");
		course.setIsActive(true);
		course.setIsLevelOverride(true);
		course.setIsPreSignUp(true);
		course.setIsSlugLogin(true);
		course.setIsDashboard(false);
		course.setDescription("Java is a Programming Language");
		course.setMetaKey("Java");
		course.setMetaDesc("Java is a Programming Language");
		course.setCourse_icon("https://localhost:8081");
		course.setCreatedBy("Pradeepaa");
		course.setModifiedBy("Yogesh");
		LocalDateTime cDateTime = LocalDateTime.of(2020, 04, 15, 18, 45, 32);
		course.setCreatedOn(cDateTime);
		LocalDateTime mDateTime = LocalDateTime.of(2020, 04, 15, 18, 50, 45);
		course.setModifiedOn(mDateTime);
		course.setVersion(1);
		course.setMode("T");
		course.setCompletionActivityPoints(12);
		course.setEnrollmentActivityPoints(15);

		when(courseRepo.findCourseById(id)).thenReturn(course);
		assertNotNull(course);
		assertEquals(courseService.getCourseById(id), course);
	}

	@Test
	void testDeleteById() throws DatabaseServiceException {
		Course course = new Course();
		when(courseRepo.findCourseById(id)).thenReturn(course);
		assertNotNull(course);
		courseRepo.deleteById(id);
		verify(courseRepo).deleteById(id);
	}

	@Test
	void testSaveCourse() {
		Course course = mock(Course.class);
		when(course.getName()).thenReturn("Java");
		when(course.getLevelObj()).thenReturn(levelObj);
		when(course.getCategoryObj()).thenReturn(categoryObj);
		when(course.getDocObj()).thenReturn(docObj);
		when(course.getCourseSubscribedVideo()).thenReturn(courseSubscribedVideo);
		when(course.getTag()).thenReturn("Class");
		when(course.getSlug()).thenReturn("Java");
		when(course.getIsActive()).thenReturn(true);
		when(course.getIsLevelOverride()).thenReturn(true);
		when(course.getIsPreSignUp()).thenReturn(true);
		when(course.getIsSlugLogin()).thenReturn(true);
		when(course.getIsDashboard()).thenReturn(false);
		when(course.getDescription()).thenReturn("Java is a Programming Language");
		when(course.getMetaKey()).thenReturn("Java");
		when(course.getMetaDesc()).thenReturn("Java is a Programming Language");
		when(course.getCourse_icon()).thenReturn("https://localhost:8081");
		when(course.getCreatedBy()).thenReturn("Pradeepaa");
		when(course.getModifiedBy()).thenReturn("Yogesh");
		LocalDateTime cDateTime = LocalDateTime.of(2020, 03, 22, 11, 42, 32);
		when(course.getCreatedOn()).thenReturn(cDateTime);
		LocalDateTime mDateTime = LocalDateTime.of(2020, 03, 22, 11, 42, 32);
		when(course.getModifiedOn()).thenReturn(mDateTime);
		when(course.getVersion()).thenReturn(1);
		when(course.getMode()).thenReturn("T");
		when(course.getCompletionActivityPoints()).thenReturn(12);
		when(course.getEnrollmentActivityPoints()).thenReturn(15);

		assertEquals("Java", course.getName());
		assertEquals(levelObj, course.getLevelObj());
		assertEquals(categoryObj, course.getCategoryObj());
		assertEquals(docObj, course.getDocObj());
		assertEquals(courseSubscribedVideo, course.getCourseSubscribedVideo());
		assertEquals("Class", course.getTag());
		assertEquals("Java", course.getSlug());
		assertEquals(true, course.getIsActive());
		assertEquals(true, course.getIsLevelOverride());
		assertEquals(true, course.getIsPreSignUp());
		assertEquals(true, course.getIsSlugLogin());
		assertEquals(false, course.getIsDashboard());
		assertEquals("Java is a Programming Language", course.getDescription());
		assertEquals("Java", course.getMetaKey());
		assertEquals("Java is a Programming Language", course.getMetaDesc());
		assertEquals("https://localhost:8081", course.getCourse_icon());
		assertEquals("Pradeepaa", course.getCreatedBy());
		assertEquals("Yogesh", course.getModifiedBy());
		assertEquals(cDateTime, course.getCreatedOn());
		assertEquals(mDateTime, course.getModifiedOn());
		assertEquals(1, course.getVersion());
		assertEquals("T", course.getMode());
		assertEquals(12, course.getCompletionActivityPoints());
		assertEquals(15, course.getEnrollmentActivityPoints());

	}

	@Test
	void testUpdate() {
		Course course = mock(Course.class);
		when(course.getName()).thenReturn("Java");
		when(course.getLevelObj()).thenReturn(levelObj);
		when(course.getCategoryObj()).thenReturn(categoryObj);
		when(course.getDocObj()).thenReturn(docObj);
		when(course.getCourseSubscribedVideo()).thenReturn(courseSubscribedVideo);
		when(course.getTag()).thenReturn("Class");
		when(course.getSlug()).thenReturn("Java");
		when(course.getIsActive()).thenReturn(true);
		when(course.getIsLevelOverride()).thenReturn(true);
		when(course.getIsPreSignUp()).thenReturn(true);
		when(course.getIsSlugLogin()).thenReturn(true);
		when(course.getIsDashboard()).thenReturn(false);
		when(course.getDescription()).thenReturn("Java is a Programming Language");
		when(course.getMetaKey()).thenReturn("Java");
		when(course.getMetaDesc()).thenReturn("Java is a Programming Language");
		when(course.getCourse_icon()).thenReturn("https://localhost:8081");
		when(course.getCreatedBy()).thenReturn("Pradeepaa");
		when(course.getModifiedBy()).thenReturn("Yogesh");
		LocalDateTime cDateTime = LocalDateTime.of(2020, 03, 22, 11, 42, 32);
		when(course.getCreatedOn()).thenReturn(cDateTime);
		LocalDateTime mDateTime = LocalDateTime.of(2020, 03, 22, 11, 42, 32);
		when(course.getModifiedOn()).thenReturn(mDateTime);
		when(course.getVersion()).thenReturn(1);
		when(course.getMode()).thenReturn("T");
		when(course.getCompletionActivityPoints()).thenReturn(12);
		when(course.getEnrollmentActivityPoints()).thenReturn(15);

		assertEquals("Java", course.getName());
		assertEquals(levelObj, course.getLevelObj());
		assertEquals(categoryObj, course.getCategoryObj());
		assertEquals(docObj, course.getDocObj());
		assertEquals(courseSubscribedVideo, course.getCourseSubscribedVideo());
		assertEquals("Class", course.getTag());
		assertEquals("Java", course.getSlug());
		assertEquals(true, course.getIsActive());
		assertEquals(true, course.getIsLevelOverride());
		assertEquals(true, course.getIsPreSignUp());
		assertEquals(true, course.getIsSlugLogin());
		assertEquals(false, course.getIsDashboard());
		assertEquals("Java is a Programming Language", course.getDescription());
		assertEquals("Java", course.getMetaKey());
		assertEquals("Java is a Programming Language", course.getMetaDesc());
		assertEquals("https://localhost:8081", course.getCourse_icon());
		assertEquals("Pradeepaa", course.getCreatedBy());
		assertEquals("Yogesh", course.getModifiedBy());
		assertEquals(cDateTime, course.getCreatedOn());
		assertEquals(mDateTime, course.getModifiedOn());
		assertEquals(1, course.getVersion());
		assertEquals("T", course.getMode());
		assertEquals(12, course.getCompletionActivityPoints());
		assertEquals(15, course.getEnrollmentActivityPoints());
	}

	@Test
	void testViewLevels() throws DatabaseServiceException, BusinessServiceException {
		when(courseRepo.viewLevels()).thenReturn(levelList);
		assertNotNull(levelList);
		assertEquals(courseService.viewLevels(), levelList);
	}

	@Test
	void testViewCategories() throws DatabaseServiceException, BusinessServiceException {
		when(courseRepo.viewCategories()).thenReturn(categoryList);
		assertNotNull(categoryList);
		assertEquals(courseService.viewCategories(), categoryList);
	}

	@Test
	void testViewLevelById() throws DatabaseServiceException, BusinessServiceException {
		Level level = new Level();
		level.setName("Level 1");
		level.setActive(true);
		level.setCreatedBy("Pradeepaa");
		level.setModifiedBy("Yogesh");
		LocalDate cDateTime = LocalDate.of(2020, 04, 15);
		level.setCratedOn(cDateTime);
		LocalDate mDateTime = LocalDate.of(2020, 04, 15);
		level.setModifiedOn(mDateTime);

		when(courseRepo.viewLevelById(id)).thenReturn(level);
		assertNotNull(level);
		assertEquals(courseService.viewLevelById(id), level);
	}

	@Test
	void testViewCategoryById() throws DatabaseServiceException, BusinessServiceException {
		Category category = new Category();
		category.setName("Level 1");
		category.setActive(true);
		category.setCreatedBy("Pradeepaa");
		category.setModifiedBy("Yogesh");
		LocalDate cDateTime = LocalDate.of(2020, 04, 15);
		category.setCratedOn(cDateTime);
		LocalDate mDateTime = LocalDate.of(2020, 04, 15);
		category.setModifiedOn(mDateTime);

		when(courseRepo.viewCategoryById(id)).thenReturn(category);
		assertNotNull(category);
		assertEquals(courseService.viewCategoryById(id), category);

	}

}
