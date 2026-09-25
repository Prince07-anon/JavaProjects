import java.util.Scanner;

public class smart_ATM_transaction {
   public static void main (String[] args) {
      Scanner a = new Scanner (System.in);
      
      int choice, withdraw = 0, deposit = 0;
      double balance = 0, depositAm, totalWithdrawn = 0, withdrawalAm,
      totalDeposited = 0;
      
      do {
      
      System.out.println("\n===== ATM MENU =====");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Check Balance");
      System.out.println("4. Transaction Summary");
      System.out.println("5. Exit");
      System.out.println("====================");
      System.out.print("Enter choice: ");
      choice = a.nextInt();
          
      switch (choice) {
      case 1: 
      System.out.print("\nEnter deposit amount: ");
      depositAm = a.nextDouble();
      
      if (depositAm <= 0) {
      System.out.println("\nInvalid Amount.");
      System.out.println("Transaction cancelled.");
      }
      
      else {
      System.out.println("\nDeposit successful.");
      totalDeposited += depositAm;
      balance += depositAm;
      System.out.println("Current Balance: PHP " + balance);
      deposit++;
      }
      
      break;
      case 2: 
      System.out.print("\nEnter withdrawal amount: ");
      withdrawalAm = a.nextDouble();
      
      if (withdrawalAm <= 0) {
      System.out.println("\nInvalid Amount.");
      System.out.println("Transaction cancelled.");
      }
      
      else if (withdrawalAm > balance) {
      System.out.println("Insufficient balance.");
      }
            
      else {
      System.out.println("\nWithdrawal successful.");
      balance = balance - withdrawalAm;
      System.out.println("Current balance: PHP " + balance);
      totalWithdrawn += withdrawalAm;
      withdraw++;
      }

      break;
      case 3:
      System.out.println("\nCurrent balance: PHP " + balance);
      
      break;
      case 4:
      System.out.println("\n===== TRANSACTION SUMMARY =====");
      System.out.println("Deposits: " + deposit);
      System.out.println("Total Deposited: PHP " + totalDeposited);
      System.out.println("\nWithdrawals: " + withdraw);
      System.out.println("Total Withdrawn: PHP " + totalWithdrawn);
      System.out.println("\nCurrent Balance: PHP " + balance);
      System.out.println("===============================");

      break;
      case 5: 
      System.out.println("\nThank you for using the ATM.");
      
      break;
      default: 
      System.out.println("\nInvalid choice.");
      System.out.println("Please enter a number from 1 to 5.");
      }
      
      } while (choice != 5); 
   
   }

}