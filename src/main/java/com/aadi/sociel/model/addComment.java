package com.aadi.sociel.model;

public class addComment {
    private String commentFrom;
    private String commentTo;
    private String message;
    public addComment(String commentFrom, String commentTo, String message) {
        // @NotBlank(message = "Name must not be blank")
        this.commentFrom = commentFrom;
        this.commentTo = commentTo;
        this.message = message;
    }
    public addComment() {
    }
    public String getCommentFrom() {
        return commentFrom;
    }
    public void setCommentFrom(String commentFrom) {
        this.commentFrom = commentFrom;
    }
    public String getCommentTo() {
        return commentTo;
    }
    public void setCommentTo(String commentTo) {
        this.commentTo = commentTo;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "addComment [commentFrom=" + commentFrom + ", commentTo=" + commentTo + ", message=" + message + "]";
    }
    
}
