package com.example.demo.DAOinterface;

import java.util.Map;

import com.example.demo.UserModel.Product;

public interface StoreInformationDAO {

    
    //add new product by Admin
    public void addProduct();

    //delete product by Admin
    public void removeProduct();

    //display list of products 
    public void dispsallProduct();

    //display list of products 
    public void dispProductbyCategory();

    //display by price
    public void dispsbyPrice();
    
    //search product by name
    public void searchbyProductId();

    //search product by name
    public void searchbyProductName();

    //display total expenses 
    public void dispExpenses();

    //display total profit 
    public void dispProfit();

    public void sortbyPrice();

    public void HashmapToList(); 


}
