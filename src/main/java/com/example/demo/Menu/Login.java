package com.example.demo.Menu;

import java.util.Scanner;

import com.example.demo.DAOclass.UserDAOimplement;


public class Login { //System.out.println("");

    Scanner scanner = new Scanner(System.in);
    
    public void login_menu(char letter) {
        UserDAOimplement logIn = new UserDAOimplement(); 
    
        System.out.println("Log-in as:");
        System.out.println("(A) Admin");
        System.out.println("(C) Customer");

        System.out.println("");
        System.out.print("Enter a choice: ");
        letter = scanner.next().charAt(0);

        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        
        switch (letter) {
        //login as Admin 
        case 'a':
            logIn.Admin_login();
            break;
        case 'A':
            logIn.Admin_login();
            break;
        
        //login as customer
        case 'c':
            logIn.Customer_login();
            break;
        case 'C':
            logIn.Customer_login();
            break;
        }
    }
}
