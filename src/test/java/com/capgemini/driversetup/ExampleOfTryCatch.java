package com.capgemini.driversetup;

public class ExampleOfTryCatch {
public static void main(String[] args) {
	try {
		int a[] = {10,20,30};
		System.out.println(a[3]);
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	finally {
		System.out.println("Finally block is executed.....");
	}
}
}
