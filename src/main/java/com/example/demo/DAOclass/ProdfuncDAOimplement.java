package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.ProdfuncDAO;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;
import com.example.demo.UserModel.Item;
import com.example.demo.UserModel.Product;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.RowFilter.Entry;



public class ProdfuncDAOimplement implements ProdfuncDAO{

    HashMap<String, Product> listOfproduct = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    Product newproduct = new Product();

    int productId, availableQuantity; 
    String productName, prodCategory; 
    float sellingPrice;
    char choice = '\0';

    @Override
    public void addProduct() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
        System.out.print("\033[H\033[2J");  
		System.out.flush();    
            
        //prompt product information
        System.out.print("Enter Product Id: ");
        productId = scanner.nextInt();
        newproduct.setProductId(productId);

        System.out.print("Enter Product Name: ");
        productName = scanner.nextLine();
        newproduct.setProductName(productName);

        System.out.print("Enter Category: ");
        prodCategory = scanner.nextLine();
        newproduct.setCategory(prodCategory);

        System.out.print("Enter Quantity: ");
        productId = scanner.nextInt();
        newproduct.setAvailableQuantity(availableQuantity);

        System.out.print("Enter Price: ");
        sellingPrice = scanner.nextFloat();
        newproduct.setBuyingPrice(sellingPrice);
        
        //add product to hashmap
        //listOfproduct.put(productId, productName);
        listOfproduct.put(newproduct.getProductName(), newproduct);
    }

    @Override
    public void updateProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void removeProduct() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'removeProduct'");

        boolean remove_prod = true; 

        while(remove_prod){
            if(!listOfproduct.isEmpty()){
                //display products           
                System.out.println("list of products:"); 
                listOfproduct.entrySet().forEach( entry -> {
                System.out.println( entry.getKey() + " => " + entry.getValue() );
                });

                System.out.println("");
                System.out.println("");
                
                //remove item by key and product name
                System.out.print("Enter a product to remove: ");
                System.out.print("Enter Product Id: ");
                productId = scanner.nextInt();
                newproduct.setProductId(productId);

                System.out.print("Enter Product Name: ");
                productName = scanner.nextLine();
                newproduct.setProductName(productName);
                
                listOfproduct.remove(productId, productName);

                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();   

                //display products           
                System.out.println("list of products:"); 
                listOfproduct.entrySet().forEach( entry -> {
                System.out.println( entry.getKey() + " => " + entry.getValue() );
                });

                System.out.println("");
                System.out.println("delete more task?");
                System.out.println("(Y) Yes");
                System.out.println("(N) No");
                System.out.println("");
                System.out.print("Enter a choice: ");
                    
                choice = scanner.next().charAt(0);

                    //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    if(choice == 'n' || choice == 'N'){
                        remove_prod = false;
                    }
                    else if(choice == 'y' || choice == 'Y'){
                        remove_prod = true; 
                    }            
            }
            //return to option menu
            else{
                //product list is empty 
                System.out.println("list is empty!! ");
                System.out.println("(M) go back to menu: ");
                System.out.println("");
                System.out.print("Enter a choice: ");
                    choice = scanner.next().charAt(0);
                        if(choice == 'm' || choice == 'M'){
                            remove_prod = false;
                        }
            }
        }
    }

    @Override
    public void dispProduct() {
        // TODO Auto-generated method stub
        //hrow new UnsupportedOperationException("Unimplemented method 'dispProduct'");
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(listOfproduct.isEmpty()){
            System.out.print("list is empty!! ");
                
        }
        else{
            System.out.println("list of products:"); 
            listOfproduct.entrySet().forEach( entry -> {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
            });
        
        //return to option menu
        System.out.println("");
        System.out.print("(M) go back to menu: ");
        choice = scanner.next().charAt(0);

        System.out.println("");
        if(choice == 'm' || choice == 'M'){
            return; 
        }    

    }    
}

    @Override
    public void dispProductbyCategory() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'dispProductbyCategory'");
    }

    @Override
    public void searchbyProductId() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");

        boolean searchnotDone = true;
        
        while(searchnotDone){
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter productId to search: ");
            productId = scanner.nextInt();
            
            if (listOfproduct.containsValue(productId)){
                System.out.println("productId exist...");
                System.out.println("");

                //display tasks
                System.out.println("list of products:"); 
                listOfproduct.entrySet().forEach( entry -> {
                System.out.println( entry.getKey() + " => " + entry.getValue() );
                });
                
                System.out.println("");
                System.out.println("(S) seach for productId");
                System.out.println("(M) go back to menu: ");
                System.out.println("");
                System.out.print("Enter a choice: ");
                choice = scanner.next().charAt(0);
                if(choice == 'm' || choice == 'M'){
                    searchnotDone = false; 
                }
                else if (choice == 's' || choice == 'S'){
                    searchnotDone = true;
                }
            } 
            else {
                System.out.println("taskid do not exist!!!");
                System.out.println("");
                System.out.println("(S) seach for taskid");
                System.out.println("(M) go back to menu: ");
                System.out.println("");
                System.out.print("Enter a choice: ");
                choice = scanner.next().charAt(0);
                if(choice == 'm' || choice == 'M'){
                    searchnotDone = false; 
                }
                else if (choice == 's' || choice == 'S'){
                    searchnotDone = true;
                }
            }
        }     
    }

    @Override
    public void dispExpenses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispExpenses'");
    }

    @Override
    public void dispProfit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispProfit'");
    }

    @Override
    public void searchbyProductCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchbyProductCategory'");
    }
    
}
