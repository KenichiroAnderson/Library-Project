package ui;

public class   NewspaperListFile extends Exception{

    public NewspaperListFile(){
        super("Magazine list file was not found!");
    }
    public NewspaperListFile(String message){
        super(message);
    }
}
