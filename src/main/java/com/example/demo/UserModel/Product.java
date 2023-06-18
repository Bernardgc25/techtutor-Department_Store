package com.example.demo.UserModel;

public class Product extends Item{

    protected int productId, availableQuantity; 
    protected String productName; 
    protected double sellingPrice;

    //constructors
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

    //setters and getters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }


}