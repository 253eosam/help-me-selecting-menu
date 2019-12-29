package com.example.dhzm2.helperyourdiet;

/**
 * Created by dhzm2 on 2018-05-14.
 */

public class UserMenu {
    private String userMenuName;
    private String userMenuType;
    private String userMenuAmount;
    private String userMenuKcal;
    private String userMenuDate;
    private String userMenuMeal;

    public UserMenu(String userMenuName, String userMenuType, String userMenuAmount, String userMenuKcal, String userMenuDate, String userMenuMeal) {
        this.userMenuName = userMenuName;
        this.userMenuType = userMenuType;
        this.userMenuAmount = userMenuAmount;
        this.userMenuKcal = userMenuKcal;
        this.userMenuDate = userMenuDate;
        this.userMenuMeal = userMenuMeal;
    }


    public String getUserMenuName() {
        return userMenuName;
    }

    public void setUserMenuName(String userMenuName) {
        this.userMenuName = userMenuName;
    }

    public String getUserMenuType() {
        return userMenuType;
    }

    public void setUserMenuType(String userMenuType) {
        this.userMenuType = userMenuType;
    }

    public String getUserMenuAmount() {
        return userMenuAmount;
    }

    public void setUserMenuAmount(String userMenuAmount) {
        this.userMenuAmount = userMenuAmount;
    }

    public String getUserMenuKcal() {
        return userMenuKcal;
    }

    public void setUserMenuKcal(String userMenuKcal) {
        this.userMenuKcal = userMenuKcal;
    }

    public String getUserMenuDate() {
        return userMenuDate;
    }

    public void setUserMenuDate(String userMenuDate) {
        this.userMenuDate = userMenuDate;
    }

    public String getUserMenuMeal() {
        return userMenuMeal;
    }

    public void setUserMenuMeal(String userMenuMeal) {
        this.userMenuMeal = userMenuMeal;
    }

}
