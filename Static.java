import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private List<Book> books;
    private int numBooks;

    public Library(int numBooks) {
        this.numBooks = numBooks;
        books = new ArrayList<>(numBooks);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book " + book.getTitle() + " has been issued.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " is not available for issue.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book " + book.getTitle() + " has been returned.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " is not available for return.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library(5);

        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(5, "Animal Farm", "George Orwell"));

        library.displayBooks();

        library.issueBook(2);
        library.returnBook(2);

        library.issueBook(6);
    }
}
