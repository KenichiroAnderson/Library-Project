package ui;

public class BookListFile extends Exception {
    public BookListFile(){
        super("Magazine list file was found!");
    }
    public BookListFile(String message){
        super(message);
    }
}
