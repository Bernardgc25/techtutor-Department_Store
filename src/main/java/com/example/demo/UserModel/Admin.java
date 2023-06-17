package com.example.demo.UserModel;

public class Admin extends User{
    
    //constructors
    public Admin(){
        super();
    }

     public Admin(String fname, String lname, char[] uname, char[]upwd, char[] uemail, char[] epwd){
        super(fname, lname, uname, upwd, uemail, epwd);
    }

}
