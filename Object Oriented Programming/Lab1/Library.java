package Lab1;

// Library.java
// This class tests the Book class by creating and manipulating Book objects

public class Library {
    public static void main(String[] args) {
        // Create two Book objects
        Book book1 = new Book("Dune", "Frank Herbert", "Science Fiction");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy");

        // Print original details
        System.out.println("Original Details:");
        System.out.println(book1);
        System.out.println(book2);

        // Change genre of the first book
        book1.changeGenre("Classic");

        // Copy genre from book1 to book2
        book2.copyGenreFrom(book1);

        // Print updated details
        System.out.println("\nAfter Changes:");
        System.out.println(book1);
        System.out.println(book2);
    }
}

