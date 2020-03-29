package com.revature.coursems.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// @Min(value = 20, message = "Course name shold not be more than 20
	// characters")
	@NotNull // @column(name="",nullable=false)
	@Size(min = 2, max = 200)
	@Column(name = "name")

	private String name;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_id")
	private Level levelObj;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category categoryObj;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Doc> docObj;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CourseSubscribedVideo> courseSubscribedVideo;

	@NotNull
	private String tag;
	@NotNull
	private String slug;
//	@NotNull
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "is_level_override")
	private Boolean isLevelOverride;
	@Column(name = "available_for")
	private Boolean availableFor;
	private String description;
	@Column(name = "meta_key")
	private String metaKey;
	@Column(name = "meta_desc")
	private String metaDesc;
	@Column(name = "course_icon")
	private String course_icon;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "created_on")
	private LocalDate createdOn;
	@Column(name = "modified_on")
	private LocalDate modifiedOn;
	private int version;
	
	@Column(name = "completion_activity_points")
	private int completionActivityPoints;
	@Column(name = "enrollment_activity_points")
	private int enrollmentActivityPoints;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	public int getCompletionActivityPoints() {
		return completionActivityPoints;
	}

	public void setCompletionActivityPoints(int completionActivityPoints) {
		this.completionActivityPoints = completionActivityPoints;
	}

	public int getEnrollmentActivityPoints() {
		return enrollmentActivityPoints;
	}

	public void setEnrollmentActivityPoints(int enrollmentActivityPoints) {
		this.enrollmentActivityPoints = enrollmentActivityPoints;
	}
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Doc> getDocObj() {
		return docObj;
	}

	public void setDocObj(List<Doc> docObj) {
		this.docObj = docObj;
	}

	public List<CourseSubscribedVideo> getCourseSubscribedVideo() {
		return courseSubscribedVideo;
	}

	public void setCourseSubscribedVideo(List<CourseSubscribedVideo> courseSubscribedVideo) {
		this.courseSubscribedVideo = courseSubscribedVideo;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getIsLevelOverride() {
		return isLevelOverride;
	}

	public void setIsLevelOverride(Boolean isLevelOverride) {
		this.isLevelOverride = isLevelOverride;
	}

	public Boolean getAvailableFor() {
		return availableFor;
	}

	public void setAvailableFor(Boolean availableFor) {
		this.availableFor = availableFor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

	public String getCourse_icon() {
		return course_icon;
	}

	public void setCourse_icon(String course_icon) {
		this.course_icon = course_icon;
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

	public void setCratedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Level getLevelObj() {
		return levelObj;
	}

	public void setLevelObj(Level levelObj) {
		this.levelObj = levelObj;
	}

	public Category getCategoryObj() {
		return categoryObj;
	}

	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", levelObj=" + levelObj + ", categoryObj=" + categoryObj
				+ ", DocObj=" + docObj + ", tag=" + tag + ", slug=" + slug + ", isLevelOverride=" + isLevelOverride
				+ ", availableFor=" + availableFor + ", description=" + description + ", metaKey=" + metaKey
				+ ", metaDesc=" + metaDesc + ", course_icon=" + course_icon + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", cratedOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}

}
