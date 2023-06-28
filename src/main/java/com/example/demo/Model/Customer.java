package com.example.demo.Model;

public class Customer extends User{

    public Customer(){
        super();

        //default value as welcome bonus
        superCoins = 100;
    }

    public Customer(char[] fname, char[] lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
        
         
    }

    //retrieving an account from database
    public Customer(String Username, String Password){
        super(Username, Password);

    }
}
