package com.example.demo.UserModel;

public class Product extends Item{
    public Product(String ItemN, String Ctgy, Float buyingP) {
        super(ItemN, Ctgy, buyingP);
        //TODO Auto-generated constructor stub
    }
    protected int productId, avaliableQuantity; 
    protected String productName; 
    protected float sellingPrice = (float) (buyingPrice * 0.5) + buyingPrice;

    
}