package com.example.dhzm2.helperyourdiet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dhzm2 on 2018-05-01.
 */

public class User implements Serializable {
    private String userID ;
    private String userPassword ;
    private String userName ;
    private String userAge ;
    private String userSex;
    private String userHeight ;
    private String userWeight;
    private String userActive;
    private String userMealAmount;
    private String userMealTime;
    private String userTargetWeight;
    private ArrayList<String> userFoodTaste;
    private String userRDA;

    private static volatile User userInstance = null;

    private User(){}

    public static User getInstance(){
        if(userInstance == null){
            synchronized (User.class){
                if(userInstance==null){
                    userInstance = new User();
                }
            }
        }
        return userInstance;
    }

    public User(String id, String pwd, String name, String age, String h, String w, String s){
        this.userID = id;
        this.userPassword = pwd;
        this.userName = name;
        this.userAge = age;
        this.userHeight = h;
        this.userWeight = w;
        this.userSex = s;
    }
    public User(String id, String pwd, String name, String age, String h, String w, String s, String a, String amount, String time, String target){
        this.userID = id;
        this.userPassword = pwd;
        this.userName = name;
        this.userAge = age;
        this.userHeight = h;
        this.userWeight = w;
        this.userSex = s;
        this.userActive = a;
        this.userMealAmount = amount;
        this.userMealTime = time;
        this.userTargetWeight = target;
    }
    public User(String id, String pwd, String name, String age, String h, String w, String s, String a, String amount, String time, String target,ArrayList<String> userFoodTaste){
        this.userID = id;
        this.userPassword = pwd;
        this.userName = name;
        this.userAge = age;
        this.userHeight = h;
        this.userWeight = w;
        this.userSex = s;
        this.userActive = a;
        this.userMealAmount = amount;
        this.userMealTime = time;
        this.userTargetWeight = target;
        this.userFoodTaste = userFoodTaste;
    }
    public User(String id, String pwd, String name, String age, String h, String w, String s, String a, String amount, String time, String target,ArrayList<String> userFoodTaste,String RDA){
        this.userID = id;
        this.userPassword = pwd;
        this.userName = name;
        this.userAge = age;
        this.userSex = s;
        this.userHeight = h;
        this.userWeight = w;
        this.userActive = a;
        this.userMealAmount = amount;
        this.userMealTime = time;
        this.userTargetWeight = target;
        this.userFoodTaste = userFoodTaste;
        this.userRDA = RDA;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserActive() {
        return userActive;
    }

    public void setUserActive(String userActive) {
        this.userActive = userActive;
    }

    public String getUserMealAmount() {
        return userMealAmount;
    }

    public void setUserMealAmount(String userMealAmount) {
        this.userMealAmount = userMealAmount;
    }

    public String getUserMealTime() {
        return userMealTime;
    }

    public void setUserMealTime(String userMealTime) {
        this.userMealTime = userMealTime;
    }

    public String getUserTargetWeight() {
        return userTargetWeight;
    }

    public void setUserTargetWeight(String userTargetWeight) {
        this.userTargetWeight = userTargetWeight;
    }

    public ArrayList<String> getUserFoodTaste() {
        return userFoodTaste;
    }

    public void setUserFoodTaste(ArrayList<String> userFoodTaste) {
        this.userFoodTaste = userFoodTaste;
    }

    public String getUserRDA() {
        return userRDA;
    }

    public void setUserRDA(String userRDA) {
        this.userRDA = userRDA;
    }
}
