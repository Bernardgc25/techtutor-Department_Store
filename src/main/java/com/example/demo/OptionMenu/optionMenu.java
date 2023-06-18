package com.example.demo.OptionMenu;

import java.util.Scanner;


public class optionMenu {
    
    public optionMenu(){

    }

    Scanner scanner = new Scanner(System.in);

    //console menu
    public int adminMenu(int opt){
        //String[] options;

        System.out.print("\033[H\033[2J");  
		System.out.flush();

        System.out.print("Choose your option : ");

        String[] options = {"1- Search a product by productID",
                            "2- Search a product by productName",
                            "3- Display all products",
                            "4- Display products by Category",
                            "5- Display total Expenses",
                            "6- Display total Profits",
                            "7- Exit",
                            
                        };  

        int option = 1;
        while (option!=4){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: 
                        break;
                    
                    case 2:  
                        break;
                    
                    case 3: 
                        break;
                    
                    case 4: 
                        break;
                    
                    case 5: 
                        break;
                    
                    case 6: 
                        break;                    
                    
                    case 7: 
                        System.out.print("\033[H\033[2J");  
		                System.out.flush();
                        break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }

        return opt;

        /* 
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
        */
    
    }

    public char customerMenu(char choice){
        return choice;

    }

        private void printMenu(String[] options) {
    }



    }


