package com.example.demo.Model;

public class Admin extends User{
    
    //constructors
    public Admin(){
        super();
    }

    public Admin(char[] fname, char[] lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
    }

}