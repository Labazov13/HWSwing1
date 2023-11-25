package org.example.task2_developers;

public class BackendDev extends Developer implements BackendAction{
    @Override
    public void back() {
        System.out.println("Write server code");
    }
}
