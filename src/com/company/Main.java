package com.company;

import My.ParcerMy;

public class Main {

    public static void main(String[] args) {

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread1 = new Thread(task);
        thread1.start();

//        ParcerMy  parcerMy1 = new ParcerMy( "1", "C:\\Users\\admin\\IdeaProjects\\parcFile\\read1.txt");
//        Thread newThread1 = new Thread(parcerMy1);
//        newThread1.start();
//
//        ParcerMy parcerMy2 = new ParcerMy("2", "C:\\Users\\admin\\IdeaProjects\\parcFile\\read2.txt");
//        Thread newThread2 = new Thread(parcerMy2);
//        newThread2.start();
//
//        ParcerMy parcerMy3 = new ParcerMy("3", "C:\\Users\\admin\\IdeaProjects\\parcFile\\read3.txt");
//        Thread newThread3 = new Thread(parcerMy3);
//        newThread3.start();

        if (!parcerMy2.isBreakAllThreads())
            System.out.println("full "+parcerMy2.getSum());
        else
            System.out.println("Потоки прерваны с ошибкой - нечисловые символы!");
    }
}
