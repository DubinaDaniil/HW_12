package org.example;

import java.util.*;

public class Task_2 {
    static int counter = 1;
    int value;
    List<String> result = new ArrayList<>();
    List<Thread> threads = new ArrayList<>();

    public Task_2(final int value) {
        this.value = value;
    }

    Thread thread1 = new Thread(() -> {
        while (counter <= value) {
            if (counter % 3 == 0) {
                result.add("fizz");
                increment();
            }
        }
    });
    Thread thread2 = new Thread(() -> {
        while (counter <= value) {
            if (counter % 5 == 0) {
                result.add("buzz");
                increment();
            }
        }
    });
    Thread thread3 = new Thread(() -> {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                result.add("fizzBuzz");
                increment();
            }
        }
    });
    Thread thread4 = new Thread(() -> {
        while (counter <= value) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                result.add(String.valueOf(counter));
                increment();
            }
        }
    });

    public static synchronized void increment() {
        counter++;
    }


    public void run() throws InterruptedException {
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(result);
    }

//    public synchronized void fizz() throws InterruptedException {
//        while (counter < value) {
//            if (counter % 3 == 0) {
//                result.add("fizz");
//                System.out.println("fizz");
//                notifyAll();
//            } else {
//                wait();
//            }
//        }
//    }
//
//    public synchronized void buzz() throws InterruptedException {
//        while (counter < value) {
//            if (counter % 5 == 0) {
//                result.add("buzz");
//                System.out.println("buzz");
//                notifyAll();
//            } else {
//                wait();
//            }
//        }
//    }
//
//    public synchronized void fizzBuzz() throws InterruptedException {
//        while (counter < value) {
//            if (counter % 3 == 0 || counter % 5 == 0) {
//                result.add("fizzBuzz");
//                System.out.println("fizzBuzz");
//                notifyAll();
//            } else {
//                wait();
//            }
//        }
//    }
//
//    public synchronized void number() throws InterruptedException {
//        while (counter < value) {
//            if (counter % 3 != 0 && counter % 5 != 0) {
//                result.add(String.valueOf(counter));
//                System.out.println(counter);
//                notifyAll();
//            } else {
//                wait();
//            }
//        }
//    }
}
