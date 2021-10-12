package com.company;

public class RaT {
    public static void main(String[] args) {
        Thread1 turtle = (new Thread1("Черепаха", 1));
        Thread1 rabbit = (new Thread1("Кролик",3));
        turtle.start();
        rabbit.start();
    }
}