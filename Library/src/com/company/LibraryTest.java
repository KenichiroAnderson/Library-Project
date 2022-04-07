package com.company;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTest { // @Before
    // public void setup(){

    // }
    // SignIn test
    @org.junit.jupiter.api.Test
    public void testSignIn() {
        Books b = new Books("Diary of a Wimpy Kid", 1);
        Books b1 = new Books("Diary of a Wimpy Kid Rodrick rules", 1);
        Magazine m = new Magazine("Cottage life, Alaska", 500);
        Magazine m1 = new Magazine("Cottage life Hawaii", 3);
        b1.toString();
        // b.Welcome();
        // b1.Welcome();
        b.signIn();
        b1.signIn();
        m.signIn();
        m1.signIn();
        System.out.println("---------------------------");
    }
    // SignOut test
    @org.junit.jupiter.api.Test
    public void testSignOut() {
        System.out.println("---------------------------");
        Books b2 = new Books("Diary of a Wimpy Kid The Last Straw", 1);
        Books b3 = new Books("Diary of a Wimpy Kid Dog Days", 1);
        Magazine m = new Magazine("Cottage life, Alaska", 50);
        Magazine m1 = new Magazine("Cottage life Hawaii", 3);

        b2.Welcome();
        b3.Welcome();
        b2.signOut();
        b3.signOut();
        m.signOut();
        m1.signOut();
    }

    // TEST class for Arraylist and making sure we can access the file
    @org.junit.jupiter.api.Test
    public void TestFileBook() throws FileNotFoundException {
        ArrayList<Books> availableBookList = new ArrayList<Books>();
        File file = new File("\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\BookList.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {

            // grabbing the next line in the txt file and adding it to the arraylist
            String temp;
            temp = scan.nextLine();
            Books TempBook = new Books(temp, 1);
            availableBookList.add(TempBook);

        }
        scan.close();

        for (Object Books : availableBookList) {
            System.out.println(Books.toString());
        }
    }

    // Test class For arraylist and acess to file
    @org.junit.jupiter.api.Test
    public void TestFileMagazine() throws FileNotFoundException {
        ArrayList<Magazine> avalibleMagazines = new ArrayList<Magazine>();
        File magfile = new File(
                "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Newspaper.txt");
        Scanner magscan = new Scanner(magfile);
        while (magscan.hasNext()) {
            // grabbing the next line in the txt file and adding it to the arraylist
            String temp;
            temp = magscan.nextLine();
            Magazine tempMag = new Magazine(temp, 1);
            avalibleMagazines.add(tempMag);
        }
        magscan.close();
        for (Object Magazine : avalibleMagazines) {
            System.out.println(Magazine.toString());
        }

    }

}
