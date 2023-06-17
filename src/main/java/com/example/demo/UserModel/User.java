package com.example.demo.UserModel;

public class User{
    protected String firstname, lastname;
    protected char[] email, username, password;
    protected int superCoins;  

    //constructors
    public User(){

    }

    public User(String fname, String lname, char[] uname, char[]upwd, char[] uemail, char[] epwd){
        this.firstname = fname; 
        this.lastname = lname;
        this.username = uname; 
        this.password = upwd; 
        this.email = uemail; 
        this.password = epwd; 
    }

    //setters and getters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char[] getEmail() {
        return email;
    }

    public void setEmail(char[] email) {
        this.email = email;
    }

    public char[] getUsername() {
        return username;
    }

    public void setUsername(char[] username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }


}