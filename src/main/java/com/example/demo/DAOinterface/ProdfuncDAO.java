package com.example.demo.DAOinterface;

public interface ProdfuncDAO {
    
    //add new product by Admin
    public void addProduct();

    //update product by Admin 
    public void updateProduct();

    //delete product by Admin
    public void removeProduct();

    //display list of products 
    public void dispProduct();

    //display list of products 
    public void dispProductbyCategory();
    
    //search product by name
    public void searchProduct();

    //display total expenses 
    public void dispExpenses();

    //display total profit 
    public void dispProfit();
}
