package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.ProdfuncDAO;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;
import com.example.demo.UserModel.Item;
import com.example.demo.UserModel.Product;

import java.util.HashMap;
import java.util.Scanner;



public class ProdfuncDAOimplement implements ProdfuncDAO{

    HashMap<Integer, String> new_product = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    Product p = new Product();

    int productId, availableQuantity; 
    String productName, prodCategory; 
    float sellingPrice;


    @Override
    public void addProduct() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
        System.out.print("\033[H\033[2J");  
		System.out.flush();    
            
        //prompt product information
        System.out.print("Enter Product Id: ");
        productId = scanner.nextInt();
        p.setProductId(productId);

        System.out.print("Enter Product Name: ");
        productName = scanner.nextLine();
        p.setProductName(productName);

        System.out.print("Enter Category: ");
        prodCategory = scanner.nextLine();
        p.setCategory(prodCategory);

        System.out.print("Enter Quantity: ");
        productId = scanner.nextInt();
        p.setAvailableQuantity(availableQuantity);

        System.out.print("Enter Price: ");
        sellingPrice = scanner.nextFloat();
        p.setBuyingPrice(sellingPrice);
        
        //add product to hashmap
        new_product.put(productId, productName);
        
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
