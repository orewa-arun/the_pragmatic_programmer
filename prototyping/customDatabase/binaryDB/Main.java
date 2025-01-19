package prototyping.customDatabase.binaryDB;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        boolean again = true;

        do {
            System.out.println("Address Book Menu :");
            System.out.println("1. Enter a new record");
            System.out.println("2. View all Entries");
            System.out.println("3. Exit");
            System.out.println("4. Add age for existing records");
            System.out.println("Choose an option :");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    PhoneBook.addNewRecord(scanner);
                    break;
                case 2:
                    PhoneBook.viewAllRecords();
                    break;
                case 3:
                    again = false;
                    break;
                case 4:
                    PhoneBook.addAgeForExistingRecords(scanner);
                default:
                    System.out.println("Enter a valid choice");
            }
        } while (again);
    }
}
