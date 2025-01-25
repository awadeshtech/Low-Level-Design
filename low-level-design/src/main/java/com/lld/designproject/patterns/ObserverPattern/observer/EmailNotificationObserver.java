package com.lld.designproject.patterns.ObserverPattern.observer;

import com.lld.designproject.patterns.ObserverPattern.observable.StockObservable;

public class EmailNotificationObserver implements NotificationAlertObserver {
    private final String emailId;
    private final StockObservable stockObservable;

    public EmailNotificationObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendEmail(stockObservable.getStockCount());
    }

    private void sendEmail(int stockCount) {
        System.out.println("email send to :" + emailId + " current stock is " + stockCount);
    }
}
