package com.revature.coursems.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class updateDTO {
    private Integer id;
    private String name;
    private int levelId;
    private int categoryId;
    private List<Doc> docObj;
    private List<CourseSubscribedVideo> courseSubscribedVideo;
    private String tag;
    private String slug;
    private Boolean isActive;
    private Boolean isLevelOverride;
	private Boolean isPreSignUp;
	private Boolean isSlugLogin;
	private Boolean isDashboard;
    private String description;
    private String mode;
    private String metaKey;
    private String metaDesc;
    private String course_icon;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private int version;
    private int completionActivityPoints;
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

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsLevelOverride() {
        return isLevelOverride;
    }

    public void setIsLevelOverride(Boolean isLevelOverride) {
        this.isLevelOverride = isLevelOverride;
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public Boolean getIsPreSignUp() {
        return isPreSignUp;
    }

    public void setIsPreSignUp(Boolean isPreSignUp) {
        this.isPreSignUp = isPreSignUp;
    }

    public Boolean getIsSlugLogin() {
        return isSlugLogin;
    }

    public void setIsSlugLogin(Boolean isSlugLogin) {
        this.isSlugLogin = isSlugLogin;
    }

    public Boolean getIsDashboard() {
        return isDashboard;
    }

    public void setIsDashboard(Boolean isDashboard) {
        this.isDashboard = isDashboard;
    }

 
    

}