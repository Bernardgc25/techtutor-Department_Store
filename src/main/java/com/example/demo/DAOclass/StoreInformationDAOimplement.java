package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.StoreInformationDAO;
import com.example.demo.UserModel.Admin;
import com.example.demo.UserModel.Customer;
import com.example.demo.UserModel.Item;
import com.example.demo.UserModel.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.RowFilter.Entry;



public class StoreInformationDAOimplement implements StoreInformationDAO{

    HashMap<Integer, Product> listOfproduct = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Product newproduct = new Product();
    char choice = '\0';
    Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
    ArrayList<Double> expenses = new ArrayList<Double>();

    @Override
    public void addProduct() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    

        System.out.print("\033[H\033[2J");  
		System.out.flush();    
            
        //prompt product information
        System.out.print("Enter Product Id: ");
        newproduct.setProductId(scanner.nextInt());

        System.out.print("Enter Product Name: ");
        newproduct.setProductName(scanner.nextLine());

        System.out.print("Enter Category: ");
        newproduct.setCategory(scanner.nextLine());

        System.out.print("Enter Quantity: ");
        newproduct.setAvailableQuantity(scanner.nextInt());

        System.out.print("Enter Price: ");
        double buyingP = scanner.nextDouble();
        newproduct.setBuyingPrice(buyingP);
        
        //add buying price to expenses
        expenses.add(buyingP);

        //add product to hashmap
        //listOfproduct.put(newproduct.getProductName(), newproduct);
        listOfproduct.put(newproduct.getProductId(), newproduct);
    }

    @Override
    public void removeProduct() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'removeProduct'");

        boolean remove_prod = true; 
        //Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
        
        while(remove_prod){
            if(!listOfproduct.isEmpty()){

                //display products           
                System.out.println("list of products:"); 
                for(Map.Entry<Integer, Product> p:pset)
                {
                    //System.out.println(":Key is "+p.getKey());
                    Product pobj=p.getValue();
                    System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                        + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                }
                    
                System.out.println("");
                System.out.println("");
                
                //remove item by productID
                System.out.print("Enter Product Id to remove: ");
                int pdelete = scanner.nextInt();
	            Product premoobj = listOfproduct.get(pdelete);

                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();   

                System.out.println("list of products:"); 
                for(Map.Entry<Integer, Product> p:pset)
                {
                    //System.out.println(":Key is "+p.getKey());
                    Product pobj=p.getValue();
                    System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                        + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                }
                
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
        //throw new UnsupportedOperationException("Unimplemented method 'dispProduct'");
        //Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
    
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(listOfproduct.isEmpty()){
            System.out.print("list is empty!! ");
                
        }
        else{
            //display
            System.out.println("list of products:"); 
            for(Map.Entry<Integer, Product> p:pset)
                {
                //System.out.println(":Key is "+p.getKey());
                Product pobj=p.getValue();
                System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                }
        
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
    	//Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
        
        //display
        System.out.println("Display by Category products:"); 
        for(Map.Entry<Integer, Product> p:pset){
            //System.out.println(":Key is "+p.getKey());
            Product pobj=p.getValue();
            System.out.println("Category: " +pobj.getCategory() + "Product Id:" +pobj.getProductName() + "Product Name: " 
            +pobj.getProductName() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
        }
        
    }

    @Override
    public void searchbyProductId() {
        //TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");

        Object prodId; 
        boolean searchnotDone = true;
        
        while(searchnotDone){
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter productId to search: ");
            //productId = scanner.nextInt();
            prodId = scanner.nextInt();
            
            //search by productId
            //newproduct = listOfproduct.get(productId);

            if (listOfproduct.containsValue(prodId)){
                System.out.println("productId exist...");
                System.out.println("");

                //display 
                System.out.println("list of products:"); 
                for(Map.Entry<Integer, Product> p:pset)
                {
                //System.out.println(":Key is "+p.getKey());
                Product pobj=p.getValue();
                System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                }
                
                System.out.println("");
                System.out.println("(S) search for productId");
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
                System.out.println("productId do not exist!!!");
                System.out.println("");
                System.out.println("(S) search for productId");
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
    public void searchbyProductName() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'searchbyProductCategory'");

        Object pName; 
        boolean searchnotDone = true;
        
        while(searchnotDone){
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter product Name to search: ");
            //productId = scanner.nextInt();
            pName = scanner.nextLine();
            
            //search by productName
            if (listOfproduct.containsValue(pName)){
                System.out.println("product Name exist...");
                System.out.println("");

                //display 
                System.out.println("list of products:"); 
                for(Map.Entry<Integer, Product> p:pset){
                //System.out.println(":Key is "+p.getKey());
                Product pobj=p.getValue();
                System.out.println("Product Name: " +pobj.getProductName() + "Product Id:" +pobj.getProductId() +"Quantity: " 
                +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice() + "Category: " +pobj.getCategory());
                }

                System.out.println("");
                System.out.println("(S) search for a product Name");
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
                System.out.println("product Name do not exist!!!");
                System.out.println("");
                System.out.println("(S) search for product Name");
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
    public double dispExpenses() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'dispExpenses'");
       
        //display total expenses 
        double sum = 0;
        for(int i = 0; i < expenses.size(); i++)
        sum += expenses.get(i);
        
        return sum;
    
    }

    @Override
    public double dispProfit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispProfit'");
    }

}
