package com.revature.coursems.domain;



public class ReferenceUrl {


	int id;


	String name;

	
	String url;

	String description;

	private VideoCopy video;
	public ReferenceUrl(){

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VideoCopy getVideo() {
		return video;
	}

	public void setVideo(VideoCopy video) {
		this.video = video;
	}

	
}
