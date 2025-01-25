package com.lld.designproject.patterns.ObserverPattern.observable;

import com.lld.designproject.patterns.ObserverPattern.observer.NotificationAlertObserver;

public sealed interface StockObservable permits IphoneStockObservable {
    public void register(NotificationAlertObserver notificationAlertObserver);
    public void unRegister(NotificationAlertObserver notificationAlertObserver);

    public void notifySubscribers();

    public int getStockCount();
    public void setStockCount(int stockCountToBeAdded);

}
