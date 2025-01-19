package prototyping.customDatabase.binaryDB;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PhoneBook {
    private static String FILE_NAME = "PhoneBookDatabase.dat";
    private static int NAME_LENGTH = 20;
    private static int PHONE_NUMBER_LENGTH = 15;
    private static int AGE_LENGTH = 3;
    private static int RECORD_LENGTH = (NAME_LENGTH + PHONE_NUMBER_LENGTH) * 2;

    public static void addNewRecord(Scanner scanner) throws IOException{
        System.out.println("Enter name : ");
        String name = scanner.nextLine();

        System.out.println("Enter phone number : ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter Age");
        String age = scanner.nextLine();

        String paddedName = addPaddings(name, NAME_LENGTH);
        String paddedPhoneNumber = addPaddings(phoneNumber, PHONE_NUMBER_LENGTH);
        String paddedAge = addPaddings(age, AGE_LENGTH);

        try(RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw")){
            file.seek(file.length());
            file.writeChars(paddedName);
            file.writeChars(paddedPhoneNumber);
            file.writeChars(paddedAge);
            System.out.println("New record added successfully");
        }   

    }

    private static String addPaddings(String field, int length){
        if(field.length() > length){
            return field.substring(0, length);
        }

        return String.format("%-"+ length + "s", field);
    }

    public static void viewAllRecords() throws IOException{
        try(RandomAccessFile file = new RandomAccessFile(FILE_NAME, "r")){
            if(file.length() == 0){
                System.out.println("PhoneBook is empty!");
                return;
            }

            file.seek(0);
            while(file.getFilePointer() < file.length()){
                String name = readFixedString(file, NAME_LENGTH);
                String phoneNumber = readFixedString(file, PHONE_NUMBER_LENGTH);
                String age = readFixedString(file, AGE_LENGTH);
                System.out.println("Name : " + name.trim() + " ," + "Phone Number : " + phoneNumber.trim() + ", Age : " + age);
            }
        }
    }

    public static String readFixedString(RandomAccessFile file, int length) throws IOException{
        char[] chars = new char[length];

        for(int i = 0; i < length; ++i){
            // Reads two bytes and convert them to char
            // And the file pointer is moved two bytes automatically
            chars[i] = file.readChar();
        }

        return new String(chars);
    }

    public static void addAgeForExistingRecords(Scanner scanner) throws IOException{
        try(RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw")){
            file.seek(0);

            while(file.getFilePointer() < file.length()){
                String name = readFixedString(file, NAME_LENGTH);
                String phoneNumber = readFixedString(file, PHONE_NUMBER_LENGTH);

                System.out.println("Enter Age for the following record :");
                System.out.println("Name : " + name + "Phone Number : " + phoneNumber);

                String age = scanner.nextLine();
                String paddedAge = addPaddings(age, AGE_LENGTH);

                long currFilePointer = file.getFilePointer();
                System.out.println("Initial file pointer : " + currFilePointer);

                System.out.println("Is the file pointer at end of file ? : " + (file.getFilePointer() == file.length() - 1));

                String dataAfterCurrentFilePointer = getDataAfterCurrentFilePointer(file);
                System.out.println("Data after the record before appending age : " + dataAfterCurrentFilePointer);
                file.seek(currFilePointer);
                file.writeChars(paddedAge);
                file.writeChars(dataAfterCurrentFilePointer);
                System.out.println("File pointer before appending age :" + file.getFilePointer());
                file.seek(currFilePointer + 2*AGE_LENGTH);
                System.out.println("File pointer after appending age :" + file.getFilePointer());
            }
        }
    }

    private static String getDataAfterCurrentFilePointer(RandomAccessFile file) throws IOException{
        String result = "";
        while(file.getFilePointer() < file.length()){
            result = result + String.valueOf(file.readChar());
        }

        return result;
    }

}
