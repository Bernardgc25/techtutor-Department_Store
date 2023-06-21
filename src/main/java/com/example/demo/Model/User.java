package com.example.demo.Model;

public class User{
    protected char[] firstname, lastname;
    protected char[] email, username, password;
    protected int superCoins;  

    //constructors
    public User(){

    }

    public User(char[] fname, char[] lname, char[] uname,  char[] uemail, char[]pwd){
        this.firstname = fname; 
        this.lastname = lname;
        this.username = uname; 
        this.email = uemail; 
        this.password = pwd; 
    }

    //setters and getters
    public char[] getFirstname() {
        return firstname;
    }

    public void setFirstname(char[] firstname) {
        this.firstname = firstname;
    }

    public char[] getLastname() {
        return lastname;
    }

    public void setLastname(char[] lastname) {
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