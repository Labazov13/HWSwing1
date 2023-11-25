package org.example;

public class ServerSetting implements ServerListener{
    boolean isServerWork;
    private final ListenerInterface listener;

    public ServerSetting(ListenerInterface listener) {
        this.listener = listener;
        this.isServerWork = false;
    }
    public void startServer(){
        if(!isServerWork){
            isServerWork = true;
            listener.messageResult("Server " + isServerWork);
        }
        else{
            listener.messageResult("I am already run");
        }
    }
    public  void stopServer(){
        if(isServerWork){
            isServerWork = false;
            listener.messageResult("Server " + isServerWork);
        }
        else{
            listener.messageResult("I am already stop");
        }
    }

    @Override
    public void serverListener(boolean state) {
        if(state){
            stopServer();
        }
        else {
            startServer();
        }
    }
}
