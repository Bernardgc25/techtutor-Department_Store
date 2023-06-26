package com.example.demo.DAO;

import java.io.CharArrayReader;
import java.sql.*;
import com.example.demo.Util.DataConnect;
import com.example.demo.Model.Admin;

//this class will access database Store
public class AdminDAO {
    Connection con; 


    public AdminDAO(){
        con = DataConnect.getconnect(); 
    }

    public void insert(Admin ad){
        try{
            String sql = "INSERT into Admin(fname,lname,uname,uemail,pwd) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setCharacterStream(1, new CharArrayReader(ad.getFirstname()));
            ps.setCharacterStream(2, new CharArrayReader(ad.getLastname()));
            ps.setCharacterStream(3, new CharArrayReader(ad.getEmail()));
            ps.setCharacterStream(4, new CharArrayReader(ad.getUsername()));
            ps.setCharacterStream(5, new CharArrayReader(ad.getPassword()));
            
            ps.executeUpdate();
            
            int result = ps.executeUpdate();
            if(result>0){
				System.out.println("Insert successfully");
			}
			else{
				System.out.println("not inserted");
			}
            
        }
        catch(SQLException ex){
                System.out.println(ex.getMessage());
        }       
    }
    
}
