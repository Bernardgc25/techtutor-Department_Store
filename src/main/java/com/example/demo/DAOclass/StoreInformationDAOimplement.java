package com.example.demo.DAOclass;

import com.example.demo.DAOinterface.StoreInformationDAO;
import com.example.demo.UserModel.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreInformationDAOimplement implements StoreInformationDAO{

    
    HashMap<Integer, Product> listOfproduct = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Product newproduct = new Product();
    char choice = '\0';
    Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
    ArrayList<Double> expenses = new ArrayList<Double>();

    //constructor
    public StoreInformationDAOimplement(){
        
    }

    @Override
    public void addProduct() {
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
    public void dispsallProduct() {
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

    @Override
    public void dispProductbyCategory() {
    	//Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
        
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    
        //display by category
        System.out.println("Display products by Category:"); 
    
        if(listOfproduct.isEmpty()){
            System.out.println("list is empty!! ");
        }
        else{
        
            for(Map.Entry<Integer, Product> p:pset){
            //System.out.println(":Key is "+p.getKey());
            Product pobj=p.getValue();
            System.out.println("Category: " +pobj.getCategory() + "Product Id:" +pobj.getProductName() + "Product Name: " 
            +pobj.getProductName() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
            }
        
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

    @Override
    public void dispsbyPrice() {
        //display by category
        System.out.println("Display by Category products:"); 
        for(Map.Entry<Integer, Product> p:pset){
            //System.out.println(":Key is "+p.getKey());
            Product pobj=p.getValue();
            System.out.println("Price: " +pobj.getSellingPrice() + "Product Id:" +pobj.getProductName() + "Product Name: " 
            +pobj.getProductName() + "Category: " +pobj.getCategory() +  "Quantity: " +pobj.getAvailableQuantity());
        }    
    
    
    
    }

    @Override
    public void searchbyProductId() {

        boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter productId to search: ");
            //productId = scanner.nextInt();
            
            
            try {
                Object prodId = scanner.nextInt();
                
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
                    
                } 
                else {
                    System.out.println("productId do not exist!!!");
                
                }

            } catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input, integer only");
            }
                //prompt user to search again
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

    @Override
    public void searchbyProductName() {

        Object pName; 
        boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter product Name to search: ");
            //productId = scanner.nextInt();
            pName = scanner.next();
            
            System.out.print("");
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
            }
        
            else {
                System.out.println("product Name do not exist!!!");
            } 
            
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

    @Override
    public void dispExpenses() {
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        //display total expenses 
        double sum = 0;
        for(int i = 0; i < expenses.size(); i++){
            sum += expenses.get(i);
        }
        
        System.out.println("Total Expenses: $" + sum);
    
        //return to option menu
        System.out.println("");
        System.out.print("(M) go back to menu: ");
        choice = scanner.next().charAt(0);

        System.out.println("");
        if(choice == 'm' || choice == 'M'){
            return; 
        }    
    }

    @Override
    public void dispProfit() {
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        //display total expenses 
        double sum = 0;
        for(int i = 0; i < expenses.size(); i++){
            sum += expenses.get(i);
        }
        
        System.out.println("Total Profit: $" + sum);
    
        //return to option menu
        System.out.println("");
        System.out.print("(M) go back to menu: ");
        choice = scanner.next().charAt(0);

        System.out.println("");
        if(choice == 'm' || choice == 'M'){
            return; 
        }    
    }

    @Override
    public void sortbyPrice() {

      

    //HashMap<Integer, Product> listOfproduct = new HashMap<>();
        
        if(listOfproduct.isEmpty()){
            System.out.print("list is empty!! ");        
        }
        else{
            listOfproduct.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue().getSellingPrice()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (left, right) -> left,
                        LinkedHashMap::new));

            System.out.println("list of products:"); 
            for(Map.Entry<Integer, Product> p:pset){
                //System.out.println(":Key is "+p.getKey());
                Product pobj=p.getValue();
                System.out.println("Product Name: " +pobj.getProductName() + "Product Id:" +pobj.getProductId() +"Quantity: " 
                +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice() + "Category: " +pobj.getCategory());
                }
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
