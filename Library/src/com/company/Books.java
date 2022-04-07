package com.company;

//import ui.book;

import java.util.Observable;

public  class Books extends book {

    //REQUIRES: a String of sorts, and an integer value
    //EFFECTS: returns the String and the int
    public Books(String book, int num){
        this.book = book;
        this.num = num;
    }
    //MODIFIES: this
    //EFFECTS: this updates with book
    public String getBook(){
        return book;
    }

    //MODIFIES: this
    //EFFECTS: this updates with int
    public int getNum(){
        return num;
    }

    //MODIFIES: this
    //EFFECTS: this updates with book
    public void setBook(String book){
        this.book = book;
    }
    //MODIFIES: this
    //EFFECTS: this updates with int
    public void setNum(int num){
        this.num = num;
    }
}