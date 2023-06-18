package com.example.demo.UserModel;

public class Product extends Item{

    protected int productId, availableQuantity; 
    protected String productName; 
    protected double sellingPrice;

    public Product(){
        
    }

    public Product(int prodId, String ItemN, String Ctgy, int pQty, double buyingP) {
        //super(ItemN, Ctgy, buyingP);
        
        this.productId = prodId; 
        this.productName = ItemN;
        this.availableQuantity = pQty; 
        this.sellingPrice = (buyingP * 0.5) + buyingP;
        
        
        //TODO Auto-generated constructor stub
    }

}