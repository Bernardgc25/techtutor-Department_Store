package com.example.demo.UserModel;

public class Item{
    protected String Itemname, Category; 
    protected double buyingPrice; 

    public Item(){

    }
    
    public Item(String ItemN, String Ctgy, double buyingP){
        this.Itemname = ItemN; 
        this.Category = Ctgy; 
        this.buyingPrice = buyingP; 
    }

}
