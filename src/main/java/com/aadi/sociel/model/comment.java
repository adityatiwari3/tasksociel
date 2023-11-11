package com.aadi.sociel.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long commentId;
    private String message;
    private Date commentDateAndTime;
    private Long postedByUserId;
    private Long postedForUserId;
    public comment(Long commentId, String message, Date commentDateAndTime, Long postedByUserId,Long postedForUserId) {
        this.commentId = commentId;
        this.message = message;
        this.commentDateAndTime = commentDateAndTime;
        this.postedByUserId = postedByUserId;
        this.postedForUserId = postedForUserId;
    }
    public comment(String message, Date commentDateAndTime, Long postedByUserId,Long postedForUserId) {
        this.message = message;
        this.commentDateAndTime = commentDateAndTime;
        this.postedByUserId = postedByUserId;
        this.postedForUserId = postedForUserId;
    }
    public comment() {
    }
    public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getCommentDateAndTime() {
        return commentDateAndTime;
    }
    public void setCommentDateAndTime(Date commentDateAndTime) {
        this.commentDateAndTime = commentDateAndTime;
    }
    public Long getPostedForUserId() {
        return postedForUserId;
    }
    public void setPostedForUserId(Long postedForUserId) {
        this.postedForUserId = postedForUserId;
    }
    public Long getPostedByUserId() {
        return postedByUserId;
    }
    public void setPostedByUserId(Long postedByUserId) {
        this.postedByUserId = postedByUserId;
    }

}
