package ironhack.IronLibrary.model;

import java.util.Scanner;

public class Menu {
    private Boolean exit = false;
    Scanner scanner = new Scanner(System.in);
    private String ironlibraryLogo = " __  .______        ______   .__   __.  __       __  .______   .______          ___      .______     ____    ____ \n" +
            "|  | |   _  \\      /  __  \\  |  \\ |  | |  |     |  | |   _  \\  |   _  \\        /   \\     |   _  \\    \\   \\  /   / \n" +
            "|  | |  |_)  |    |  |  |  | |   \\|  | |  |     |  | |  |_)  | |  |_)  |      /  ^  \\    |  |_)  |    \\   \\/   /  \n" +
            "|  | |      /     |  |  |  | |  . `  | |  |     |  | |   _  <  |      /      /  /_\\  \\   |      /      \\_    _/   \n" +
            "|  | |  |\\  \\----.|  `--'  | |  |\\   | |  `----.|  | |  |_)  | |  |\\  \\----./  _____  \\  |  |\\  \\----.   |  |     \n" +
            "|__| | _| `._____| \\______/  |__| \\__| |_______||__| |______/  | _| `._____/__/     \\__\\ | _| `._____|   |__|";
    public static final String COURSE_IMAGE = "📚";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";

    public static final String COLOR_WHITE = "\u001B[37m";

    public void userInteraction() throws InterruptedException {
        greeting();
        displayMenu();
        introduceCommand();
    }
    public void greeting() throws InterruptedException {
        Thread.sleep(1000);
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
    public String introduceCommand() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("Enter a command:");
        String command = scanner.nextLine();
        return command;
    }
    public void executeCommands(String command) {
        if(command=="1"){
//              addABook();
        }else if(command=="2"){
//                searchBookByTitle();
        }
    }
}
