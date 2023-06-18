package com.example.demo.OptionMenu;

import java.util.Scanner;


public class optionMenu {
    
    public optionMenu(){

    }

    Scanner scanner = new Scanner(System.in);


    public char adminMenu(char choice){
        System.out.print("\033[H\033[2J");  
		System.out.flush();

        System.out.println("You are logged in as Admin..");
        System.out.println("(I) Search a product by productID");
        System.out.println("(N) Search a product by productName");
        System.out.println("(D) Display products");
        System.out.println("(C) Display products by Category");
        System.out.println("(E) Display total Expenses");
        System.out.println("(P) Display total Profits");
        System.out.println("(X) Exit");
        
        System.out.println("");
        System.out.print("Enter a choice: ");
        choice = scanner.next().charAt(0);
        
        switch (choice) {
        //Search a product by productID  
        case 'I':
                        
            break;
        case 'i':
                        
            break;
        
        //Search a product by productName  
        case 'N':
            
            break;
        case 'n':
            
            break;
        
        //Display products
        case 'D':
            break;
        case 'd':
            break;
        
        //Display products by Category  
        case 'C':
           
            break;
        
        case 'c':
           
            break;
        
        //Display total Expenses
        case 'E':
           
            break;
        
        case 'e':
           
            break;  
            
        //Display total Profits
        case 'P':
           
            break;
        
        case 'p':
           
            break;
            

        //exit menu    
        case 'X':
            System.out.print("\033[H\033[2J");  
		    System.out.flush();
       
            break;
        
        case 'x':
            System.out.print("\033[H\033[2J");  
		    System.out.flush();
               
            break;    

        }
        
        
        return choice;

    }

    public char customerMenu(char choice){
        return choice;

    }

}
