package com.revature.coursems.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="course_subscribed_videos")
public class CourseSubscribedVideo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private  int id;
	 @Column(name="video_id")
	private int videoId;	
	 //  @ManyToOne
	//  @JoinColumn(name="video_id")			//this was done when we had the video table.Since we are makin REST call for video.. its not neccessary.
	//  private Video video;
	 
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="course_id")
	 private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public Video getVideo() {
	// 	return video;
	// }

	// public void setVideo(Video video) {
	// 	this.video = video;
	// }
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	

}
