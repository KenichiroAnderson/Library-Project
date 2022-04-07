package ui;

public class MagazineListFile extends Exception{

    public MagazineListFile(){
        super("Magazine list file was found!");
    }
    public MagazineListFile(String message){
        super(message);
    }

}