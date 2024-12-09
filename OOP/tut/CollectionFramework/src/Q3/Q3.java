package Q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>(); // Use Book type for the list

        System.out.println("How many books do you want to add?");
        int bookCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Loop to add books
        for (int i = 0; i < bookCount; i++) {
            Book bookObj = new Book();

            System.out.println("Enter book title: ");
            bookObj.setTitle(scanner.nextLine());

            System.out.println("Enter book price: ");
            bookObj.setPrice(scanner.nextDouble());

            System.out.println("Enter book publish year: ");
            bookObj.setPublishYear(scanner.nextInt());
            scanner.nextLine(); // Consume newline

            System.out.println("Enter book author: ");
            bookObj.setAuthor(scanner.nextLine());

            bookList.add(bookObj);
        }

        // Display all books
        for (Book bookObj : bookList) {
            System.out.println("\nBook Details:");
            System.out.println("Book Title: " + bookObj.getTitle());
            System.out.println("Book Price: " + bookObj.getPrice());
            System.out.println("Book Publish Year: " + bookObj.getPublishYear());
            System.out.println("Book Author: " + bookObj.getAuthor());
        }

        // HashMap to associate books with shelf numbers
        HashMap<Book, Integer> hmap = new HashMap<>();

        for (Book bookObj : bookList) {
            System.out.println("\nPlease enter the number of the shelf where the book \"" + bookObj.getTitle() + "\" is placed:");
            int numShelf = scanner.nextInt();
            hmap.put(bookObj, numShelf);
        }

        // Display shelf placement
        System.out.println("\nBook Shelf Placement:");
        for (HashMap.Entry<Book, Integer> entry : hmap.entrySet()) {
            System.out.println("Book: " + entry.getKey().getTitle() + " -> Shelf: " + entry.getValue());
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

// Book class
class Book {
    private String title;
    private double price;
    private int publishYear;
    private String author;

    public Book() {
    }

    public Book(String title, double price, int publishYear, String author) {
        this.title = title;
        this.price = price;
        this.publishYear = publishYear;
        this.author = author;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", publishYear=" + publishYear +
                ", author='" + author + '\'' +
                '}';
    }
}
