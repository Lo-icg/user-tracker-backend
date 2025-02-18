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

    @Column(name = "username")
    private String userName;

    @Column(name = "userpassword")
    private String userPassword;

    @Column(name = "contactnumber")
    private int userContactNumber;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "latitude")
    private double userLatitude;

    @Column(name = "longitude")
    private double userLongitude;

    // Required by JPA default (no-argument) constructor
    protected User() {
    }

    protected User(String username, String password, String email) {
        this.userName = username;
        this.userPassword = password;
        this.userEmail = email;
    }

    // use for creating account
    public static User createAccount(String username, String password, String email) {
        User user = new User(username, password, email);
        return user;
    }

    // getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(int userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

}
