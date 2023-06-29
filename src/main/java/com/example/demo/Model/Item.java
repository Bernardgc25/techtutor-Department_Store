package com.example.demo.Model;

public class Item{
    protected String Itemname, Category; 
    protected double buyingPrice; 

    //constructors
    public Item(){

    }
    
    public Item(String Itemname, String Category, double buyingPrice){
        this.Itemname = Itemname; 
        this.Category = Category; 
        this.buyingPrice = buyingPrice; 
    }

    //setters and getters
    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }


}
