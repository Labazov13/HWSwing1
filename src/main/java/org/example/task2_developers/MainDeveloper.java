package org.example.task2_developers;

public class MainDeveloper {
    public static void main(String[] args) {
        Developer dev = new FrontDev();
        if (dev instanceof FrontAction){
            ((FrontDev) dev).frontAction();
        }
    }
}
