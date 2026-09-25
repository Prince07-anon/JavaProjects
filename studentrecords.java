import java.util.Scanner;

public class studentrecords {
  public static void main(String[] args) {
    Scanner a = new Scanner (System.in);
    
    int program, cost, units, studentNo, i, passed = 0, failed = 0, scholar = 0, regular = 0, fully = 0, partial = 0,
    fully2 = 0, full = 0;
    String programName, studentName, status = "", studentType, code;
    double writtenP, performanceP, examP, totalP, performanceave, writtenave, exam,
    finalGrade, balance, payment, remainingB, discountedB, discount, totalmoney = 0, totalcollected = 0,
    totalChange = 0;
       
    System.out.println("========================================\n");
    System.out.println("   STUDENT RECORDS MANAGEMENT SYSTEM     ");
    System.out.println("\n========================================");
    
    System.out.println("\nChoose a Program >>");
    System.out.println("[1] BSCS - Php 750/unit");
    System.out.println("[2] BSIT - Php 650/unit");
    System.out.println("[3] BSIS - Php 600/unit");
    System.out.print("Select: ");
    program = a.nextInt();
    
    switch (program) {
    case 1:
    cost = 750;
    programName = "BSCS";
    break;
    case 2:
    cost = 650;
    programName = "BSIT";
    break;
    case 3:
    cost = 600;
    programName = "BSIS";
    break;
    default:
    System.out.print("\nINVALID OPTION.");
    return;
      }
      
     System.out.print("\nNo. of Units: ");
     units = a.nextInt();
     
     balance = units * cost;
     
     System.out.println("\n==============================");
     System.out.println("\nPERCENTAGE >>");
     System.out.print("Written Works: ");
     writtenP = a.nextDouble();
     System.out.print("Performance Tasks: ");
     performanceP = a.nextDouble();
     System.out.print("Exam: ");
     examP = a.nextDouble();
     
     totalP = writtenP + performanceP + examP;
     
     if (totalP != 100) {
     System.out.print("\nINVALID. Should be equal to 100.");
     return;
     }

     System.out.println("\n==============================");
     System.out.println("\n       " + programName + " STUDENTS");
     System.out.print("\nEnter students to process: ");
     studentNo = a.nextInt();
     
     for (i = 1; i  <= studentNo; i++) {
     double change = 0;
     System.out.println("\nSTUDENT " + i + " >>");
     a.nextLine();
     System.out.print("Enter student name: ");
     studentName = a.nextLine();
     System.out.print("Written Average: ");
     writtenave = a.nextDouble() * (writtenP / 100);
     System.out.print("Performance Average: ");
     performanceave = a.nextDouble() * (performanceP / 100);
     System.out.print("Exam Score (out of 100): ");
     exam = a.nextDouble() * (examP / 100);
     finalGrade = (writtenave + performanceave + exam);
     
     System.out.println("Final Grade: " + finalGrade);
     System.out.println("------------------------------");
     System.out.print("Student Type (scholar or regular?): ");
     a.nextLine();
     studentType = a.nextLine();
     
     if (studentType.equalsIgnoreCase("scholar")) {
     System.out.println("50% discount applied >>");
     discount = 0.50;
     scholar++;
     }
     
     else {
     discount = 0;
     regular++;
     }
     
     discountedB = balance - (balance * discount);
     System.out.println("balance: " + discountedB);
     System.out.print("Enter Payment: ");
     payment = a.nextDouble();
     
     if (payment == discountedB) {
     status = "FULLY PAID";
     fully++;
      }

     else if (payment < discountedB) {
     remainingB = discountedB - payment;
     System.out.println("Remaining Balance: " + remainingB);
     status = "PARTIAL or INCOMPLETE";
     partial++;
     }
          
     else {
     change = payment - discountedB;
     System.out.println("Change is " + change + ".");
     status = "FULLY PAID";
     fully++;
     }
                
     System.out.print("Status: " + status + "\n\n");  
     
     if (finalGrade < 75) {
     failed++;
      }
      
     else {
     passed++;
     }
     
     if (payment > 0) {
     totalChange += change;
     totalmoney += payment;
     totalcollected = totalmoney - totalChange;
      }
      
      }
      
     System.out.println("Verify first to proceed to records summary (type > I AM NOT A ROBOT) >>");
       
     do {
     a.nextLine
     System.out.print("Code: ");
     code = a.nextLine();
     if (!code.equals("I AM NOT A ROBOT")) { 
     System.out.println("Incorrect code.");
     }
     } while (!code.equals("I AM NOT A ROBOT"));
     
     System.out.println("\n==============================");
     System.out.println("   STUDENTS RECORD SUMMARY");
     System.out.println("==============================");

     System.out.println("Numbers of PASSED: " + passed);
     System.out.println("Numbers of FAILED: " + failed);
     System.out.println("Total Scholar: " + scholar);
     System.out.println("Total Regular: " + regular);
     System.out.println("Partial or Incomplete: " + partial);
     System.out.println("Fully Paid: " + fully);
     System.out.println("\nTOTAL MONEY COLLECTED: " + totalcollected);
     System.out.println("==============================");


        }
}
