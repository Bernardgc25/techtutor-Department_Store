package com.example.demo;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Menu.Register;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);

	char choice = '\0';
	int option; 

	Scanner scn = new Scanner(System.in);		
	boolean prog_running = true;

	Register user = new Register(); 

	while(prog_running){
		//register menu
		System.out.print("\033[H\033[2J");  
		System.out.flush();  

		user.reg(choice);
			
		System.out.println("Return to main menu? ");
		System.out.println("(1) Continue");
		System.out.println("(0) Quit Program");
		System.out.print("\n");

        System.out.print("Enter a choice: ");
		option = scn.nextInt();
		
			if( option == 1 ) {
				prog_running = true;
			} 
			else if(option == 0) {
				System.out.println("End of program, Thank you...");
				prog_running = false;
			}		
		
		}

		return ; 
	}
	
}
