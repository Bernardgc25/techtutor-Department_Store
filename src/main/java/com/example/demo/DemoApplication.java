package com.example.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Menu.Register;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);

	int option = 0; 

	Scanner scanner = new Scanner(System.in);		
	boolean notDone = true;

	Register user = new Register(); 
	
		while(notDone){
			//int option = 0; 

			//register menu
			System.out.print("\033[H\033[2J");  
			System.out.flush();  

			user.reg(option);
			System.out.println("DemoApplication.java");
			System.out.println("Return to main menu? ");
			System.out.println("0 - Quit Program");
			System.out.println("1 - Continue");
			System.out.print("\n");

			System.out.print("Enter a choice: ");
			try {
				option = scanner.nextInt();
				//clearscreen
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
                switch (option) {
                //login as Admin 
                    case 0:
                        System.out.println("End of program, Thank you...");
						notDone = false;
                        break; 
                    case 1:
                        //notDone = true;
                        //break;
					default:
						System.out.println("Invalid, choose either 0/1...");
                    }
				}	
			catch (InputMismatchException e) {
				
				//clear screen
				System.out.print("\033[H\033[2J");  
				System.out.flush();
					
				System.out.println("Invalid input, integer only");
				System.out.println("press any character to continue");
				
				char choice = scanner.next().charAt(0);

				choice = scanner.next().charAt(0);
				if((choice == 'c') || (choice == 'C')){
					System.out.println("Back to Option Menu");
					notDone = true; 
				
				}
			}
		}
	}
}


