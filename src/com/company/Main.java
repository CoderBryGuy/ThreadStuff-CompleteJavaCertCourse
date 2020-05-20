package com.company;

import static com.company.ThreadColor.ANSI_CYAN;
import static com.company.ThreadColor.ANSI_RED;

public class Main {



    public static void main(String[] args) {
	Task taskRunner1 = new Task("taskRunner1");
	Task taskRunner2 = new Task("taskRunner2");

	Thread t1 = new Thread(taskRunner1);
	Thread t2 = new Thread(taskRunner2);


	t1.start();
	t2.start();

    }
}

class Task implements Runnable {
    private String color;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);

        if(Thread.currentThread().getName().equals("taskRunner1")){
            color = ANSI_CYAN;
        }else {
            color = ANSI_RED;
        }

        for (int i = 0; i < 500; i++) {
            System.out.println(color + "number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}
