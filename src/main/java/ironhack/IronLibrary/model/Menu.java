package ironhack.IronLibrary.model;

import java.util.Scanner;

public class Menu {
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
        while(exit==false){
            displayMenu();
            executeCommands(introduceCommand());
        }
    }
    public void greeting() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(COLOR_PURPLE+ironlibraryLogo+COLOR_RESET);
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------Welcome to Ironlibrary! Let's begin "+COURSE_IMAGE+"---------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        Thread.sleep(1000);
    }
    private void displayMenu() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println(COLOR_GREEN + "╔════════════════════════════════════════════════════╗");
        System.out.println("║        " + "               MENU                " + "         ║");
        System.out.println("╠════════════════════════════════════════════════════╣" );
        System.out.println("║ " + "1. Add a book"+ "                                      ║");
        System.out.println("║ "  + "2. Search book by title" + " " + "                           ║" );
        System.out.println("║ "  + "3. Search book by category" + "                         " + "║" );
        System.out.println("║ "  + "4. Search book by Author" + "                       " + "    ║" );
        System.out.println("║ "  + "5. List all books along with author" +  "                " + "║" );
        System.out.println("║ " + "6. Issue book to student" + "                           " + "║" );
        System.out.println("║ " +  "7. List books by usn" +  "                               " + "║" );
        System.out.println("║ " + "8. Exit" + "                     " +"                       ║");
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
        if(command==1){
              addBook();
        }else if(command==2){
                searchBookByTitle();
        }else if(command==3){
            searchBookByCategory();
        }else if(command==4){
            searchBookByAuthor();
        }else if(command==5){
            listBooksWithAuthor();
        }else if(command==6){
//            issueBook();
        }else if(command==7){
//            listBooks();
        }else if(command==8){
//            exit();
        }else{
            System.out.println("Please enter one of the possible available commands: 1, 2, 3...8");
            executeCommands(introduceCommand());
        }
    }

    public void listBooksWithAuthor(){
        System.out.println("");
        System.out.println(COURSE_IMAGE+COURSE_IMAGE+COURSE_IMAGE+" Here is your list of books : "+COURSE_IMAGE+COURSE_IMAGE+COURSE_IMAGE);
        System.out.println("");
        System.out.println("Title: The Notebook");
        System.out.println("Category: Romance");
        System.out.println("Author: Rocio Salgado");
        System.out.println("");

    }
    public void searchBookByCategory(){
        String filter = "category";
        searchByString(filter);
    }
    public void searchBookByTitle(){
        String filter = "title";
        searchByString(filter);
    }

    public void searchBookByAuthor(){
        String filter = "author";
        searchByString(filter);
    }

    public void searchByString(String str){
        String param;
        if(str=="title"){
            System.out.println("Enter title :");
        }else if(str=="author"){
            System.out.println("Enter Author Name :");
        }else{
            System.out.println("Enter category :");
        }
        param=validateString();
//        SI ENCUENTRA EL BOOK
        System.out.println("");
        System.out.println("We found your book! "+COURSE_IMAGE);
        System.out.println("");
        System.out.println("Title: The Notebook");
        System.out.println("Category: Romance");
        System.out.println("Author: Rocio Salgado");
//        SI NO ENCUENTRA EL BOOK
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------Oops! We didn't found your book " + SAD_FACE+ "------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
    }
    public void addBook(){
        String isbn;
        String title;
        String category;
        String authorName;
        int numberOfBooks;
        System.out.println("Enter isbn :");
        isbn=validateString();
        System.out.println("Enter title :");
        title=validateString();
        System.out.println("Enter category :");
        category=validateString();
        System.out.println("Enter Author name :");
        authorName=validateName();
        String email=validateEmail();
        System.out.println("Enter number of books :");
        numberOfBooks=validateNumber();
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------Great job! We have added your book to our database! "+COURSE_IMAGE+"-------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    public String validateName(){
        String name = null;
        while (name == null || name.isEmpty()) {
            System.out.println("(minimum of 2 words, letters only)");
            name = scanner.nextLine();
            if (!isValidName(name)) {
                System.out.println("Invalid name. Please enter a name with only letters and at least two words.");
                name = "";
            }
        }return name;
    }

    private boolean isValidName(String name) {
        return name.matches("^[A-Za-z]+(\\s[A-Za-z]+)+$");
    }
    public String validateEmail() {
        String email = null;
        while (email == null || email.isEmpty() || !isValidEmail(email)) {
            System.out.println("Enter Author mail:");
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
}
