package com.example.demo.OptionMenu;

import java.util.Scanner;

import com.example.demo.DAOclass.StoreInformationDAOimplement;


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
        StoreInformationDAOimplement sm = new StoreInformationDAOimplement(); 
        int option = 1;
        while (option != 7){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
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
    }

    public char customerMenu(char choice){
        return choice;

    }

        private void printMenu(String[] options) {
    }



    }


