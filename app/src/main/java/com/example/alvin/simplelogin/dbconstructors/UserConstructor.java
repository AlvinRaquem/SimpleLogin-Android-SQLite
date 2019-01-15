package com.example.alvin.simplelogin.dbconstructors;

/**
 * Created by User on 1/15/2019.
 */

public class UserConstructor {

    public static final String FIELD_ID="idno";
    public static final String FULLNAME="fullname";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    public static final String TABLE_NAME="tbl_users";
    public static final String GENDER="gender";

    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+
            " ("+FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            " "+FULLNAME+" TEXT NULL,"+
            " "+USERNAME+" TEXT NULL,"+
            " "+PASSWORD+" TEXT NULL,"+
            " "+GENDER+" TEXT NULL);";
    private int idno;
    private String fullname,username,password,gender;

    public int getIdno() {
        return idno;
    }

    public void setIdno(int idno) {
        this.idno = idno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
