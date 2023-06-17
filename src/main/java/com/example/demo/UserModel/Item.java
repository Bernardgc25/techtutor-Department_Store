package com.example.demo.UserModel;

public class Item{
    protected String Itemname, Category; 
    protected float buyingPrice; 

    public Item(String ItemN, String Ctgy, Float buyingP){
        this.Itemname = ItemN; 
        this.Category = Ctgy; 
        this.buyingPrice = buyingP; 
    }

}
