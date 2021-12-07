package emailApp;

import java.util.Scanner;

// Email administration system - class to run

public class EmailApp {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter first name: ");
		String fname = s.next();
		System.out.println("Enter last name: ");
		String lname = s.next();
		
		Email email1 = new Email(fname, lname);
		int choice = -1;
		do {
			System.out.println("\n**********************"
					+ "\nEnter your choice: \n1. Show Info\n2. Change password\n3. Change mailbox capacity"
					+ "\n4. Set alternate mail\n5. Store data in file\n6. Display data from file\n7. Exit");
			choice = s.nextInt();
			switch (choice) {
				case 1: email1.getInfo();
					break;
				case 2: email1.setPassword();
					break;
				case 3: email1.setMailLimit();
					break;
				case 4: email1.alternateEmail();
					break;
				case 5: email1.storeFile();
					break;
				case 6: email1.readFile();
					break;
				case 7: System.out.println("Thank you for using the application!");
					break;
				default: System.out.println("Invalid choice!\n Please enter a valid choice.");
			}
		} while(choice!=7);
	}
}
