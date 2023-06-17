package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserDAOimplement implements UserDAO{
    String firstName, lastName; 
    char[] userName, password, useremail, un, pwd, epwd;

    char letter = '\0'; 
    int t_id = 0;
    int del_tid = 0;
    int upd_tid = 0;

      //list of visitors 
    //public List<Visitor> visitors_list = new ArrayList<Visitor>();;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void register(char choice) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'register'");
        System.out.println("(A) register as a Admin");
        System.out.println("(C) register as a Customer");

        System.out.println("");
        System.out.print("Enter your option: ");
        //System.out.print("Are you a client(c) or visitor(v) ? ");
        choice = scanner.next().charAt(0);

        System.out.print("\033[H\033[2J");  
		System.out.flush();  

    }

    @Override
    public void Admin_login() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'Admin_login'");



    }

    @Override
    public void Customer_login() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'Customer_login'");
    }
    
}
