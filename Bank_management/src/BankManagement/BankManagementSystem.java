package BankManagement;
import java.util.Scanner;

class userdetails{
	String userid = "ramesh123";
	String username = "ramesh";
	private int usermobileno = 123456789;
	private String useraddress = "chennai";
	private String useremail = "ramesh123@gmail.com";
}
class userAccount{
	private int accountBalance = 30000;
	 public int getAccountBalance() {
	        return accountBalance;
	    }
	    public void setAccountBalance(int newBalance) {
	        accountBalance = newBalance;
	    }
	private int accountType;
	private int pinNumber = 1234;
	public int getpinNumber() {
		return pinNumber;
	}
	public void setpinNumber(int newpin) {
		 pinNumber = newpin;
	}
	private int accountBlocked;

}
//if pin is correct perform enter into the account otherwise account is blocked
class pin{
	void pin(){
		Scanner sc = new Scanner(System.in);
		 operation op = new operation();
		for(int i = 0;i < 3;i++) {
			System.out.println("enter the pin: ");
			String userinput = sc.nextLine();
			if (userinput.equalsIgnoreCase("1234")) {
	                System.out.println("Correct!");
	                op.operation();
	                 return;
	            } else {
	                System.out.println("Wrong answer. Try again.");
	            }
			
	        }
		System.out.println("account is blocked");
		return;
	}
}
//after pin is correct,shows the option
class operation{
	userAccount acc = new userAccount();
	Scanner sc = new Scanner(System.in);
	void operation() {
	    System.out.println("enter your option 1.withdraw 2.viewBalance 3.changePIN: ");
	    int option = sc.nextInt();
	    sc.nextLine(); // Consume the newline

	    // withdraw the amount
	    if(option == 1) {
	        System.out.println("enter your amount:");
	        int amount = sc.nextInt();
	        sc.nextLine(); // Consume the newline
	        System.out.println("you have entered amount: " + amount);
	        if(amount <= acc.getAccountBalance()) {
	            acc.setAccountBalance(acc.getAccountBalance() - amount);
	            System.out.println("your amount has been withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient balance");
	        }

	    }
	    // 2.use to view balance
	    
	    else if(option == 2) {
	        System.out.println("your account balance: " + acc.getAccountBalance());

	    } 
	  // 3.change the pin  
	    
	    else if(option == 3) {
	        System.out.println("Enter your confirm pin:" );
	        int confirmPin = sc.nextInt();
	        sc.nextLine();
	        System.out.println("Enter your re-confirm pin:" );
	        int reconfirmPin = sc.nextInt();
	        sc.nextLine();
	        if(confirmPin == reconfirmPin) {
	            acc.setpinNumber(reconfirmPin);
	            System.out.println("Your pin has been changed successfully.");
	        } else {
	            System.out.println("Pin mismatch. Try again.");
	        }

	    } else {
	        System.out.println("Invalid option selected.");
	        return;
	    }
	    System.out.println("Do you want to continue? Yes or No:");
	    String yesorno = sc.nextLine();
	    if(yesorno.equalsIgnoreCase("yes")) {
	        operation();
	    } else {
	        System.out.println("Thank you for using the system.");
	    }
	}
}

public class BankManagementSystem {
	public static void main(String[] args) {
	       pin obj1 = new pin();
	       obj1.pin();
		}
}
