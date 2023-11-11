package com.aadi.sociel.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userID;
    private Date userCreatedAt;
    private String userName;
    public user(Long userID,Date userCreatedAt,String userName) {
        this.userID = userID;
        this.userCreatedAt = userCreatedAt;
        this.userName = userName;
    }
    public Date getUserCreatedAt() {
        return userCreatedAt;
    }
    public void setUserCreatedAt(Date userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }
    public user(String userName,Date userCreatedAt) {
        this.userName = userName;
        this.userCreatedAt = userCreatedAt;
    }
    public user() {
    }
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public String getCommentFrom() {
        return userName;
    }
    public void setCommentFrom(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "user [userID=" + userID + ", userName=" + userName + "]";
    }

}
