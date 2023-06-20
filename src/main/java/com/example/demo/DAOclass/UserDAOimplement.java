package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.UserDAO;
import com.example.demo.OptionMenu.optionMenu;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserDAOimplement implements UserDAO{
    //user input 
    char[] firstName, lastName; 
    char[] userName, useremail, password;

    ///Admin 
    public List<Admin> Adminlist = new ArrayList<Admin>(1);
    public List<Customer> Customerlist = new ArrayList<Customer>();

    Scanner scanner = new Scanner(System.in);

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

                        //add to adminlist
                        Adminlist.add(ad);

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        //display info
                        System.out.println("you have succesfully register an Admin account");
                        System.out.println("press a character and Enter to continue");

                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                        //save account to database   
                        //code here   
                    break;
                
                    //register as customer
                    case 2:
                        Customer cu = new Customer();
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

                        //add to adminlist
                        Customerlist.add(cu);

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        //display info
                        System.out.println("you have succesfully register a customer account");
                        System.out.println("press a character and Enter to continue");
                    
                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                        //save account to database
                        //code here
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
        System.out.println("verifying record from Admin database");  
        System.out.println("\n");  
		
        /* 
        for (int i=0; i<Adminlist.size(); i++) {
            System.out.println("firstName:" + ad.getFirstname());
            System.out.println("secondName:" + ad.getLastname());
 
            System.out.print("email: ");
            System.out.println(ad.getEmail());

            System.out.print("userName: ");
            System.out.println(ad.getUsername());

            System.out.print("password: ");
            System.out.println(ad.getPassword());
        }
        
        */

        /* 
        if(Adminlist.get(i).getUsername().equals(userName) && Adminlist.get(i).getPassword().equals(password)){
            System.out.println("successfully logged-in..");
        }
        else{
            System.out.println("No records, Invalid try again");     
        }
            
        */
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
        
        //validate records 

        //get record from database
        System.out.println("verifying record from Customer database");  
        System.out.println("\n");  



        //code here
        //invoke customer option (option Menu.java) 
        //create separate threads for user 



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
