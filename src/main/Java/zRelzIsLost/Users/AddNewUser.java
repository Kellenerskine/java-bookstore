package zRelzIsLost.Users;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddNewUser {
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        boolean c = false;

        System.out.println("You are now adding a new user to the database.");
        System.out.print("User first name: ");
        String firstName = user.nextLine();
        System.out.print("User last name: ");
        String lastName = user.nextLine();
        System.out.print("Choose a Username: ");
        String username = user.nextLine(); //to make browsing the store casually easier?

        //payment methods
        System.out.println("What payment method would you like to use?\n If Paypal enter 'a', If credit card enter 'b'\n-->");
        String paymentMethChoice = user.nextLine();

        //this feels stupid and unnecessary
        String paypalEmail = "";
        String cardholderName = "";
        int creditNum = 0;
        int expiryMonth = 0;
        int expiryYear = 0;
        int threeNumThingy = 0;

        if (paymentMethChoice.equalsIgnoreCase("a")){
            //redirect to paypal API?
            System.out.print("Enter your Paypal email address: "); //TODO: this is certainly not sufficient
            paypalEmail = user.nextLine();
            c = true;
        }else{
            System.out.print("Enter the Card Holder name: ");
            cardholderName = user.nextLine();
            System.out.print("Enter your credit card number: "); //TODO: use lonz(?) to verify
            creditNum = user.nextInt(); //add lots of of conditionals, but not at 2 am lol.
            System.out.print("Card expiry month: ");
            expiryMonth = user.nextInt();
            System.out.print("Card expiry year: ");
            expiryYear = user.nextInt();
            System.out.println("Enter 3 num thingy on back of card: ");
            threeNumThingy = user.nextInt();
        }

        //password creation
        String pass1 = "";
        String pass2 = "";
        int a = 0;
        while(a < 1){
            System.out.print("User password (letters only): "); //TODO: need to make this accept all chars for the password
            pass1 = user.nextLine();
            System.out.print("Repeat password: ");
            pass2 = user.nextLine();
            if(pass1.equals(pass2)){
                a += 10;
            }else{
                System.out.println("Your passwords did not match, re enter them please.");
            }
        }

        try{
            FileWriter myWriter = new FileWriter("/home/kellen/cs/java/java-bookstore/src/main/Java/zRelzIsLost/Users/UserList.txt", true);
            myWriter.write("\n-----");
            myWriter.write("\nUsername: " + username + "\n");
            myWriter.write("First name: " + firstName + "\n");
            myWriter.write("Last name: " + lastName + "\n");
            myWriter.write("Password: " + pass1 + "\n");

            if (c = true) { //paypal
                myWriter.write("PayPal info: " + paypalEmail);
            }else{ //credit card
                myWriter.write("Credit info: " + "Name on card: " + cardholderName + ", Credit num: " + creditNum + ", Expiry date: " + expiryMonth + "/" + expiryYear);
            }

            myWriter.close();
            System.out.println("Added a new user named: " + username);
        }catch (IOException e){
            System.out.println("You messed up!");
            e.printStackTrace();
        }
    }
}