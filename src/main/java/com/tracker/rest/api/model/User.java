package com.tracker.rest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_activity_logs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // what
    private Long id;

    // @Column(name = "username")
    // private String userName;

    // @Column(name = "userpassword")
    // private String userPassword;

    @Column(name = "Email")
    private String userEmail;

    @Column(name = "Password")
    private String userPassword;

    @Column(name = "ContactNumber")
    private String userContactNumber;

    // @Column(name = "latitude")
    // private double userLatitude;

    // @Column(name = "longitude")
    // private double userLongitude;

    // Required by JPA default (no-argument) constructor
    protected User() {
    }

    protected User(String userEmail, String userPassword) {
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    // use for creating account
    public static User createAccount(String userEmail, String userPassword) {
        User user = new User(userEmail, userPassword);
        return user;
    }

    // getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public String getUserName() {
    // return userName;
    // }

    // public void setUserName(String userName) {
    // this.userName = userName;
    // }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // public double getUserLatitude() {
    // return userLatitude;
    // }

    // public void setUserLatitude(double userLatitude) {
    // this.userLatitude = userLatitude;
    // }

    // public double getUserLongitude() {
    // return userLongitude;
    // }

    // public void setUserLongitude(double userLongitude) {
    // this.userLongitude = userLongitude;
    // }

}
