package com.lld.designproject.blockingqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
            Map<Integer, Integer> map = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (tail == capacity) {
                    tail = 0;
                }
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

    class CustomerLog {
        private String id;
        private Integer timeStamp;

        private Integer pageId;

        public CustomerLog(String id, Integer timeStamp, Integer pageId) {
            this.id = id;
            this.timeStamp = timeStamp;
            this.pageId = pageId;
        }


        public String getId() {
            return id;
        }

        public Integer getTimeStamp() {
            return timeStamp;
        }

        public Integer getPageId() {
            return pageId;
        }
    }

    class Metric {
        Set<Integer> timeStamps;
        Set<Integer> pageIds;


        public Metric(Set<Integer> timeStamps, Set<Integer> pageIds) {
            this.timeStamps = timeStamps;
            this.pageIds = pageIds;
        }

        public Set<Integer> getTimeStamps() {
            return timeStamps;
        }

        public Set<Integer> getPageIds() {
            return pageIds;
        }
    }

    private List<String> getLoyalCustomers(List<CustomerLog> logFile1, List<CustomerLog> logFile2) {
        List<String> loyalCustomers = new ArrayList<>();

        Map<String, Metric> customerIdToMetricMap = new HashMap<>();

        for (CustomerLog customerLog : logFile1) {
            if (customerIdToMetricMap.containsKey(customerLog.getId())) {
                Metric metric = customerIdToMetricMap.get(customerLog.getId());
                metric.getPageIds().add(customerLog.getPageId());
                customerIdToMetricMap.put(customerLog.getId(), metric);
            } else {
                Set<Integer> pages = new HashSet<>();
                pages.add(customerLog.getPageId());

                Set<Integer> timestamps = new HashSet<>();
                timestamps.add(customerLog.getTimeStamp());
                Metric metric = new Metric(timestamps, pages );
                customerIdToMetricMap.put(customerLog.getId(), metric);
            }
        }

        for(CustomerLog customerLog : logFile2){
            if (customerIdToMetricMap.containsKey(customerLog.getId())) {
                Metric metric = customerIdToMetricMap.get(customerLog.getId());
                metric.getPageIds().add(customerLog.getPageId());
                if(metric.getPageIds().size() >=2){
                    loyalCustomers.add(customerLog.getId());
                }
            }
        }
      return loyalCustomers;
    }


}




