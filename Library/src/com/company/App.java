package com.company;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class App extends Container {
    private static JFrame frame;
    private JPanel panelMain;
    private JOptionPane ActionEvent;

    private JLabel Username;
    private JLabel Password;
    private JTextField txtUser;
    private JTextField txtPass;
    private JButton Login;
    private JButton Close;
    private JButton Reset;
    private JButton SignUp;


    public static void main(String[] args) {
        frame = new JFrame("App");
        frame.setBounds(100, 100, 450, 300);
        frame.setSize(100, 100);
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public App() {

        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String user = txtUser.getText();
                String pass = txtPass.getText();

                HashMap<String, String> Usersmap = new HashMap<String, String>();

                try {
                    FileWriter userWrite = new FileWriter(
                            "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Users.txt", true);
                    BufferedWriter writeFileBuffer = new BufferedWriter(userWrite);
                    writeFileBuffer.newLine();
                    writeFileBuffer.write(user + ","+ pass);
                    writeFileBuffer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(user.isBlank()== true){
                    JOptionPane.showMessageDialog(null, "You must Enter a Username!");
                }else{
                    JOptionPane.showMessageDialog(null, user + " has successfully signed up");

                }

                if(pass.isBlank() == true){
                    JOptionPane.showMessageDialog(null, "You must Enter a Password!");
                }else{
                    JOptionPane.showMessageDialog(null, "Your password is: "+pass);
                }

                if(user.isBlank()== false && pass.isBlank() == false){
                    Usersmap.put(user, pass);

                }

                txtUser.setText("");
                txtPass.setText("");

            }
        });



        //REQUIRES: ActionEvent
        //MODIFIES: txtUser, txtPass
        //EFFECTS:  waits for user input into both user and pass, if nothing is entered it asks again if stuff is entered then we print it back to the user
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String user = txtUser.getText();
                String pass = txtPass.getText();

                HashMap<String, String> Usersmap = new HashMap<String, String>();

                if(user.isBlank()== false && pass.isBlank() == false){
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
                    }catch (IOException ex){
                        System.out.println("File read error");
                    }
                }
                try {
                    FileWriter userWrite = new FileWriter(
                            "\\Users\\ander\\Desktop\\University 2021-2022\\COSC210\\Library\\src\\ui\\Users.txt", true);
                    BufferedWriter writeFileBuffer = new BufferedWriter(userWrite);
                    writeFileBuffer.newLine();
                    writeFileBuffer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }





                if(user.isBlank()== true){
                    JOptionPane.showMessageDialog(null, "You must Enter a Username!");
                }else{
                    JOptionPane.showMessageDialog(null, user + " has successfully logged in");

                }

               if(pass.isBlank() == true){
                   JOptionPane.showMessageDialog(null, "You must Enter a Password!");
               }else{
                   JOptionPane.showMessageDialog(null, "Your password is: "+pass);
               }

               if(user.isBlank()== false && pass.isBlank() == false){
                   if(Usersmap.containsKey(user) && Usersmap.containsValue(pass) ){
                       JOptionPane.showMessageDialog(null, "User:" + user + " Has logged in" );
                   }

               }

               txtUser.setText("");
               txtPass.setText("");

            }
        });


        //REQUIRES: ActionEvent
        //MODIFIES: txtUser, txtPass
        //EFFECTS:  when reset button pressed it clears the strings in both txtUser and txtPass
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                txtUser.setText("");
                txtPass.setText("");
            }
        });

        //REQUIRES: ActionEvent
        //MODIFIES: frame
        //EFFECTS:  if Close button is pressed it closes the JFrame
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
