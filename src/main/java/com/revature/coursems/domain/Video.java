package com.revature.coursems.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String url;
private String name;
@Column(name = "created_by")
private String createdBy;
@Column(name = "modified_by")
private String modifiedBy;
@Column(name = "created_on")
private LocalDate createdOn;
@Column(name = "modified_on")
private LocalDate modifiedOn;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public LocalDate getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(LocalDate createdOn) {
	this.createdOn = createdOn;
}
public LocalDate getModifiedOn() {
	return modifiedOn;
}
public void setModifiedOn(LocalDate modifiedOn) {
	this.modifiedOn = modifiedOn;
}

}
