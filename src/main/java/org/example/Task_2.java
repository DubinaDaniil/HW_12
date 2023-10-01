package org.example;

import java.util.*;

public class Task_2 {

    List<String> result = new ArrayList<>();
    final Object sync = new Object();
    static int counter = 1;
    int value;

    public Task_2(final int value) {
        this.value = value;
    }

    public static void increment() {
        counter++;
    }

    public void run() {
        new Thread(() -> {
            synchronized (sync) {
                while (counter <= value) {
                    if (!(counter % 3 == 0 && counter % 5 == 0) && counter % 3 == 0) {
                        result.add("fizz");
                        increment();
                        sync.notifyAll();
                    } else {
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            System.out.println(result);
        }).start();
        new Thread(() -> {
            synchronized (sync) {
                while (counter <= value) {
                    if (!(counter % 3 == 0 && counter % 5 == 0) && counter % 5 == 0) {
                        result.add("buzz");
                        increment();
                        sync.notifyAll();
                    } else {
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (sync) {
                while (counter <= value) {
                    if (counter % 3 == 0 && counter % 5 == 0) {
                        result.add("fizzBuzz");
                        increment();
                        sync.notifyAll();
                    } else {
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (sync) {
                while (counter <= value) {
                    if (counter % 3 != 0 && counter % 5 != 0) {
                        result.add(String.valueOf(counter));
                        increment();
                        sync.notifyAll();
                    } else {
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }
}
