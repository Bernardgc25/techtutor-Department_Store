package com.example.demo.Menu;

import com.example.demo.DAOclass.UserDAOimplement;
import java.util.Scanner;

public class Register {
    Scanner scanner = new Scanner(System.in);

    public void reg(char letter) {
        UserDAOimplement usr_register = new UserDAOimplement(); 
        Login usr_login = new Login();

        System.out.println("(R) Register");
        System.out.println("(L) Login");

        System.out.println("");
        System.out.print("Enter a choice: ");
        letter = scanner.next().charAt(0);

        System.out.print("\033[H\033[2J");  
		System.out.flush();  

        switch (letter) {
        //register    
        case 'r':
            usr_register.register(letter);
            break;
        case 'R':
            usr_register.register(letter);         
            break;
        
        //login
        case 'l':
            usr_login.login_menu(letter);
            break;
        case 'L':
            usr_login.login_menu(letter);
            break;
        }
    }
}
