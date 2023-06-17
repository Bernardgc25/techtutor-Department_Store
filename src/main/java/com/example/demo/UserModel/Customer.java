package com.example.demo.UserModel;

public class Customer extends User{

    public Customer(){
        super();
    }

    public Customer(String fname, String lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
        //default value as welcome bonus
        superCoins = 100; 
    }

}
