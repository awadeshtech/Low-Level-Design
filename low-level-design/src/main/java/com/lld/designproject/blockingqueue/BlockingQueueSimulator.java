package com.lld.designproject.blockingqueue;

public class BlockingQueueSimulator {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<Integer>(5);
        Thread T1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    blockingQueue.enQueue(Integer.valueOf(i));
                    System.out.println("Enqued:" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread T2 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    System.out.println("dequeued:" + blockingQueue.deQueue());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread T3 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    System.out.println("dequeued:" + blockingQueue.deQueue());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        T1.start();
        Thread.sleep(4000);
        T2.start();
        T2.join();

        T3.start();
        T3.join();
        T1.join();
    }
}
