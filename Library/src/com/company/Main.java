package com.company;

import com.company.network.internet;
import ui.BookListFile;
import ui.MagazineListFile;
import ui.NewspaperListFile;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static Object ObservableMap;

    //ArrayList availableBookList = new ArrayList<ui>();
    public static void main(String[] args) throws  Exception {
        ObservableValue ov = new ObservableValue(0);
        TextObserver to = new TextObserver(ov);
        ov.addObserver(to);


        // scanner for the user keyboard input
        Scanner in = new Scanner(System.in);
        String Log;

        // ----------------------Important Arraylist initialisation
        // --------------------//
        ArrayList<Books> availableBookList = new ArrayList<Books>();
        ArrayList<Magazine> avalibleMagazines = new ArrayList<Magazine>();
        ArrayList<Newspaper> avalibleNewspaper = new ArrayList<Newspaper>();
        // Hash map for Password and username
        HashMap<String, String> Usersmap = new HashMap<>();
        //-------------------------------------------------------MyEYES!!!!---------------------------------------------
        // BookList try catch block
        try{
            File file = new File("\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\BookList.txt");
            if(file.canRead() == false){
                // goes to BookListFile.java
                throw new BookListFile();
            }
            System.out.println("File Found!");
        }catch (BookListFile e){

            System.out.println(e.getMessage());
        }finally{
            System.out.println("File: BookList");
        }
        //-------------------------------------------------------MyEYES!!!!---------------------------------------------
        //  MagazineFile try catch block
        try{
            File magfile = new File(
                    "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\MagazineList.txt");
            if(magfile.canRead() == false){
                // goes to MagazineListFile.java
                throw new MagazineListFile();
            }
            System.out.println("File Found!");
        }catch(MagazineListFile e){
            System.out.println("File not found");
        }finally{
            System.out.println("File: MagazineList");
        }
        //-------------------------------------------------------MyEYES!!!!---------------------------------------------
        //Newspaper try catch block
        try{
            File newsFile = new File(
                    "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Newspaper.txt");
            if(newsFile.canRead() == false){
                // goes to NewspaperListFile.java
                throw new NewspaperListFile();
            }
            System.out.println("File Found!");
        }catch(NewspaperListFile e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("File: NewspaperList");
        }
        //-------------------------------------------------------MyEYES!!!!---------------------------------------------
        // username and passsword text file:
        File Users = new File("\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Users.txt");
        // all text files for booklist, magazinelist, newspaper.
        File file = new File("\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\BookList.txt");
        File magfile = new File(
                "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\MagazineList.txt");
        File newsFile = new File(
                "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Newspaper.txt");
        Scanner scan = new Scanner(file);

        // looking to see if the file has anymore lines of words
        // if none then it finishes reading the file
        while (scan.hasNext()) {
            // grabbing the next line in the txt file and adding it to the arraylist
            String temp;
            temp = scan.nextLine();
            Books TempBook = new Books(temp, 1);
            availableBookList.add(TempBook);
        }

        Scanner magscan = new Scanner(magfile);
        // looking to see if the file has anymore lines of words
        // if none then it finishes reading the file
        while (magscan.hasNext()) {

            // grabbing the next line in the txt file and adding it to the arraylist
            String temp;
            temp = magscan.nextLine();
            Magazine tempMag = new Magazine(temp, 1);
            avalibleMagazines.add(tempMag);

        }

        Scanner newsscan = new Scanner(newsFile);

        // looking to see if the file has anymore lines of words
        // if none then it finishes reading the file
        while (newsscan.hasNext()) {
            // grabbing the next line in the txt file and adding it to the arraylist
            String temp;
            temp = newsscan.nextLine();
            Newspaper news = new Newspaper(temp, 1);
            avalibleNewspaper.add(news);

        }

        // Closing out the scanner for performance + no need for it
        scan.close();
        magscan.close();
        System.out.println("---------------Welcome to the Library project-------------");
        // continue function to constanly loop
        Boolean cont = true;
        while (cont) {
            cont = true;
            // Start of program:
            System.out.println("Please enter what you would like to do: ");
            System.out.println("| (1) Add a book            | (2) Sign Out a book       |  (3) Add a Magazine       |");
            System.out.println("| (4) Sign out a Magazine   | (5) Add a news paper      |  (6) Sign out a news paper|");
            System.out.println("| (7) See all the books     | (8) See all Magazines     |  (9) See all News paper   |");
            System.out.println("| (10) Sign up              | (11) Login                |  (12) Print Internet      |");

            // user input for start:
            int input = in.nextInt();
            in.nextLine();
            String temp;

            //FUNCTION: adding book to booklistArray, and Booklist.txt
            if (input == 1) {
                // opening a file writer to write to the txt file
                FileWriter Writer = new FileWriter(
                        "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\BookList.txt", true);
                BufferedWriter writeFileBuffer = new BufferedWriter(Writer);
                System.out.println("Enter the name of the book: ");
                temp = in.nextLine();
                System.out.println("Enter How many you are Adding");
                int amount = in.nextInt();

                // adding user inputed book to arraylist and txt file
                Books TempBook = new Books(temp, amount);
                availableBookList.add(TempBook);
                writeFileBuffer.newLine();
                writeFileBuffer.write(temp);

                TempBook.Welcome();

                writeFileBuffer.close();
            }


            // function to sign out a book (ie deincrement )
            // TODO!!! make function update the .txt file and decriment it
            if (input == 2) {
                System.out.println("Enter the name of the book");
                String book = in.nextLine();

                for (Books reqBook : availableBookList) {
                    if (reqBook.getBook().equals(book)) {
                        reqBook.signOut();
                        reqBook.Welcome();
                    }
                }
            }

            // FUNCTION: Adding a Magazine to both arraylist and the MagazineList.txt file.
            if (input == 3) {
                // opening a file writer to write to the txt file
                FileWriter Writer = new FileWriter(
                        "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\MagazineList.txt",
                        true);
                BufferedWriter writeFileBuffer = new BufferedWriter(Writer);
                System.out.println("Enter the name of the Magazine: ");
                temp = in.nextLine();
                System.out.println("Enter How many you are Adding");
                int amount = in.nextInt();

                // adding user inputed book to arraylist and txt file of MagazineList.txt
                Magazine tempMag = new Magazine(temp, amount);
                avalibleMagazines.add(tempMag);
                writeFileBuffer.newLine();
                writeFileBuffer.write(temp);

                tempMag.Welcome();

                writeFileBuffer.close();
            }

            // FUNCTION: to sign out a Magazine (ie deincrement )
            if (input == 4) {
                System.out.println("Enter the name of the Magazine");
                String mag = in.nextLine();

                for (Magazine magazine : avalibleMagazines) {
                    if (magazine.getBook().equals(mag)) {
                        magazine.signOut();
                        magazine.Welcome();
                    }
                }
            }

            if (input == 5) {
                // opening a file writer to write to the txt file
                FileWriter Writer = new FileWriter(
                        "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Newspaper.txt", true);
                BufferedWriter writeFileBuffer = new BufferedWriter(Writer);
                System.out.println("Enter the name of the newspaper: ");
                temp = in.nextLine();
                System.out.println("Enter How many you are Adding");
                int amount = in.nextInt();

                // adding user inputed book to arraylist and txt file of MagazineList.txt
                Newspaper tempnews = new Newspaper(temp, amount);
                avalibleNewspaper.add(tempnews);
                writeFileBuffer.newLine();
                writeFileBuffer.write(temp);
                tempnews.Welcome();
                writeFileBuffer.close();
            }
            // FUNCTION: to sign out a Newspaper (ie deincrement )
            if (input == 6) {
                System.out.println("Enter the name of the News paper");
                String news = in.nextLine();

                for (Newspaper tempnews : avalibleNewspaper) {
                    if (tempnews.getBook().equals(news)) {
                        tempnews.signOut();
                        tempnews.Welcome();
                    }
                }
            }

            // FUNCTION: that prints out whole list of books from the arraylist
            if (input == 7) {
                for (Object Books : availableBookList) {
                    System.out.println(Books.toString());
                }
            }
            // FUNCTION: Printing out all Magazines from the arraylist
            if (input == 8) {
                for (Object Magazine : avalibleMagazines) {
                    System.out.println(Magazine.toString());
                }
            }
            //Function: Printing out all Newspaper list from the arraylist
            if (input == 9) {
                for (Object Newspaper : avalibleNewspaper) {
                    System.out.println(Newspaper.toString());
                }
            }

            // adding user input for password and username into hashmap and text file
            if(input == 10){
                FileWriter userWrite = new FileWriter(
                        "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Users.txt", true);
                System.out.println("Enter a username: ");
                String user = in.nextLine();
                System.out.println("enter a password: ");
                String pass = in.nextLine();

                Usersmap.put(user, pass);
                BufferedWriter writeFileBuffer = new BufferedWriter(userWrite);
                writeFileBuffer.newLine();
                writeFileBuffer.write(user + ","+ pass);
                writeFileBuffer.close();

            }

            //Swing for GUI it is a framework

            //Login for username and password
            if(input == 11){
                // Reading text file password and username
                // the placing all contents into the hashmap, this works so when you close the
                // and reopen the program it puts all contents into the hashmap.
                try{
                    BufferedReader enter = new BufferedReader(new FileReader("\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Users.txt"));
                    String str;
                    while((str = enter.readLine()) != null){
                        String[] ar = str.split(",");
                       // System.out.println(ar[0]+ ":" + ar[1]);

                        for(int i = 0; i < ar.length; i+=2){
                            Usersmap.put(ar[i], ar[i+1]);
                           // Usersmap.get(ar[i]);
                        }

                    }
                }catch (IOException e){
                    System.out.println("File read error");
                }

                // actual part to check password and username to the ones in the Hashmap!
                System.out.println("Enter your username: ");
                String testUser = in.nextLine();
                if(Usersmap.containsKey(testUser)){
                    System.out.println("Enter your password: ");
                    String testPass = in.nextLine();
                    System.out.println("Enter your Service number: ");
                    int serv = in.nextInt();
                    if(Usersmap.containsValue(testPass)){
                        System.out.println("User: " + testUser + " has logged in successfully");
                        NameAssemble tempname = new NameAssemble();
                        Name n = new Name(testUser);
                        ServiceNum s = new ServiceNum(serv);
                        tempname.display(s, n);
                        // ObservableMap = new ObservableMap((Map) s);

                    }else{
                        // exit from failed pass attempt
                        System.out.println("incorect");
                    }
                }else {
                    // exit from failed user attempt
                    System.out.println("Thats not right Try again: ");
                }
            }

            if(input == 12){
                //prints from the internet, thx prof for saving me from making a website!
                // everything that accesses the internet is in internet.main();
                // probably should have done whole program like this but here we are
                internet.main();
            }


            if(input == 13 ){
                ov.setValue(1);
                ov.getValue();
                ov.deleteObserver(to);
            }

            System.out.println("Enter [1] to continue, [0] to exit");
            int leave = in.nextInt();
            if (leave == 1) {
                cont = true;
            } else {
                cont = false;
            }
            // PrintFile.close();
        }
        // exit of program
        System.out.println("Thank you for Visiting the Library");

    }
}
