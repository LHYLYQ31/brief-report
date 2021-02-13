package com.lypz.briefreport.modules.briefreport.model;

import java.util.Date;

public class BriefReport {
    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Integer isDeleted;

    private Integer userId;

    private Integer brStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBrStatus() {
        return brStatus;
    }

    public void setBrStatus(Integer brStatus) {
        this.brStatus = brStatus;
    }
}