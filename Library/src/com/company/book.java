package com.company;

public abstract class book{
    String book;
    int num;


    /*  SignIn:
     *  MODIFIES: num - increases the counter within the Arraylist of Avalible books
     *  EFFECTS: increases the number of books within the Arraylist of books
     */
    public void signIn(){
        ++num;
        System.out.println(book + " has been Signed in");
    }
    /*  SignOut:
     *  MODIFIES: num - decreases the counter within the Arraylist of Avalible books
     *  EFFECTS: decreases the number of books within the Arraylist of books
     */
    public void signOut(){
        --num;
        System.out.println(book + " has been Signed out");
    }

    //EFFECTS: prints out book  and the num associated with it
    public void Welcome(){

        System.out.println(book + " [has] " + num + " [copies in the library]");
    }

    //public void String
    //EFFECTS: prints out book  and the num associated with it
    @Override
    public  java.lang.String toString() {
        return  "[Name:] " + book + "       [Stock:] " + num ;
        //return System.out.printf("Name: %d, amount: %s %n", num, book);
    }
}
interface bookInterface {
    //assumes that all things within them are abstarct
    void signIn();

    void signOut();

    void Welcome();
}
