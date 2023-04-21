package org.multithread;

public class ThreadWithExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        ThreadWithExample thread = new ThreadWithExample();
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("exception happened " + e);
        }
        System.out.println("thread finished...");
    }
}
