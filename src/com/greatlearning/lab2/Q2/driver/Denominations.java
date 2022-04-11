package com.greatlearning.lab2.Q2.driver;

import java.util.Scanner;

public class Denominations {
	
	//method to be called to merge sort the array in descending order
	private static void sortValues(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			sortValues(arr, left, mid);
			sortValues(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
					
	}
	
	//"Divide and Conquer" algorithm in use
	private static void merge(int[] arr, int left, int mid, int right) {
		int len1 = mid + 1 - left;
		int L[] = new int[len1];
		
		int len2 = right - mid;			
		int R[] = new int[len2];
		
		for(int i = 0; i < len1; i++)
			L[i] = arr[left+i];
		
		for(int j = 0; j < len2; j++)
			R[j] = arr[mid+1+j];
		
		int i = 0, j = 0, k = left;
		while(i < len1 && j < len2) {
			if(L[i] >= R[j]) {
				arr[k] = L[i];
				i++;
			}
			
			else {
				arr[k] = R[j];
				j++;
			} 
			
			k++;
		}
		
		//to transfer leftover elements
		while(i < len1) {
			arr[k] = L[i];
			i++;
			k++;
			}
		
		while(j < len2) {
			arr[k] = R[j];
			j++;
			k++;
			}
	}

	public static void main(String[] args) {
		
		System.out.print("Enter the size of currency denominations: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int denominations[] = new int[size];	//creating array
		
		System.out.println("\nEnter the currency denominations value: ");
		for(int i = 0; i < size; i++) {
			denominations[i] = sc.nextInt();	//populating array
		}
		
		//sorting array in descending order by calling merge-sorting method from above
		sortValues(denominations, 0, denominations.length-1);
		
		System.out.print("\nEnter the amount you want to pay: ");
		int amount  = sc.nextInt();
		
		int count[] = new int[denominations.length];//second array to keep count of each note to be paid
		
		for(int i = 0; i < denominations.length; i++) {
			if(amount >= denominations[i]) { 		//condition to eliminate non-payable amounts
				int x = amount/denominations[i];
				amount = amount - (denominations[i] * x);
				count[i] = x;
			}			 
		}
		
		if(amount > 0) {
			System.out.println("\nNot possible to pay the entered amount!");
		}
		
		else {
			System.out.println("\nYour payment approach in order to give the minimum number of notes will be: ");
			for(int i = 0; i < count.length; i++) {
				if(count[i]>0) {				//condition eliminating unused denominations 
				System.out.println(denominations[i] + ": " + count[i]);
				}
			}
		

		} sc.close();
	
	

	}
}
