package com.revature.coursems.domain;



public class SampleProgram {

	int id;
	
	
	String name;
	
	
	String file;
	

	String description;
	private VideoCopy video;

	
	public SampleProgram(){

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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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
