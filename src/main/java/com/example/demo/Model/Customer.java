package com.example.demo.Model;

public class Customer extends User{

    public Customer(){
        super();
    }

    public Customer(char[] fname, char[] lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
        //default value as welcome bonus
        superCoins = 100; 
    }

}
