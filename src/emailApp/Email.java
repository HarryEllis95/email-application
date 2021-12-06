package emailApp;

import java.util.Scanner;

public class Email {
	
	public Scanner s = new Scanner(System.in);    // Instantiate Scanner s
	
	// Encapsulate variables 
	private String fname, lname, dept, email, pass;
	private String editEmail;
	private int mailLimit = 1000;

	public Email(String fname, String lname) {    // public constructor to set first and last names
		this.fname = fname;
		this.lname = lname;
		System.out.println("New Employee:" + this.fname + "" + this.lname);
	}
	
	public static void main(String[] args) {
		
	}
}
