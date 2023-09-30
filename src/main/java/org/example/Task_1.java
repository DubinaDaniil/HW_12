package org.example;

public class Task_1 {
    int counter = 1;
    Thread thread1 = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Прошло секунд: %s\n", counter);
            System.out.println(Thread.currentThread().getName());
            counter++;
        }
    });
    Thread thread2 = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Прошло 5 секунд");
        }

    });

    public void startFirstTask() {
        thread1.start();
        thread2.start();
    }
}
