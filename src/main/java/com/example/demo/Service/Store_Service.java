package com.example.demo.Service;

import java.lang.*;
import java.util.Formatter; 
import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.StoreDAO;
import com.example.demo.Model.Product;
import com.example.demo.Service_Interface.Store_Service_Interface;

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

public class Store_Service implements Store_Service_Interface{

    
    HashMap<Integer, Product> listOfproduct = new HashMap<>();
    Scanner scanner;
    Product newproduct = new Product();
    char choice = '\0';
    //Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
    ArrayList<Double> expenses = new ArrayList<Double>();

        StoreDAO sdao;
        
    //constructor
    public Store_Service(){
        scanner = new Scanner(System.in);
        sdao = new StoreDAO();
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
                
                /*
                for(Map.Entry<Integer, Product> p:pset)
                {
                    //System.out.println(":Key is "+p.getKey());
                    Product pobj=p.getValue();
                    //System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                    //    + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                    
                    System.out.println("Product Id:" + pobj.getProductName());
                    System.out.println("Product Name: " +pobj.getProductName()); 
                    System.out.println("Category: " +pobj.getCategory());
                    System.out.println("Quantity: " +pobj.getAvailableQuantity());
                    System.out.println("Price: " +pobj.getSellingPrice());
                }
                */
                    
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
                /* 
                for(Map.Entry<Integer, Product> p:pset)
                {
                    //System.out.println(":Key is "+p.getKey());
                    Product pobj=p.getValue();
                    System.out.println("Product Id:" +pobj.getProductName() + "Product Name: " +pobj.getProductName() 
                        + "Category: " +pobj.getCategory() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
                }
                */
                
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

            Map<Integer, Product> map_product = new HashMap<Integer, Product>();
          
            //invoke serviceDAO
            map_product = sdao.displayallProducts();
        
            if(map_product.isEmpty()){
                System.out.println("list is empty!! ");
            }
            else{
                      //display
                System.out.println("list of products:"); 

                //display all products, 
                ////////////////////////////
                Formatter fmt = new Formatter();  
                fmt.format("%15s %15s %15s %15s\n", "productID", "productName", "Qty", "sellingPrice");  
        
                //iterate over by value hashmap 
                Set<Map.Entry<Integer, Product>> pset = map_product.entrySet();
            
                for(Map.Entry<Integer, Product> p: pset){
                    
                    System.out.print(+p.getKey());
                    Product pobj = p.getValue();

                    System.out.println(" " + pobj.getItemname() + " " 
                                + pobj.getAvailableQuantity() + " " + pobj.getSellingPrice());       
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
    public void displaybyCategory() {
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
        




            /* 
             for(Map.Entry<Integer, Product> p:pset){
            //System.out.println(":Key is "+p.getKey());
            Product pobj=p.getValue();
            System.out.println("Category: " +pobj.getCategory() + "Product Id:" +pobj.getProductName() + "Product Name: " 
            +pobj.getProductName() + "Quantity: " +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice());
            } 
            */
            
        
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
        /* 
        for(Map.Entry<Integer, Product> p:pset){
            //System.out.println(":Key is "+p.getKey());
            Product pobj=p.getValue();
            System.out.println("Price: " +pobj.getSellingPrice() + "Product Id:" +pobj.getProductName() + "Product Name: " 
            +pobj.getProductName() + "Category: " +pobj.getCategory() +  "Quantity: " +pobj.getAvailableQuantity());
        }    
        */
    
    
    }

    @Override
    public void searchbyProductId() {

        boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter productId to search: ");
     
            
            
            try {
                //Object prodId = scanner.nextInt();
                int prodId = scanner.nextInt();

                //search product id database
                Product sp = sdao.searchProdId(prodId);

                //product Id does not exist in database
                if (sp == null){
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    
                    System.out.println("Product Id does not exist");    

                    //ask user again
                    System.out.println("press a character and Enter to continue");
                    choice = scanner.next().charAt(0);

                    //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                        // if((choice == 'c') || (choice == 'C')){
                        //System.out.println("Back to Option Menu");
                   // }
            
                }
                //product Id found
                //display info
                else {
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    //System.out.println("Product Id located");   
                 
                    //System.out.println("Product Id: " +sp.getProductId() + " Product Name: " +sp.getProductName() 
                    //+ " Qty: " +sp.getAvailableQuantity() + " Price: " +sp.getSellingPrice());
                    System.out.println("Product Id:" + sp.getProductId());
                    System.out.println("Product Name: " +sp.getProductName()); 
                    System.out.println("Quantity: " +sp.getAvailableQuantity());
                    System.out.println("Price: " +sp.getSellingPrice());
               
                    System.out.println("");
                }        
                /*
                 * 
                */       

            } catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input, integer only");
            }
               
                //only accepts s or m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.println("(S) search for product Id");
                    System.out.println("(M) go back to menu: ");
                    System.out.println("");
                    System.out.print("Enter a choice: ");

                    choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                    Character s = 's';
                    Character S = 'S';
                
                    if (m.equals(choice) || M.equals(choice)){
                        searchnotDone = false; 
                        wrongcharacter = false; 
                    }
                    else if (s.equals(choice) || S.equals(choice)) {
                        searchnotDone = true;
                        wrongcharacter = false; 
                    }
                    else{
                         //clear screen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        
                        System.out.println("Invalid Character !");
                        wrongcharacter = true; 
                    }
                }                    
            ///////
        }     
    }

    @Override
    public void searchbyProductName() {

        boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter product Name to search: ");
     
            
            try {
                //Object prodId = scanner.nextInt();
                String productName = scanner.next();

                //search product id database
                Product sp = sdao.searchProductName(productName);

                //product Id does not exist in database
                if (sp == null){
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    
                    System.out.println("Product Name does not exist");    

                    //ask user again
                    System.out.println("press a character and Enter to continue");
                    choice = scanner.next().charAt(0);

                    //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
            
                }
                //product Id found
                //display info
                else {
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    //System.out.println("Product Name located");  
                     
                 
                    //System.out.println("Product Id: " +sp.getProductId() + " Product Name: " +sp.getProductName() 
                    //+ " Qty: " +sp.getAvailableQuantity() + " Price: " +sp.getSellingPrice());
                    
                    System.out.println("Product Id:" + sp.getProductId());
                    System.out.println("Product Name: " +sp.getProductName()); 
                    System.out.println("Quantity: " +sp.getAvailableQuantity());
                    System.out.println("Price: " +sp.getSellingPrice());


                    //System.out.println("");
                    System.out.println("");
                    
                    //System.out.print("Product Id        Product Name        Qty         Price");
                    //String strId = String.format("%0d", sp.getProductId());
                    //System.out.println(strId);
                }        
                /*
                 * 
                */       

            } catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
            }

                //only accepts s or m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.println("(S) search for product Name");
                    System.out.println("(M) go back to menu: ");
                    System.out.println("");
                    System.out.print("Enter a choice: ");

                    choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                    Character s = 's';
                    Character S = 'S';
                
                    if (m.equals(choice) || M.equals(choice)){
                        searchnotDone = false; 
                        wrongcharacter = false; 
                    }
                    else if (s.equals(choice) || S.equals(choice)) {
                        searchnotDone = true;
                        wrongcharacter = false; 
                    }
                    else{
                         //clear screen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        
                        System.out.println("Invalid Character !");
                        wrongcharacter = true; 
                    }
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
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    
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

            /*     
            System.out.println("list of products:"); 
            for(Map.Entry<Integer, Product> p:pset){
                //System.out.println(":Key is "+p.getKey());
                Product pobj=p.getValue();
                System.out.println("Product Name: " +pobj.getProductName() + "Product Id:" +pobj.getProductId() +"Quantity: " 
                +pobj.getAvailableQuantity() + "Price: " +pobj.getSellingPrice() + "Category: " +pobj.getCategory());
                }
            */    
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
