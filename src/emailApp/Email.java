package emailApp;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// Email administration system - methods

public class Email {
	
	public Scanner s = new Scanner(System.in);    // Instantiate Scanner s
	
	// Encapsulate variables 
	private String fname, lname, dept, email, password;
	private String editEmail;
	private int mailLimit = 1000;
	private String file = "C:\\Users\\44784\\Documents\\Programming\\Java"
			+ "\\Projects\\Email_administration_system\\src\\emailApp\\info.txt";

	public Email(String fname, String lname) {    // public constructor to set first and last names
		this.fname = fname;
		this.lname = lname;
		System.out.println("New Employee: " + this.fname + " " + this.lname);
		// Calling methods
		this.dept = this.setDepartment();
		// note, the input to generatePassword is also random so resulting length is between 8-15
		this.password = this.generatePassword(ThreadLocalRandom.current().nextInt(8, 15 + 1));
		this.email = this.emailGeneration();
	}
	
	// Create method to generate email, noting the convention of emails being lower case 
	private String emailGeneration() {
		return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
	}
	
	// Getting department info from user
	private String setDepartment() {
		System.out.println("Department codes: \n1 for Sales \n2 for Department \n3 for Accounting \n0 Other");
		boolean flag = false;
		do {    // Use do-while to ensure it executes at least one time 
			System.out.println("Enter Department code: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: return "Sales";
			case 2: return "Development";
			case 3: return "Accounting";
			case 0: return "None"; 
			default:
				System.out.println("Invalid choice - Please choose again");
			}
		} while (!flag);
		return null;			
	}
	
	// Generate random password
	private String generatePassword(int length) {
		Random random = new Random();
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxwz";
		String nums = "0123456789";
		String symbols = "!@#$%&?";
		String allVals = caps + lowercase + nums + symbols;
		
		String password = "";
		for(int i=0; i<length; i++) {
			password = password + allVals.charAt(random.nextInt(allVals.length()));
			/* Random number generates between 0 and length of allChars variable. This is the index of the next character
			 * that will be used in the randomly generated password.     */
		}
		return password;
	}
	
	// Change password
	public void setPassword() {  // we want this to be public so the user can directly access
		boolean flag = false;
		do {
			System.out.println("Do you want to change your password!(Y/N)");
			char choice = s.next().charAt(0);
			
			if (Character.toLowerCase(choice) == 'y') {  // ensure a match is found if they entered 'y' instead of 'Y'
				flag = true;
				System.out.println("Enter current password: ");
				String temp = s.next();
				if(temp.equals(this.password)) {  // check the user entered password is equal to the saved password 
					System.out.println("Enter new password: ");
					this.password = s.next();
					System.out.println("Password changed successfully");
				} else {
					System.out.println("Incorrect password!");
				}	
			} else if (Character.toLowerCase(choice) == 'N'){
				flag = true;
				System.out.println("Password changed option cancelled!");
			} else {
				System.out.println("Enter valid choice!");
			}
		} while(!flag);
	}
	
	// Set mailbox capacity
	public void setMailLimit() {
		System.out.println("Current capacity = " + this.mailLimit + "mb");
		System.out.println("Enter new mailbox capacity: ");
		this.mailLimit = s.nextInt();
		System.out.println("Mailbox capacity successfully changed");
	}
	
	// Set alternate email
	public void alternateEmail() {
		System.out.println("Emter new alternate mail: ");
		this.editEmail = s.next();
		System.out.println("Alternate email is set");
	}
	
	// Display user info
	public void getInfo() {
		System.out.println("\nNew: " + this.fname + " " + this.lname);
		System.out.println("Department: " + this.dept);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);    // for testing only
		System.out.println("Mailbox capacity: " + this.mailLimit + "mb");
		System.out.println("Alternate mail: " + this.editEmail);
	}
	
	// Store info in file
	public void storeFile() {
		try (BufferedWriter in = new BufferedWriter(new FileWriter(new File(file)))) {  // chose area to store info
			in.write("First name: " + this.fname);
			in.append("\nLast name: " + this.lname);
			in.append("\nEmail: " + this.email);
			in.append("\nPassword: " + this.password);
			in.append("\nCapacity: " + this.mailLimit);
			in.append("\nAlternate mail: " + this.editEmail);
			System.out.println("\nData Stored");
			// close() implicitly called 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Reading info from file
	public void readFile() {
		try (BufferedReader f1 = new BufferedReader(new FileReader(new File(file)))) {
			String s;
			System.out.println("");
			while ((s=f1.readLine())!=null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
