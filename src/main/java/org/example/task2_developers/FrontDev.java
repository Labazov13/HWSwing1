package org.example.task2_developers;

public class FrontDev extends Developer implements FrontAction{
    @Override
    public void frontAction() {
        System.out.println("Write front code");
    }
}
