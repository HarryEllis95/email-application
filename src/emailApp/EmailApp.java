package emailApp;

import java.util.Scanner;

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
			System.out.println("\n******\nEnter your choice: \n1. Show Info\n2. Change password\n3. Change mailbox capacity"
					+ "\n4. Set alternate mail\n5. Exit");
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
				case 5: System.out.println("Thank you for using the application!");
					break;
				default: System.out.println("Invalid choice!\n Please enter a valid choice.");
			}
		} while(choice!=5);
	}
}
