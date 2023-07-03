package com.example.demo.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

import com.example.demo.Util.DataConnect;
import com.example.demo.Model.Item;
import com.example.demo.Model.Product;

import java.util.Scanner;

//this class will access database Store
public class StoreDAO {
    Connection con; 

    public StoreDAO(){
        con = DataConnect.getconnect(); 
       
    }

    Scanner scanner = new Scanner(System.in);

    //display all products, hashamp return method 
    public HashMap<Integer, Product>displayallProducts(){
        HashMap<Integer, Product> map_product = new HashMap<>();
        Product p; 

        try {
            String sql = "SELECT * from Product";
            PreparedStatement ps = con.prepareStatement(sql);
                 
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){

                int productId = rs.getInt("productId"); 
                String productName = rs.getString("productName"); 
                int availQty = rs.getInt("availQty");  
                double buyingPrice = rs.getDouble("buyingPrice");
            
                //double sellingPrice = rs.getDouble("sellingPrice");
            
                p = new Product(productId, productName, availQty, buyingPrice);
                
                //place data in hashmap
                //key value productId
                map_product.put(productId, p);
                   
            }
            return map_product;
                        
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null;
         
    }

    //display item by category, hashamp return method 
    public HashMap<String, Item>displaybyCategory(String category){
        HashMap<String, Item> map_item = new HashMap<>();
        Item i; 
    
        try {
            String sql = "select * from  Item where Category = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            
            //database query 
            ps.setString(1, category);
  
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
                String ItemName = rs.getString("ItemName"); 
                String Category = rs.getString("Category");
                double buyingPrice = rs.getDouble("buyingPrice");; 

                i = new Item(ItemName, Category, buyingPrice);
                //key value itemName
                map_item.put(ItemName, i);
          
            }
            return map_item;
                        
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null;
         
    }




    //retrieve product by productID
    public Product searchProdId(int productId){
        
    
        try {
            String sql = "SELECT * from Product where productID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                
            ps.setInt(1, productId);
  
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
                return new Product(rs.getInt("productId"), rs.getString("productName"), 
                                rs.getInt("availQty"),rs.getDouble("buyingPrice"));          
            }               
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }       
            return null;     
    }

    //retrieve product by productName
    public Product searchProductName(String productName){
        
    
        try {
            String sql = "SELECT * from Product where productName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                
            ps.setString(1, productName);
  
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
                return new Product(rs.getInt("productId"), rs.getString("productName"), 
                                rs.getInt("availQty"),rs.getDouble("buyingPrice"));     
            }
   
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null; 
    }


    //retrieve expenses, sum of buying price 
    public double totalExpenses(){
        double bPrice = 0.0;
        //int qty = 0; 

        try {
            String sql = "SELECT SUM(buyingPrice) from Product"; 
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery(); 

            //get the sum of column name = buyingPrice, 
            rs.next();
                bPrice = rs.getDouble(1);
                
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
      
        return bPrice;
            
    }

        //retrieve expenses, sum of buying price 
    public double profitbyCategory(){
        double bPrice = 0.0;
    

        try {
            String sql = "SELECT Category, SUM(buyingPrice) FROM Item GROUP BY Category"; 
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery(); 

            //get the sum of column name = buyingPrice, 
            rs.next();
                bPrice = rs.getDouble(1);
                
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
      
        return bPrice;
            
    }
   



}
