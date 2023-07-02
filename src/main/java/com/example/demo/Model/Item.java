package com.example.demo.Model;

public class Item{
    protected String ItemName, Category; 
    protected double buyingPrice; 

    //constructors
    public Item(){

    }
    
    public Item(String ItemName, String Category, double buyingPrice){
        this.ItemName = ItemName; 
        this.Category = Category; 
        this.buyingPrice = buyingPrice; 
    }

    //setters and getters
    public String getItemname() {
        return ItemName;
    }

    public void setItemname(String ItemName) {
        this.ItemName = ItemName;
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
