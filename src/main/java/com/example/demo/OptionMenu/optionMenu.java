package com.example.demo.OptionMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.demo.DAOclass.StoreInformationDAOimplement;


public class optionMenu {
    
    public optionMenu(){

    }

    Scanner scanner = new Scanner(System.in);
    StoreInformationDAOimplement sm = new StoreInformationDAOimplement(); 

    //console menu
    public int adminMenu(int opt){
        boolean notDone = true;
        
        while(notDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            //System.out.println("Choose your option: ");
            System.out.println("User Option Menu");
            System.out.println("0 - Exit");
            System.out.println("1 - Search a product by productID");
            System.out.println("2 - Search a product by productName");  
            System.out.println("3 - Display all products");
            System.out.println("4 - Display products by Category");
            System.out.println("5 - Display total Expenses");
            System.out.println("6 - Display total Profits");
            
            
            System.out.println("");
            System.out.print("Enter a choice: ");
            try {
                opt = scanner.nextInt();

                switch (opt){
                case 0: 
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    notDone = false; 
                    break; 
                case 1: 
                    sm.searchbyProductId();
                    break;
                case 2:  
                    sm.searchbyProductName();
                    break;
                case 3:
                    sm.dispsallProduct();
                    break;
                case 4:
                    sm.dispProductbyCategory(); 
                    break;
                case 5:
                    sm.dispExpenses(); 
                    break;
                case 6:
                    sm.dispProfit(); 
                    break;                    
                }       
            } 
            catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input, integer only");
                System.out.println("press any character to continue");
    
                char choice = scanner.next().charAt(0);

                choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                    notDone = true; 
                }
            }

            
        }
        
        return opt;    
    }


    public int customerMenu(int opt){
        //clear screen
        System.out.print("\033[H\033[2J");  
		System.out.flush();

        return opt;
    }



}

