package com.example.demo.Service;

import java.lang.*;
import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.StoreDAO;
import com.example.demo.Model.Item;
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
    //char choice = '\0';
    //Set<Map.Entry<Integer, Product>> pset = listOfproduct.entrySet();
    //ArrayList<Double> expenses = new ArrayList<Double>();

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
        //expenses.add(buyingP);

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
                    
                char choice = scanner.next().charAt(0);

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
                    char  choice = scanner.next().charAt(0);
                        if(choice == 'm' || choice == 'M'){
                            remove_prod = false;
                        }
            }
        }
    }

    @Override
    public void dispsallProduct() {
        Map<Integer, Product> map_product = new HashMap<Integer, Product>();
       
        //invoke serviceDAO
        map_product = sdao.displayallProducts();
        
        boolean notDone = true;
        //////
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   

        
        while(notDone){
            
            if(map_product.isEmpty()){
                System.out.println("list is empty!! ");
            }
            else{
                //display all products in table format
                //System.out.println("list of products:"); 

                System.out.printf("%-20s %-22s %-15s %-20s\n", "Product id", "Product Name", "Qty", "Selling Price");  
                System.out.println("");

                //iterate over by value hashmap 
                Set<Map.Entry<Integer, Product>> pset = map_product.entrySet();
                for(Map.Entry<Integer, Product> p: pset){
                    //System.out.print(+p.getKey());
                    Product pobj = p.getValue();
             
                    System.out.printf("%-20d %-22s %-15d %.2f\n", +p.getKey(), pobj.getProductName(), pobj.getAvailableQuantity(), pobj.getSellingPrice());
                    //System.out.println("");
                }
               
            }
          
                //only accepts m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.print("(M) go back to menu: ");
                    //System.out.println("");
                    //System.out.print("Enter a choice: ");

                    char choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                
                    if (m.equals(choice) || M.equals(choice)){
                        notDone = false;
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

        /////
    }

    @Override
    public void displaybyCategory() {
    	Map<String, Item> map_item = new HashMap<>();
        /*logic option starts here*/ 
        String category = " ";
        int opt; 

        //prompt user for category
        /*logic option starts here*/ 
        boolean choicenotDone = true;
        while(choicenotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            //System.out.println("Choose your option: ");
            System.out.println("Category list");
            System.out.println("1 - Display by Grocery");
            System.out.println("2 - Display by Stationary");  
            System.out.println("3 - Display by Toiletry");
            System.out.println("4 - Display by Vegetables");
                
            System.out.println("");
            System.out.print("Enter a choice: ");
            try {
                opt = scanner.nextInt();

                switch (opt){
                    //Display by Grocery
                    case 1: 
                        category = "Grocery";
                        choicenotDone = false; 
                        break;
                    //Display by Stationary
                    case 2:  
                        category = "Stationary";
                        choicenotDone = false;
                        break;
                    //Display by Toiletry
                    case 3:
                        category = "Toiletry";
                        choicenotDone = false;    
                        break;
                    //Display by Vegetables
                    case 4:
                        category = "Vegetables";
                        choicenotDone = false;   
                        break;           

                    default: 
                        choicenotDone = true; 
                       
                    }       
            
                    
            } 
            
            //wrong input, choose only 0-4
            catch (InputMismatchException e) {
                 
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                     
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
        
                char choice = scanner.next().charAt(0);
                    if((choice == 'c') || (choice == 'C')){
                        System.out.println("Back to Option Menu");
                        choicenotDone = true; 
                    }
                   
            }         
                
        }
        

        /*Display category logic end here*/
        
        
        //invoke DAO
        map_item = sdao.displaybyCategory(category);

        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   
        
        
        boolean notDone = true;
        while(notDone){
            //System.out.println("list is NOT EMPTY!! ");
              
            //display all products in table format
            System.out.printf("%-20s %-22s %-15s \n", "Item Name ", "Category", "Buying Price");  
            System.out.println("");      
             
            //iterate over by value hashmap 
            //Map<String, Item> map_item = new HashMap<>();
            Set<Map.Entry<String, Item>> iset = map_item.entrySet();
            for(Map.Entry<String, Item> i: iset){
                Item iobj = i.getValue();

                System.out.printf("%-20s %-22s %.2f \n", iobj.getItemname(), iobj.getCategory(), iobj.getBuyingPrice()); 
                //System.out.println("");
            
            }
        
               
            
          
                //only accepts m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.print("(M) go back to menu: ");
                    //System.out.println("");
                    //System.out.print("Enter a choice: ");

                    char choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                
                    if (m.equals(choice) || M.equals(choice)){
                        notDone = false;
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
         /*Display category logic ends here*/

      
       
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
                    char choice = scanner.next().charAt(0);

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
             
                    //display in table format, and 2 decimal places
                    System.out.printf("%-20s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Qty", "Buying Price", "Selling Price");  
                    System.out.println("");
                    
                     
                    System.out.printf("%-20d %-22s %-15d %-20.2f %-20.2f \n",  sp.getProductId(),  sp.getProductName(), 
                                    sp.getAvailableQuantity(), sp.getBuyingPrice(),  sp.getSellingPrice());
                    
                   
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

                    char choice = scanner.next().charAt(0);
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
                    char choice = scanner.next().charAt(0);

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
                     
                    System.out.printf("%-20s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Qty", "Buying Price", "Selling Price");  
                    System.out.println("");
                    
                     
                    System.out.printf("%-20d %-22s %-15d %-20.2f %-20.2f \n",  sp.getProductId(),  sp.getProductName(), 
                                    sp.getAvailableQuantity(), sp.getBuyingPrice(),  sp.getSellingPrice());
                    
            
                    System.out.println("");
                    
                }        
      
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

                    char choice = scanner.next().charAt(0);
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
        
        double expenses = sdao.totalExpenses();
        System.out.println("Total Expenses: " + expenses);

        boolean wrongcharacter = true;  
        while(wrongcharacter){
        
            //return to option menu
            System.out.println("");
            System.out.print("(M) go back to menu: ");
            char choice = scanner.next().charAt(0);

            Character m = 'm';
            Character M = 'M';
            
            if (m.equals(choice) || M.equals(choice)){
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

    @Override
    public void dispProfitbyCategory() {
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        double profit = sdao.totalExpenses();
        System.out.println("Profit by Category: " + profit);

        boolean wrongcharacter = true;  
        while(wrongcharacter){
        
            //return to option menu
            System.out.println("");
            System.out.print("(M) go back to menu: ");
            char choice = scanner.next().charAt(0);

            Character m = 'm';
            Character M = 'M';
            
            if (m.equals(choice) || M.equals(choice)){
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
            char choice = scanner.next().charAt(0);

            System.out.println("");
            if(choice == 'm' || choice == 'M'){
                return; 
            }  

        
    }
}
