package com.example.demo.Model;

public class Product extends Item{

    protected int productId, availQty; 
    protected String productName; 
    protected double sellingPrice;

    //constructors
    public Product(){
        
    }

    public Product(int productId, String productName, String Category, int availQty, double buyingPrice) {
        //super(ItemN, Ctgy, buyingP);
        
        this.productId = productId; 
        this.productName = productName;
        this.availQty = availQty; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    /////////////////test//////////////////
    //retrieve product from database
    public Product(int productId, String productName, int availQty, double buyingPrice) {
        //super(ItemN, Ctgy, buyingP);
        
        this.productId = productId; 
        this.productName = productName;
        this.availQty = availQty; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }


    //retrieve product from database
    public Product(int prodId) {
        //super(ItemN, Ctgy, buyingP);
      
        this.productId = prodId; 
  
    }

    public Product(int prodId, String ItemN) {
        this.productId = prodId; 
        this.productName = ItemN;
    }


    public Product(int prodId, String ItemN, int pQty) {
        this.productId = prodId; 
        this.productName = ItemN;
        this.availQty = pQty; 
    }


    /////////////////////////////test///////////////////////

    //setters and getters
    public int getProductId() {
        return productId;
    }

    

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAvailableQuantity() {
        return availQty;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availQty = availableQuantity;
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