package com.example.demo.DAO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Admin;

public class AdminDAO {
    private Scanner scanner; 
    private List<Admin> Admindao;
    
    public AdminDAO(){
        scanner = new Scanner(System.in);
        Admindao = new ArrayList<Admin>();
    }

    //administrator functions
    public void insertAdmin(Admin ad){
        Admindao.add(ad);
        
    }

    public void validate(char[] userName, char[]password){
        boolean loggedIn = false;
        for(Admin a : Admindao) {
            if (a.getUsername().equals(userName) && a.getPassword().equals(password)) {
                loggedIn = true;
                System.out.println("login succesful");
            }
            else{
                System.out.println("invalid credentials !!!");    
            }
            
        }
            char choice = '\0';
            System.out.println("press a character and Enter to continue");
            choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                System.out.println("Back to Option Menu");
            } 
   
    }

    

    public List<Admin> getAdminDetail(){
        System.out.println("verifying record from Admin database");  
        System.out.println("\n");  
        return Admindao; 
    }


}
