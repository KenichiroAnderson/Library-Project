package com.company;

public class NameAssemble {

    ServiceNum num;
    Name n;

    public void display(ServiceNum num, Name n){
        System.out.println("Name: " + n);
        System.out.println("Service Num: " + num);

    }


    // High copling exitsts within Name.java, ServiceNum.java
    // and NameAssemble.java
    // as these classes are High coupled due to their relationship
    // as if one element  is deleted then the other associated element
    // is deleted
}
