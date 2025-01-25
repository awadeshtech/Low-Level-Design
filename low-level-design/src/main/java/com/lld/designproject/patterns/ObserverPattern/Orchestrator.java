package com.lld.designproject.patterns.ObserverPattern;

import com.lld.designproject.patterns.ObserverPattern.observable.IphoneStockObservable;
import com.lld.designproject.patterns.ObserverPattern.observable.StockObservable;
import com.lld.designproject.patterns.ObserverPattern.observer.EmailNotificationObserver;
import com.lld.designproject.patterns.ObserverPattern.observer.NotificationAlertObserver;

public class Orchestrator {
    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneStockObservable();
        NotificationAlertObserver notificationAlertObserver1 = new EmailNotificationObserver("emailid1",stockObservable);
        NotificationAlertObserver notificationAlertObserver2 = new EmailNotificationObserver("emailid2", stockObservable);
        stockObservable.register(notificationAlertObserver1);
        stockObservable.register(notificationAlertObserver2);
        stockObservable.setStockCount(3);
        stockObservable.setStockCount(-3);
        stockObservable.setStockCount(10);
    }
}
