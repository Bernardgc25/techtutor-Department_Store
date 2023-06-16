package com.example.demo.Menu;

import java.util.Scanner;


public class Login { //System.out.println("");

    Scanner scanner = new Scanner(System.in);
    
    public void login_menu(char letter) {
         //System.out.println("");
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
            break;
        case 'A':
            break;
        
        //login as customer
        case 'c':
            break;
        case 'C':
            break;
        }
    }
}
