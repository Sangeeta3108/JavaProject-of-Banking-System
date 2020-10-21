import java.util.Scanner;

class Bank {
	private String accountType;
    private String accountNumber;
    private String accountName;
    private double balance;

    Scanner scanner = new Scanner(System.in);

    void openAccount() {				     //Method to open user account.
    	System.out.println("Enter Account Type: Current or Saving?");
    	accountType = scanner.next();
        System.out.print("Enter the Account No: ");
        accountNumber = scanner.next();
        System.out.print("Enter Customer Name: ");
        accountName = scanner.next();
        System.out.print("Enter the Balance: $ ");
        balance = scanner.nextDouble();
    }

    void showAccount() {				     //method to show account details.
        System.out.println("Account Type: " + accountType + ","+ "Account Number: " + accountNumber + ","+
        				   "Account Name: "+ accountName + "," +"Balance: $ "+ balance);
    }

    boolean searchAccount(String account) {  //method to search the account.
        if (accountNumber.equals(account)) {
            showAccount();
            return (true);
        }
        return (false);
    }
    
    void depositAmount() {					//method to deposit money in the account.
        double amount;
        System.out.println("Enter Amount You Want to Deposit : $ ");
        amount = scanner.nextLong();
        balance = balance + amount;
    }

    void withdrawAmount() {					//method to withdraw money from the account.
        double amount;
        System.out.println("Enter Amount You Want to withdraw : $ ");
        amount = scanner.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Transaction Failed due to Insufficient Balance.");
        }
    }
    
    public void transferAmount(double amount) {   //Method for Transferring money into the Account. 
		if(balance >= amount){
			balance = balance - amount;
			System.out.println("The amount of $ " + amount + " is Successfully transfered.");
			showAccount();
			
		} else {
				System.out.println("Insufficient funds");
			}
		}

	public String writeToFile() {
		return 
				    "Account Type : " + accountType + "," +
				   "Account Number : " + accountNumber + "," + 
			       "Customer Name : " + accountName + "," + 
				   "Balance : $ " + balance;
	}
}
