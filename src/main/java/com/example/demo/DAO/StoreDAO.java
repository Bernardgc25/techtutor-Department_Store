package com.example.demo.DAO;

import java.sql.*;
import com.example.demo.Util.DataConnect;
import com.example.demo.Model.Product;

//this class will access database Store
public class StoreDAO {
    Connection con; 

    public StoreDAO(){
        con = DataConnect.getconnect(); 
       
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
                                rs.getInt("availQty"),rs.getDouble("sellingPrice")); 
            
                //return new Product(rs.getInt("productId"));           
           
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
                                rs.getInt("availQty"),rs.getDouble("sellingPrice"));     
           
            }
        

                
                
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null;
         
        }



}
