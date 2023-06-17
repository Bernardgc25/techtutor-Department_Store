package com.example.demo.UserModel;

public class Customer extends User{

    public Customer(){
        super();
    }

    public Customer(String fname, String lname, char[] uname, char[]upwd, char[] uemail, char[] epwd){
        super(fname, lname, uname, upwd, uemail, epwd);
        
        //default value as welcome bonus
        superCoins = 100; 
    }

}
