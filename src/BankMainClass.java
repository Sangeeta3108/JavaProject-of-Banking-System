import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankMainClass {
    public static void main(String arg[]) throws IOException {
    	writeToFile();
    	
    	FileWriter fileWriter = new FileWriter("userfile.txt"); 
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    try {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How Many Customer You Want to Input : ");
        int n = scanner.nextInt();
        Bank obj[] = new Bank[n];
        for (int i = 0; i < obj.length; i++) {
        	obj[i] = new Bank();
        	obj[i].openAccount();
            printWriter.println(obj[i].writeToFile());
        }
        int ch;
        do {
            System.out.println("Menu\n1. Display All\n 2. Search Account\n 3. Deposit\n 4. Withdrawal\n 5. Transfer\n 6.Exit ");
                System.out.println("Your Choice :"); 
                ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < obj.length; i++) {
                        	obj[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account Number You Want to Search: ");
                        String accnt = scanner.next();
                        boolean found = false;
                        for (int i = 0; i < obj.length; i++) {
                            found = obj[i].searchAccount(accnt);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account Does Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the Account No : ");
                        accnt = scanner.next();
                        found = false;
                        for (int i = 0; i < obj.length; i++) {
                            found = obj[i].searchAccount(accnt);
                            if (found) {
                            	obj[i].depositAmount();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account Does Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        accnt = scanner.next();
                        found = false;
                        for (int i = 0; i < obj.length; i++) {
                            found = obj[i].searchAccount(accnt);
                            if (found) {
                            	obj[i].withdrawAmount();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account Does Not Exist..");
                        }
                        break;
                        
                    case 5:
                    	System.out.println("Enter the Account No : ");
		            	accnt = scanner.next();
		            	found = false;
		            	for (int i = 0; i < obj.length; i++) {
		                	found = obj[i].searchAccount(accnt);
		                    if (found) {
		                    	System.out.println("Enter the amount you want to transfer : $ " ); 
		                    	double amount =scanner.nextDouble();
								obj[i].transferAmount(amount);
		                        break;
		                    }
		                }
		                if (!found) {
		                    System.out.println("This Account Does Not Exist.");
		                }
                         break;

                    case 6:
                        System.out.println("Exit ! Thank You.");
                        break;
                }
            }
            while (ch != 6);
        printWriter.close();
        }catch (InputMismatchException e) {
			System.out.println("Please enter input according to Data Type. Restart the program & Try Again !");
		}
    }
	private static void writeToFile() {
	}

    }
