package com.example.demo.Service;

import com.example.demo.DAO.StoreDAO;
import com.example.demo.DAO.AdminDAO;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Customer;
import com.example.demo.OptionMenu.optionMenu;
import com.example.demo.Service_Interface.User_Service_Interface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User_Service_impl implements User_Service_Interface{
    //user input 
    char[] firstName, lastName; 
    char[] userName, useremail, password;

    ///Admin 
   // public List<Admin> Adminlist = new ArrayList<Admin>(1);
   // public List<Customer> Customerlist = new ArrayList<Customer>();

    //Scanner scanner = new Scanner(System.in);
    Scanner scanner;
    


    private AdminDAO uDao; 
   // Admin ad = new Admin();
    Customer cu = new Customer();

    public User_Service_impl()
    {
        scanner = new Scanner(System.in);
        AdminDAO uDao = new AdminDAO(); 
    }
                        

    @Override
    public void register_menu(int opt) {
        boolean notDone = true;
        char choice = '\0';

        while(notDone){
            //clearscreen
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            
            System.out.println("UserDA0implement.java");  
            System.out.println("Register Menu:");
            System.out.println("");
            System.out.println("0 - Back to Login-Menu");
            System.out.println("1 - register as a Admin");
            System.out.println("2 - register as a Customer");

            System.out.println("");
            System.out.print("Enter your option: ");

            //try and catch here
            try {
                opt = scanner.nextInt();

                System.out.print("\033[H\033[2J");  
                System.out.flush();  

                //register an Admin account
                switch(opt){
                    //exit menu
                    case 0:
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        notDone = false; 
                    break; 
                    //register as Admin 
                    case 1:
                        Admin ad = new Admin();
                        System.out.println("you are registering for an Admin account");
                        System.out.println("");
                        //save input into variable including spaces 
                        scanner.nextLine(); 
                        System.out.print("Enter firstName: ");
                        firstName = scanner.next().toCharArray();
                        
                        ad.setFirstname(firstName);
                        //scanner.nextLine(); 

                        System.out.print("Enter lastName: ");
                        lastName = scanner.next().toCharArray();
                        ad.setLastname(lastName);

                        System.out.print("Enter Email: ");
                        lastName = scanner.next().toCharArray();
                        ad.setEmail(useremail);
                        
                        System.out.print("Enter userName: ");
                        userName = scanner.next().toCharArray();
                        ad.setUsername(userName);
                        scanner.nextLine();
                        
                        System.out.print("Enter password: ");
                        password = scanner.next().toCharArray();
                        ad.setPassword(password);
                        scanner.nextLine(); 

                        //add to Administrator 
                        uDao.insertAdmin(ad);

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        //display info
                        //System.out.println("you have succesfully register an Admin account");
                        //System.out.println("press a character and Enter to continue");

                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                    break;
                
                    //register as customer
                    case 2:
                        //Customer cu = new Customer();
                        System.out.println("you are registering for a Customer account");
                        System.out.println("");
                        //save input into variable including spaces 
                        scanner.nextLine(); 
                        System.out.print("Enter firstName: ");
                        firstName = scanner.next().toCharArray();
                        cu.setFirstname(firstName);
                        //scanner.nextLine(); 

                        System.out.print("Enter lastName: ");
                        lastName = scanner.next().toCharArray();
                        cu.setLastname(lastName);

                        System.out.print("Enter Email: ");
                        lastName = scanner.next().toCharArray();
                        cu.setEmail(useremail);
                        
                        System.out.print("Enter userName: ");
                        userName = scanner.next().toCharArray();
                        cu.setUsername(userName);
                        scanner.nextLine();
                        
                        System.out.print("Enter password: ");
                        password = scanner.next().toCharArray();
                        cu.setPassword(password);
                        scanner.nextLine(); 

                        //add to customerlist  
                
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        //display info
                        //System.out.println("you have succesfully register a customer account");
                        //System.out.println("press a character and Enter to continue");
                    
                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                    break;
                }                
            } 
            catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
            
                choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                    notDone = true; 
                } 
            }
        }
    }

    @Override
    public void Admin_login() {
        //validate admin credentials 
        optionMenu adMenu = new optionMenu(); 
        
        System.out.print("Enter username: ");
        userName = scanner.next().toCharArray();
        scanner.nextLine();

        //testuserN = ad.getUsername();

        System.out.print("Enter password: ");
        password= scanner.next().toCharArray();
        scanner.nextLine();

        //testpwd = ad.getPassword();

        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        
        //validate records 
        //get record from database
        //System.out.println("verifying record from Admin database");  
        //System.out.println("\n");  
		
        //validate records 
        //get record from database
        uDao.getAdminDetail();
        
        int adMenu_Value; 
        int opt = 0; 

        //code here
        //invoke admin option (option Menu.java) 
        boolean notdone = true; 
            while(notdone){
            adMenu_Value =  adMenu.adminMenu(opt);

                if (adMenu_Value == 0 ){
                    notdone = false; 
                }    
                //clearscreen
                System.out.print("\033[H\033[2J");  
		        System.out.flush();          
            }
    }

    @Override
    public void Customer_login() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'Customer_login'");
        optionMenu cu = new optionMenu();

        System.out.print("Enter username: ");
        userName = scanner.next().toCharArray();
        scanner.nextLine();

        //testuserN = ad.getUsername();

        System.out.print("Enter password: ");
        password= scanner.next().toCharArray();
        scanner.nextLine();

        //testpwd = ad.getPassword();

        System.out.print("\033[H\033[2J");  
		System.out.flush();  
        
        //System.out.println("verifying record from Customer database");  
        //System.out.println("\n");  

        //validate records 
        //get record from database
        

        int cuMenu_Value; 
        int opt = 0; 

        boolean notdone = true; 
            while(notdone){
                cuMenu_Value =  cu.customerMenu(opt);

                if (cuMenu_Value == 0 ){
                    notdone = false; 
                }    
                //clearscreen
                System.out.print("\033[H\033[2J");  
                System.out.flush();          
            }
    }
    
}
