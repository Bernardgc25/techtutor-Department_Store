package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.UserDAO;
import com.example.demo.OptionMenu.optionMenu;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOimplement implements UserDAO{
    //user input 
    String firstName, lastName; 
    char[] userName, useremail, password;

    ///Admin 
    public List<Admin> Adminlist = new ArrayList<Admin>(1);
    public List<Customer> Customerlist = new ArrayList<Customer>();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void register(int opt) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'register'");
        System.out.println("1 - register as a Admin");
        System.out.println("2 - register as a Customer");

        System.out.println("");
        System.out.print("Enter your option: ");
        //System.out.print("Are you a client(c) or visitor(v) ? ");
        opt = scanner.nextInt();

        System.out.print("\033[H\033[2J");  
		System.out.flush();  

        //register an Admin account
        if (opt == 1) {
            Admin ad = new Admin();

            //save input into variable including spaces 
            scanner.nextLine(); 
            System.out.print("Enter firstName: ");
            firstName = scanner.nextLine();
            ad.setFirstname(firstName);
            //scanner.nextLine(); 

            System.out.print("Enter lastName: ");
            lastName = scanner.nextLine();
            ad.setLastname(lastName);

            System.out.print("Enter Email: ");
            lastName = scanner.nextLine();
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
            System.out.println("\n");
        }
        //register a customer  account
        else if(opt == 2){
            Customer cu = new Customer();

            //save input into variable including spaces 
            scanner.nextLine(); 
            System.out.print("Enter firstName: ");
            firstName = scanner.nextLine();
            cu.setFirstname(firstName);
            //scanner.nextLine(); 

            System.out.print("Enter lastName: ");
            lastName = scanner.nextLine();
            cu.setLastname(lastName);

            System.out.print("Enter Email: ");
            lastName = scanner.nextLine();
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
            System.out.println("\n");
        }
    


    }

    @Override
    public void Admin_login() {
        //TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'Admin_login'");
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
        Customer cu = new Customer();

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
		
    }
    
}
