package com.example.demo.DAO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Admin;

public class AdminDAO {
    private Scanner scanner; 
    public ArrayList<Admin> Administrator;
    
    public AdminDAO(){
        scanner = new Scanner(System.in);
        Administrator = new ArrayList<Admin>();
    }

    //administrator functions
    public void insertAdmin(Admin ad){
        Administrator.add(ad);
        //display info
        System.out.println("you have succesfully register an Admin account");
        System.out.println("press a character and Enter to continue");
        
    }

    public List<Admin> getAdminDetail(){
        System.out.println("verifying record from Admin database");  
        System.out.println("\n");  
        return Administrator; 
    }


}
