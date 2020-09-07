package com.message.bot.channel;

public class MesThread  extends Thread{
    public MesThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(1000L);
            System.out.println(GlobalVariables.TEXT);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
    }
}