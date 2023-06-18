package com.example.demo.DAOinterface;

public interface StoreInformationDAO {
    
    //add new product by Admin
    public void addProduct();

    //delete product by Admin
    public void removeProduct();

    //display list of products 
    public void dispProduct();

    //display list of products 
    public void dispProductbyCategory();
    
    //search product by name
    public void searchbyProductId();

    //search product by name
    public void searchbyProductName();

    //display total expenses 
    public double dispExpenses();

    //display total profit 
    public double dispProfit();


}
