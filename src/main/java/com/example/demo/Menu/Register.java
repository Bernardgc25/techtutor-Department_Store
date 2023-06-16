package com.example.demo.Menu;

import java.util.Scanner;

public class Register {
    Scanner scanner = new Scanner(System.in);

    public void reg(char letter) {
        
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
            //m.register(letter);          
            break;
        case 'R':
            //m.register(letter);          
            break;
        
        //login
        case 'l':
            //lm.login_menu(letter);
            break;
        case 'L':
            //lm.login_menu(letter);
            break;
        }
        
     }
}
