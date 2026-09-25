import java.util.Scanner;

public class HotelReservation {
   public static void main (String[] args) {
      Scanner y = new Scanner (System.in);
   
   String name, email, roomname, guestName, upgradeName, specialName;
   int age, room, night, guest, roomUpgrade, special;
   double Rfare, Gdis, Ndis = 0, upgradeCharge, loyaltyBonus = 0, Sfare, 
   roomCharge, upgradeChargeT, guestDiscount, guestTotal, roomxupgrade, stayDiscount, totalAmount, payment;
   
   System.out.print("Enter customer name: ");
   name = y.nextLine();
   
   if (name.isEmpty()) {
      System.out.println("\nPlease type your name.");
      return;
   }
   
   System.out.print("Enter age: ");
   age = y.nextInt();
   
   if (age < 18) {
      System.out.print("\nYou are not an Adult.");
      return;
   }
   
   y.nextLine();
   System.out.print("Enter email: ");
   email = y.nextLine();
   
   if (email.length() < 6) {
      System.out.print("\nEmail is shorter than 6 characters.");
      return;
   }
   
   System.out.println("\n============ ROOM MENU =============");
   System.out.println("[1] Standard Room - PHP 1800.00/night");
   System.out.println("[2] Deluxe Room - PHP 2750.00/night");
   System.out.println("[3] Executive Suite - PHP 4200.00/night");
   System.out.println("[4] Presidential Suite - PHP 6800.00/night");
   System.out.print("Select Room: ");
   room = y.nextInt();
   
   switch (room) {
   case 1:
      roomname = "Standard Room";
      Rfare = 1800;
      break;
      
   case 2:
      roomname = "Deluxe Room";
      Rfare = 2750;
      break;

   case 3:
      roomname = "Executive Suite";
      Rfare = 4200;
      break;

   case 4:
      roomname = "Presidential Suite";
      Rfare = 6800;
      break;
      
   default:
      System.out.print("\nInvalid room selection.");
      return;
    }
    
   System.out.print("\nEnter number of nights: ");
   night = y.nextInt();
   
   if (night < 1 || night > 14) {
      System.out.println("\nInvalid number of nights.");
      return;
   }
   
   if (night == 1 || night == 2) {
      Ndis = 0;
   }
   
   else if (night >= 3 && night <= 6) {
      Ndis = 0.05;
   }
   
   else if (night >= 7 && night <= 14) {
      Ndis = 0.10;
   }
   
   System.out.println("\n===== GUEST TYPE =====");
   System.out.println("[1] Regular Guest");
   System.out.println("[2] Senior Citizen");
   System.out.println("[3] Student");
   System.out.println("[4] Corporate Guest");
   System.out.print("Select guest type: ");
   guest = y.nextInt();
      
   if (guest == 2 && night >= 7 || guest == 3 && night >= 7) {
      loyaltyBonus = 500;
   }
   
   switch (guest) {
   case 1:
      Gdis = 0;
      guestName = "Regular Guest";
      break;
      
   case 2:
      Gdis = 0.15;
      guestName = "Senior Citizen";
      break;
      
   case 3:
      Gdis = 0.10;
      guestName = "Student";
      break;
      
   case 4:
      Gdis = 0.12;
      guestName = "Corporate Guest";
      break;
      
   default:
      System.out.print("\nInvalid guest type.");
      return;
   }
   
   if (guest != 2 && room == 4 && guest != 4) {
      System.out.print("\nThis room is restricted to Corporate Guests and Senior Citizens.");
      return;
   }
   
   System.out.print("\n============= ROOM UPGRADE =============");
   System.out.print("\n[1] No Upgrade");
   System.out.print("\n[2] Breakfast Package - PHP 350.00/night");
   System.out.print("\n[3] Premium Package - PHP 750.00/night");
   System.out.print("\nSelect room upgrade: ");
   roomUpgrade = y.nextInt();
   
   if (roomUpgrade == 3 && night == 1) {
      System.out.print("\nPremium Package requires at least 2 nights.");
      return;
   }
   
   switch (roomUpgrade) {
   case 1: 
      upgradeName = "No Upgrade";
      upgradeCharge = 0;
      break;
      
   case 2: 
      upgradeName = "Breakfast Package";
      upgradeCharge = 350;
      break;
      
   case 3: 
      upgradeName = "Premium Package";
      upgradeCharge = 750;
      break;
      
   default: 
      System.out.print("\nInvalid room upgrade selection.");
      return;
   }
   
   System.out.println("\n======== SPECIAL REQUEST ========");
   System.out.println("[1] None");
   System.out.println("[2] Airport Transfer - PHP 1200.00");
   System.out.println("[3] Extra Bed - PHP 900.00");
   System.out.println("[4] Both - PHP 1900.00");
   System.out.print("Select special request: ");
   special = y.nextInt();
   
   switch (special) {
   case 1:
      specialName = "None";
      Sfare = 0;
      break;
      
   case 2:
      specialName = "Airport Transfer";
      Sfare = 1200;
      break;
      
   case 3:
      specialName = "Extra Bed";
      Sfare = 900;
      break;
      
   case 4:
      specialName = "Both";
      Sfare = 1900;
      break;
      
   default: 
      System.out.print("Invalid special request.");
      return;  
   }
   
   roomCharge = Rfare * night;
   upgradeChargeT = upgradeCharge * night;
   roomxupgrade = roomCharge + upgradeChargeT;
   guestDiscount = roomxupgrade * Gdis; 
   guestTotal = roomxupgrade - guestDiscount;
   stayDiscount = guestTotal * Ndis;
   
   totalAmount = roomCharge + upgradeChargeT + Sfare - guestDiscount - stayDiscount - loyaltyBonus;
   
   System.out.println("\n===== HOTEL RESERVATION RECEIPT =====");
   
   System.out.println("\nCustomer: " + name);
   System.out.println("Age: " + age);
   System.out.println("Email: " + email);
   
   System.out.println("\nRoom: " + roomname);
   System.out.println("Nights: " + night);
   System.out.println("Guest Type: " + guestName);
   System.out.println("Upgrade: " + upgradeName);
   System.out.println("Special Request: " + specialName);
   
   System.out.printf("\nRoom Charge: PHP %.2f%n", roomCharge);
   System.out.printf("Upgrade Charge: PHP %.2f%n", upgradeChargeT);
   System.out.printf("Special Request: PHP %.2f%n", Sfare);

   System.out.printf("\nGuest Discount: PHP %.2f%n", guestDiscount);
   System.out.printf("Stay Discount: PHP %.2f%n", stayDiscount);
   System.out.printf("Loyalty Bonus: PHP %.2f%n", loyaltyBonus);
   
   System.out.printf("\nTotal Amount: PHP %.2f%n", totalAmount);
   System.out.print("Payment: PHP ");
   payment = y.nextDouble();
   
   if (payment < totalAmount) {
      System.out.printf("Insufficient Payment.");
      System.out.printf("\nYou still need PHP %.2f.", (totalAmount - payment));
   }
   
   else if (payment > totalAmount) {
      System.out.println("Payment Successful.");
      System.out.printf("Change: PHP %.2f", (payment - totalAmount));
   }
   
   else if (payment == totalAmount) {
      System.out.println("Payment Successful.");
      System.out.println("No change.");
   }

 
   }
}