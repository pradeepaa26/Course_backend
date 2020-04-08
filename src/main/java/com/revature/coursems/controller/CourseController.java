package com.revature.coursems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.coursems.domain.Category;
import com.revature.coursems.domain.Course;
import com.revature.coursems.domain.CourseSubscribedVideo;
import com.revature.coursems.domain.Doc;
import com.revature.coursems.domain.Level;
import com.revature.coursems.domain.updateDTO;
import com.revature.coursems.service.CourseService;

import exception.BusinessServiceException;
import exception.HTTPStatusResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/courses")

public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HTTPStatusResponse> view(){
			List<Course> courseObj;
			try {
		courseObj = courseService.findAllCourses();
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data retrived successfully",courseObj), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
	}
	}

	@GetMapping("/viewCourseById/{id}")
		public ResponseEntity<HTTPStatusResponse> getCourseById(@PathVariable int id ){
		Course course;
		try {
			 course=courseService.getCourseById(id);
				return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data for the id found",course), HttpStatus.OK);
		}catch(BusinessServiceException e) {
			return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
		}			
		}
	
	//@ExceptionHandler(BusinessServiceException.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<HTTPStatusResponse> deleteById(@PathVariable int id){
		try {
		courseService.deleteById(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"deleted given id"), HttpStatus.OK);
	}catch(BusinessServiceException e)
		{
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	
	@PostMapping()
	public ResponseEntity<HTTPStatusResponse> saveCourse(@RequestBody Course course) {
	try {
		courseService.saveCourse(course);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data inserted successfully"), HttpStatus.OK);
	}catch(BusinessServiceException e)
	{
		return new ResponseEntity<>(
				new HTTPStatusResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	}
	
	@PutMapping()
	public ResponseEntity<HTTPStatusResponse> update(@RequestBody updateDTO updateDTOObj){
		try {
		courseService.update(updateDTOObj);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data updated successfully"), HttpStatus.OK);
		}catch(BusinessServiceException e) {
			return new ResponseEntity<>(
					new HTTPStatusResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewLevels")
	public ResponseEntity<HTTPStatusResponse> viewLevels(){
		try {
		List<Level> listOfLevels=courseService.viewLevels();
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data retrived successfully",listOfLevels), HttpStatus.OK);
	}catch(BusinessServiceException e)
		{
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),"data not found"), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/viewCategories")
	public ResponseEntity<HTTPStatusResponse> viewCategories(){
		try {
		List<Category> listOfCategories=courseService.viewCategories();
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data retrived successfully",listOfCategories), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),"data not found"), HttpStatus.NOT_FOUND);
	}
		}
	
	@GetMapping("/switchStatus/{id}")
	public ResponseEntity<HTTPStatusResponse> switchStatus(@PathVariable int id)  {
		try {
		courseService.switchStatus(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"Status switched successfully"), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
	}
	}
	@GetMapping("/viewLevelById/{id}")
	public ResponseEntity<HTTPStatusResponse> viewLevelById(@PathVariable int id){
		try {
		Level level=courseService.viewLevelById(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data for the id found",level), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
	}
	}
	
	@GetMapping("/viewCategoryById/{id}")
	public ResponseEntity<HTTPStatusResponse> viewCategoryById(@PathVariable int id){
				try {
					Category category=courseService.viewCategoryById(id);
			return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value(),"data for the id found",category), HttpStatus.OK);
		}catch(BusinessServiceException e) {
			return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
		}
		}
	
	@GetMapping("/viewDocByCourseId/{id}")
	public  ResponseEntity<HTTPStatusResponse> viewDocByCourseId(@PathVariable int id){
		try {
		List<Doc> listOfDocs=courseService.viewDocByCourseId(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value()," mapped docs for the id found",listOfDocs), HttpStatus.OK);
	}catch(BusinessServiceException e)
		{
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/viewVideoByCourseId/{id}")
	public  ResponseEntity<HTTPStatusResponse> viewVideoByCourseId(@PathVariable int id){
		try {
		List<CourseSubscribedVideo> listOfCourseSubscribedVideos=courseService.viewVideoByCourseId(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value()," mapped videos for the id found",listOfCourseSubscribedVideos), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("deleteCourseVideoMappingById/{id}")
	public ResponseEntity<HTTPStatusResponse> deleteCourseVideoMappingById(@PathVariable int id){
		try { 
			courseService.deleteCourseVideoMappingById(id);
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.OK.value()," mapped videos for the id are deleted",null), HttpStatus.OK);
	}catch(BusinessServiceException e) {
		return new ResponseEntity<>(new HTTPStatusResponse(HttpStatus.NOT_FOUND.value(),e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
	@GetMapping("/login/{userId}/{password}")
	public  ResponseEntity<?> login(@PathVariable String userId,@PathVariable String password){
		String loginStatus=courseService.login(userId,password);
		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}
	

}
