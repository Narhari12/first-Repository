package com.client;

import java.util.Scanner;

import com.seriveImpl.OperationI;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OperationI opt = new OperationI();
		while (true) {
			System.out.println("=============================");
			System.out.println(" Press 1 to Add Employee \n Press 2 to View Employee \n Press 3 to Logout");
			System.out.println("=============================");
			System.out.print("Enter your choice : ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				opt.addData();
				break;
			case 2:
				opt.viewData();
				break;
			case 3:
				System.out.println("You have successfully logout..!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");

			}
		}

	}
}
