package com.revature.coursems.controller;

import java.util.Arrays;
import java.util.List;

import com.revature.coursems.domain.LevelCopy;
import com.revature.coursems.domain.VideoCopy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/videos")
public class VideoController{
    @GetMapping(value="/listAll")
	public  ResponseEntity<?> viewVideos(){
        List<VideoCopy> videoCopy;
        RestTemplate restTemplate=new RestTemplate();
        VideoCopy[] videos=(VideoCopy[])restTemplate.getForObject("http://localhost:5657/video/list", VideoCopy[].class);
        videoCopy=Arrays.asList(videos);
		return new ResponseEntity<>(videoCopy, HttpStatus.OK);
   }
   @GetMapping("/listVideoById/{id}")
   public  ResponseEntity<?> viewVideoById(@PathVariable int id){
    List<VideoCopy> videoCopy;
    RestTemplate restTemplate=new RestTemplate();
    VideoCopy[] video=restTemplate.getForObject("http://localhost:5657/video//listById/"+id, VideoCopy[].class);
    videoCopy=Arrays.asList(video);
     return new ResponseEntity<>(videoCopy.get(0), HttpStatus.OK);
}
    // @GetMapping(value="/listlevels")
	// public  ResponseEntity<?> viewLevels(){
	// 	RestTemplate restTemplate=new RestTemplate();
	// 	LevelCopy level=restTemplate.getForObject("http://localhost:5657/video/listLevels", LevelCopy.class);
	// 	return new ResponseEntity<>(level, HttpStatus.OK);
    // }

    @GetMapping (value="/sayHello")
    public String sayHello(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:5657/video/sayHello", String.class);
    }
}