package com.example.student_feedback;

import java.io.Serializable;

public class data implements Serializable {

    String name;
    String college;
    String year;
    String email;
    String mobile;
    String feedback;
    String write;
    int rating;
    String time;

    public data(String name, String college, String year, String email, String mobile, String feedback, String write, int rating, String time) {
        this.name = name;
        this.college = college;
        this.year = year;
        this.email = email;
        this.mobile = mobile;
        this.feedback = feedback;
        this.write = write;
        this.rating = rating;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
