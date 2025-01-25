package com.lld.designproject.blockingqueue;

public class BlockingQueue<T> {
    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void enQueue(T item) throws InterruptedException {
        synchronized (this) {
            while (size == capacity) {
                wait();
            }
            if (tail == capacity) {
                tail = 0;
            }
            array[tail] = item;
            tail++;
            size++;
            notifyAll();
        }
    }

    public T deQueue() throws InterruptedException {
        T item;
        synchronized (this) {
            while (size == 0) {
                wait();
            }

            if (head == capacity) {
                head = 0;
            }
             item = array[head];
            array[head] = null;
            head++;
            size--;
            notifyAll();
        }
        return item;

    }

}
