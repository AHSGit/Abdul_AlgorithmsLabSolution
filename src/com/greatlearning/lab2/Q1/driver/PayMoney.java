package com.greatlearning.lab2.Q1.driver;

import java.util.Scanner;

public class PayMoney {

	public static void main(String[] args) {
		int i=0, j = 1, size, transaction[], target, num, sum = 0;
		boolean status = false;
				
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of transaction array: ");
		size = sc.nextInt();
		transaction = new int [size];		//creating array
		
		System.out.println("\nEnter the values of array: ");
		for(int k = 0; k < size; k++)
			transaction[k] = sc.nextInt();	//populating array
		
		System.out.print("\nEnter the total number of targets that need to be achieved: ");
		num = sc.nextInt();
		
		while(j <= num) {					//iteration for number of targets
			System.out.print("\nEnter the value of target " + j + ": ");
			target = sc.nextInt();
		
			for(i = 0; i < size; i++) {		//iteration to check target met at which transaction
				sum += transaction[i];
				if(sum >= target) {
					status = true;
					break;
				}
			
				else status = false;		//resetting status value for next target iteration				
			} 
		
			sum = 0;						//resetting sum value for next target iteration
			j++;
	
			if(status)
				System.out.println("\nTarget achieved after " + (i+1) + " transactions!\n----------------");
			
			else
				System.out.println("\nGiven target is NOT achieved!\n----------------");
		}
		sc.close();
	}

}
