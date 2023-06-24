package com.example.demo.DAO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Customer;

public class UserDAO {
  
    public List<Admin> Adminstrator = new ArrayList<Admin>(1);
    public List<Admin> CustomerList = new ArrayList<Admin>(1);

    public UserDAO(){

    }

    public void insertAdmin(Admin ad){
        Adminstrator.add(ad);

    }

    public List<Admin> getAdminDetail(){
        return Adminstrator; 
    }

    

}
