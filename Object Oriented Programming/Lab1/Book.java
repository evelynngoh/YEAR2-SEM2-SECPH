package Lab1;

// Book.java
// This class defines a Book with title, author, and genre.

public class Book {
    private String title;
    private String author;
    private String genre;

    // Constructor to initialize the book's attributes
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Method to change the genre of the book
    public void changeGenre(String newGenre) {
        this.genre = newGenre;
    }

    // Method to copy genre from another Book object
    public void copyGenreFrom(Book otherBook) {
        this.genre = otherBook.genre;
    }

    // toString method to display book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre;
    }
}

