package ironhack.IronLibrary.model;

import ironhack.IronLibrary.classes.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    Library library;
    private Boolean exit = false;
    Scanner scanner = new Scanner(System.in);

    private int command;
    private String ironlibraryLogo = " __  .______        ______   .__   __.  __       __  .______   .______          ___      .______     ____    ____ \n" +
            "|  | |   _  \\      /  __  \\  |  \\ |  | |  |     |  | |   _  \\  |   _  \\        /   \\     |   _  \\    \\   \\  /   / \n" +
            "|  | |  |_)  |    |  |  |  | |   \\|  | |  |     |  | |  |_)  | |  |_)  |      /  ^  \\    |  |_)  |    \\   \\/   /  \n" +
            "|  | |      /     |  |  |  | |  . `  | |  |     |  | |   _  <  |      /      /  /_\\  \\   |      /      \\_    _/   \n" +
            "|  | |  |\\  \\----.|  `--'  | |  |\\   | |  `----.|  | |  |_)  | |  |\\  \\----./  _____  \\  |  |\\  \\----.   |  |     \n" +
            "|__| | _| `._____| \\______/  |__| \\__| |_______||__| |______/  | _| `._____/__/     \\__\\ | _| `._____|   |__|";
    public static final String COURSE_IMAGE = "📚";
    public static final String SAD_FACE = "\uD83D\uDE25";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";

    public static final String COLOR_WHITE = "\u001B[37m";

    public void userInteraction() throws InterruptedException {
        greeting();
        while (exit == false) {
            displayMenu();
            executeCommands(introduceCommand());
        }
    }

    public void greeting() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(COLOR_PURPLE + ironlibraryLogo + COLOR_RESET);
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------Welcome to Ironlibrary! Let's begin " + COURSE_IMAGE + "---------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        Thread.sleep(1000);
    }

    private void displayMenu() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println(COLOR_GREEN + "╔════════════════════════════════════════════════════╗");
        System.out.println("║        " + "               MENU                " + "         ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ " + "1. Add a book" + "                                      ║");
        System.out.println("║ " + "2. Search book by title" + " " + "                           ║");
        System.out.println("║ " + "3. Search book by category" + "                         " + "║");
        System.out.println("║ " + "4. Search book by Author" + "                       " + "    ║");
        System.out.println("║ " + "5. List all books along with author" + "                " + "║");
        System.out.println("║ " + "6. Issue book to student" + "                           " + "║");
        System.out.println("║ " + "7. List books by usn" + "                               " + "║");
        System.out.println("║ " + "8. Exit" + "                     " + "                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝" + COLOR_RESET);
    }

    public int introduceCommand() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Enter your choice:");
        command = validateNumber();
        return command;
    }

    public void executeCommands(int command) throws InterruptedException {
        if (command == 1) {
            addBook();
        } else if (command == 2) {
            searchBookByTitle();
        } else if (command == 3) {
            searchBookByCategory();
        } else if (command == 4) {
            searchBookByAuthor();
        } else if (command == 5) {
            listBooksWithAuthor();
        } else if (command == 6) {
            issueBook();
        } else if (command == 7) {
            listBooksByStudentNumber();
        } else if (command == 8) {
            exit();
        } else {
            System.out.println("Please enter one of the possible available commands: 1, 2, 3...8");
            executeCommands(introduceCommand());
        }
    }

    public void addBook() {
        String isbn;
        String title;
        String category;
        String authorName;
        String email;
        int numberOfBooks;
        System.out.println("Enter isbn :");
        isbn = validateString();
        System.out.println("Enter title :");
        title = validateString();
        System.out.println("Enter category :");
        category = validateString();
        System.out.println("Enter Author name :");
        authorName = validateName();
        System.out.println("Enter Author mail:");
        email = validateEmail();
        System.out.println("Enter number of books :");
        numberOfBooks = validateNumber();
        Book book1 = new Book(isbn, title, category, numberOfBooks);
        library.insertBook(book1);
        Author author1 = new Author(authorName, email, book1);
        library.insertAuthor(author1);
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------Great job! We have added your book to our database! " + COURSE_IMAGE + "-------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    public String validateName() {
        String name = null;
        while (name == null || name.isEmpty()) {
            System.out.println("(minimum of 2 words, letters only)");
            name = scanner.nextLine();
            if (!isValidName(name)) {
                System.out.println("Invalid name. Please enter a name with only letters and at least two words.");
                name = "";
            }
        }
        return name;
    }

    private boolean isValidName(String name) {
        return name.matches("^[A-Za-z]+(\\s[A-Za-z]+)+$");
    }

    private String validateBook() {
        String isbn = null;
        while (isbn == null || library.getBookById(isbn) == null) {
            System.out.println("Please provide a valid ISBN");
            isbn = scanner.nextLine();
        }
        return isbn;
    }

    public String validateEmail() {
        String email = null;
        while (email == null || email.isEmpty() || !isValidEmail(email)) {

            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email address. Please enter a valid email address.");
            }
        }
        return email;
    }

    public String validateString() {
        String input = null;
        while (input == null || input.isEmpty()) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Cannot be empty. Please enter it again.");
            }
        }
        return input;
    }

    private boolean isValidEmail(String email) {
        // Regular expression pattern to validate email addresses
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(pattern);
    }

    public int validateNumber() {
        String input = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            number = validateNumber();
        }
        return number;
    }

    public void listBooksWithAuthor() {
        List<Author> authorsList = library.getAllAuthors();
        System.out.println("");
        System.out.println(COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE + " Here is your list of books : " + COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE);
        System.out.println("");
        System.out.println("");
        System.out.printf(COLOR_BLUE + "%-17s   %-20s   %-10s   %-8s   %-20s   %-20s   %n", "Book ISBN", "Book Title", "Category", "Quantity", "Author name", "Author email" + COLOR_RESET);
        for (Author a : authorsList) {
            System.out.printf("%-17s   %-20s   %-10s   %-8d   %-20s   %-20s   %n", a.getPublishedBook().getIsbn(), a.getPublishedBook().getTitle(), a.getPublishedBook().getCategory(), a.getPublishedBook().getQuantity(), a.getName(), a.getEmail());
        }
        System.out.println("");
        System.out.println("");

    }

    public void searchBookByCategory() {
        String filter = "category";
        searchByString(filter);
    }

    public void searchBookByTitle() {
        String filter = "title";
        searchByString(filter);
    }

    public void searchBookByAuthor() {
        String filter = "author";
        searchByString(filter);
    }

    public void searchByString(String str) {
        String param;
        Book spawnedBook = null;
        List<Book> bookList = new ArrayList<Book>();
        if (str == "title") {
            System.out.println("Enter title :");
            param = validateString();
            spawnedBook = library.getBookByTitle(param);

        } else if (str == "author") {
            System.out.println("Enter Author Name :");
            param = validateString();
            spawnedBook = library.getBookByAuthor(param);

        } else {
            System.out.println("Enter category :");
            param = validateString();
            bookList = library.getBookByCategory(param);
        }

//        SI ENCUENTRA EL BOOK
        if (spawnedBook != null) {
            System.out.println("");
            System.out.println("We found your book! " + COURSE_IMAGE);
            System.out.println("");
            System.out.println("");
            System.out.printf(COLOR_BLUE + "%-17s  %-20s   %-10s   %-8s   %n", "Book ISBN", "Book Title", "Category", "Quantity" + COLOR_RESET);
            System.out.printf("%-17s  %-20s   %-10s   %-8s   %n", spawnedBook.getIsbn(), spawnedBook.getTitle(), spawnedBook.getCategory(), spawnedBook.getQuantity());
            System.out.println("");
            System.out.println("");
//        SI NO ENCUENTRA EL BOOK
        } else if (str == "category" && bookList != null) {
            System.out.println("");
            System.out.println(COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE + " Here is your list of books : " + COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE);
            System.out.println("");
            System.out.println("");
            System.out.printf(COLOR_BLUE + "%-17s  %-20s   %-10s   %-8s   %n", "Book ISBN", "Book Title", "Category", "Quantity" + COLOR_RESET);
            for (Book b : bookList) {
                System.out.printf("%-17s  %-20s   %-10s   %-8s   %n", b.getIsbn(), b.getTitle(), b.getCategory(), b.getQuantity());
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------Oops! We didn't find your book " + SAD_FACE + "------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("");
        }
    }

    public void issueBook() {
        String usn;
        String studentName;
        String issueDate;
        String returnDate;
        String isbn;
        Book book;

        System.out.println("Enter usn: ");
        usn = validateString();
        System.out.println("Enter student name: ");
        studentName = validateName();
        System.out.println("Enter issue date: ");
        issueDate = validateString();
        System.out.println("Enter return date: ");
        returnDate = validateString();
        System.out.println("Enter ISBN: ");
        isbn = validateBook();
        book = library.getBookById(isbn);
        Student stu = new Student(usn, studentName);
        library.insertStudent(stu);
        Issue issue = new Issue(issueDate, returnDate, stu, book);
        library.insertIssue(issue);
        System.out.println(issue);

        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------Great job! We have issued your book! " + COURSE_IMAGE + "-------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");

    }

    public void listBooksByStudentNumber() {
        String usn;
        System.out.println("Enter usn: ");
        usn = validateString();
        List<Issue> issueList = library.findIssueByStudentNumber(usn);
        if(issueList!=null){
            System.out.println("");
            System.out.println(COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE + " Here is your list of books : " + COURSE_IMAGE + COURSE_IMAGE + COURSE_IMAGE);
            for (Issue issue : issueList){
                System.out.println("");
                System.out.println("");
                System.out.printf(COLOR_BLUE + "%-20s   %-15s   %-10s   %n", "Book Title", "Student Name", "Return Date" + COLOR_RESET);
                System.out.printf("%-20s   %-15s   %-10s   %n", issue.getIssueBook().getTitle(), issue.getIssueStudent().getName(), issue.getReturnDate());
            }
            System.out.println("");
            System.out.println("");
        }else{
            System.out.println(COLOR_RED+"Error! There is no student matching that usn. Try again..."+COLOR_RESET);
            listBooksByStudentNumber();
        }
    }
    public void exit() throws InterruptedException {
        exit=true;
        scanner.close();
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Process finished.");
        System.out.println("");
        Thread.sleep(1000);
        System.out.println(COLOR_PURPLE+"  _______   ______     ______    _______  .______   ____    ____  _______ \n" +
                " /  _____| /  __  \\   /  __  \\  |       \\ |   _  \\  \\   \\  /   / |   ____|\n" +
                "|  |  __  |  |  |  | |  |  |  | |  .--.  ||  |_)  |  \\   \\/   /  |  |__   \n" +
                "|  | |_ | |  |  |  | |  |  |  | |  |  |  ||   _  <    \\_    _/   |   __|  \n" +
                "|  |__| | |  `--'  | |  `--'  | |  '--'  ||  |_)  |     |  |     |  |____ \n" +
                " \\______|  \\______/   \\______/  |_______/ |______/      |__|     |_______|");
    }

}
