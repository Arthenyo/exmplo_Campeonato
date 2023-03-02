package main;

import persistence.JpaPersistence;

public class App {

    public static void main(String[]args){

        JpaPersistence jpaPersistence = new JpaPersistence();
        jpaPersistence.getEm().clear();
    }
}
