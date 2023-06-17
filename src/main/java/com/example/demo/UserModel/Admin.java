package com.example.demo.UserModel;

public class Admin extends User{
    
    //constructors
    public Admin(){
        super();
    }

    public Admin(String fname, String lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
    }

}
