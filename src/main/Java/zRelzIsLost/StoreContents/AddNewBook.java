package zRelzIsLost.StoreContents;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddNewBook {
//put this all in a loop maybe? while loop?
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        System.out.println("You are now adding a new book to the bookstore.");
        System.out.print("Please Enter the title of the book and hit enter: ");
        String bookTitle = user.nextLine();
        System.out.print("Please enter the author of the book and hit enter: ");
        String bookAuthor = user.nextLine();
        System.out.print("Please enter the genre of the book: ");
        String bookGenre = user.nextLine(); //to make browsing the store casually easier?
        System.out.print("Please enter the book's price and hit enter: ");
        Float bookPrice = user.nextFloat();

        try{
            FileWriter myWriter = new FileWriter("/home/kellen/cs/java/java-bookstore/src/main/Java/zRelzIsLost/StoreContents/BookList.txt", true);
            myWriter.write("\n-----");
            myWriter.write("\nTitle: " + bookTitle + "\n");
            myWriter.write("Author: " + bookAuthor + "\n");
            myWriter.write("Genre: " + bookGenre + "\n");
            myWriter.write("Price: " + String.valueOf(bookPrice));
            myWriter.close();
            System.out.println("Added a new book named: " + bookTitle + " written by " + bookAuthor);
        }catch (IOException e){
            System.out.println("You messed up!");
            e.printStackTrace();
        }
    }
}
