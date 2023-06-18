package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.ProdfuncDAO;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;
import com.example.demo.UserModel.Item;
import com.example.demo.UserModel.Product;

import java.util.HashMap;
import java.util.Scanner;



public class ProdfuncDAOimplement implements ProdfuncDAO{

    HashMap<Integer, String> productInfo = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

   

    int productId, availableQuantity; 
    String productName, prodCategory; 
    float sellingPrice;


    @Override
    public void addProduct() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
        System.out.print("\033[H\033[2J");  
		System.out.flush();    
            
        //add new product
        System.out.print("Enter Product Id: ");
        productId = scanner.nextInt();

        System.out.print("Enter Product Name: ");
        productName = scanner.nextLine();
        
        System.out.print("Enter Category: ");
        prodCategory = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        productId = scanner.nextInt();
        
        System.out.print("Enter Price: ");
        sellingPrice = scanner.nextFloat();
        
        Product nprod = new Product();
    }

    @Override
    public void updateProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void removeProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProduct'");
    }

    @Override
    public void dispProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispProduct'");
    }

    @Override
    public void dispProductbyCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispProductbyCategory'");
    }

    @Override
    public void searchProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");
    }

    @Override
    public void dispExpenses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispExpenses'");
    }

    @Override
    public void dispProfit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispProfit'");
    }
    
}
