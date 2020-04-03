package com.revature.coursems.domain;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class VideoCopy {

	int id;
	
	String name;

	String displayName;

	String url;
	
	Time duration;

	String tags;

	Boolean status;
	
	String description;
	
	private String transcript;


	String createdBy;
	
	private Timestamp createdOn;

	String modifiedBy;

	private Timestamp modifiedOn;


	private Level level;

	
	private Category category;


	private List<ReferenceArtifact> referenceArtifact;

	
	private List<SampleProgram> sampleProgram;


	private List<ReferenceUrl> referenceUrl;
	public VideoCopy() {
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ReferenceArtifact> getReferenceArtifact() {
		return referenceArtifact;
	}

	public void setReferenceArtifact(List<ReferenceArtifact> referenceArtifact) {
		this.referenceArtifact = referenceArtifact;
	}

	public List<SampleProgram> getSampleProgram() {
		return sampleProgram;
	}

	public void setSampleProgram(List<SampleProgram> sampleProgram) {
		this.sampleProgram = sampleProgram;
	}

	public List<ReferenceUrl> getReferenceUrl() {
		return referenceUrl;
	}

	public void setReferenceUrl(List<ReferenceUrl> referenceUrl) {
		this.referenceUrl = referenceUrl;
	}

	

}