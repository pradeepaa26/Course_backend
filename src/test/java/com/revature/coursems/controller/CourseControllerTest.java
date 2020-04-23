package com.revature.coursems.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.updateDTO;
import com.revature.coursems.exception.BusinessServiceException;
import com.revature.coursems.service.impl.CourseServiceImpl;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@WebAppConfiguration
@AutoConfigureRestDocs
class CourseControllerTest {

	private MockMvc mockmvc;

	private ObjectMapper om = new ObjectMapper();

	@InjectMocks
	CourseController coursecontroller;

	@Mock
	CourseServiceImpl courseService;

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
	void setup(RestDocumentationContextProvider restDocumentation) throws Exception {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(coursecontroller).apply(documentationConfiguration(restDocumentation))
				.build();
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
	void testView() throws Exception {
		when(courseService.findAllCourses()).thenReturn(courseList);
		this.mockmvc.perform(get("/courses")).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testViewExpectFailure() throws Exception {
		doThrow(BusinessServiceException.class).when(courseService).findAllCourses();
		this.mockmvc.perform(get("/courses")).andExpect(status().isNotFound());
	}

	@Test
	void testGetCourseById() throws Exception {
		when(courseService.getCourseById(id)).thenReturn(courseObj);
		this.mockmvc.perform(get("/courses/viewCourseById/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testGetCourseByIdExceptFailure() throws Exception {
		id = 1;
		doThrow(BusinessServiceException.class).when(courseService).getCourseById(id);
		this.mockmvc.perform(get("/courses/viewCourseById/{id}", 1)).andExpect(status().isNotFound());
	}

	@Test
	void testDeleteById() throws Exception {
		Course course = new Course();
		id = 1;
		when(courseService.getCourseById(id)).thenReturn(course);
		this.mockmvc.perform(delete("/courses/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testDeleteByIdExceptFailure() throws Exception {
		id = 1;
		doThrow(BusinessServiceException.class).when(courseService).deleteById(id);
		this.mockmvc.perform(delete("/courses/{id}", 1)).andExpect(status().isNotFound());
	}

	@Test
	void testSaveCourse() throws Exception {
		Course course = new Course();
		doNothing().when(courseService).saveCourse(course);
		String orgJson = om.writeValueAsString(course);
		this.mockmvc.perform(post("/courses").contentType(MediaType.APPLICATION_JSON_VALUE).content(orgJson))
				.andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testSaveCourseExpectFailure() throws Exception {
		Course course = new Course();
		doThrow(BusinessServiceException.class).when(courseService).saveCourse(course);
		this.mockmvc.perform(post("/courses")).andExpect(status().isBadRequest());
	}

	@Test
	void testUpdate() throws Exception {
		updateDTO updateDTOObj = new updateDTO();
		doNothing().when(courseService).update(updateDTOObj);
		String orgJson = om.writeValueAsString(updateDTOObj);
		this.mockmvc.perform(put("/courses").contentType(MediaType.APPLICATION_JSON_VALUE).content(orgJson))
				.andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));

	}

	@Test
	void testUpdateCourseExpectFailure() throws Exception {
		updateDTO updateDTOObj = new updateDTO();
		doThrow(BusinessServiceException.class).when(courseService).update(updateDTOObj);
		this.mockmvc.perform(put("/courses")).andExpect(status().isBadRequest());
	}

	@Test
	void testViewLevels() throws Exception {
		when(courseService.viewLevels()).thenReturn(levelList);
		this.mockmvc.perform(get("/courses/viewLevels")).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testViewLevelsExpectFailure() throws Exception {
		doThrow(BusinessServiceException.class).when(courseService).viewLevels();
		this.mockmvc.perform(get("/courses/viewLevels")).andExpect(status().isNotFound());
	}

	@Test
	void testViewCategories() throws Exception {
		when(courseService.viewCategories()).thenReturn(categoryList);
		this.mockmvc.perform(get("/courses/viewCategories")).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testViewCategoriesExpectFailure() throws Exception {
		doThrow(BusinessServiceException.class).when(courseService).viewCategories();
		this.mockmvc.perform(get("/courses/viewCategories")).andExpect(status().isNotFound());
	}

	@Test
	void testSwitchStatus() throws Exception {
		Course course = new Course();
		id = 1;
		when(courseService.getCourseById(id)).thenReturn(course);
		this.mockmvc.perform(get("/courses/switchStatus/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testSwitchStatusExceptFailure() throws Exception {
		id = 1;
		doThrow(BusinessServiceException.class).when(courseService).switchStatus(id);
		this.mockmvc.perform(get("/courses/switchStatus/{id}", 1)).andExpect(status().isNotFound());
	}

	@Test
	void testViewLevelById() throws Exception {
		when(courseService.viewLevelById(id)).thenReturn(levelObj);
		this.mockmvc.perform(get("/courses/viewLevelById/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testViewLevelByIdExceptFailure() throws Exception {
		id = 1;
		doThrow(BusinessServiceException.class).when(courseService).viewLevelById(id);
		this.mockmvc.perform(get("/courses/viewLevelById/{id}", 1)).andExpect(status().isNotFound());
	}

	@Test
	void testViewCategoryById() throws Exception {
		when(courseService.viewCategoryById(id)).thenReturn(categoryObj);
		this.mockmvc.perform(get("/courses/viewCategoryById/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andDo(document("{methodName}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())));
	}

	@Test
	void testViewCategoryByIdExceptFailure() throws Exception {
		id = 1;
		doThrow(BusinessServiceException.class).when(courseService).viewCategoryById(id);
		this.mockmvc.perform(get("/courses/viewCategoryById/{id}", 1)).andExpect(status().isNotFound());
	}

}
