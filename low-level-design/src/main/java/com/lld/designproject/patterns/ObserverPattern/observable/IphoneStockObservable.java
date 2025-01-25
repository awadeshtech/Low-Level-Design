package com.lld.designproject.patterns.ObserverPattern.observable;

import com.lld.designproject.patterns.ObserverPattern.observer.NotificationAlertObserver;
import java.util.ArrayList;
import java.util.List;

 public final class  IphoneStockObservable implements StockObservable {
    List<NotificationAlertObserver> notificationAlertObserverList;
    private int stockCount;

    public IphoneStockObservable() {
        notificationAlertObserverList = new ArrayList<>();
        stockCount = 0;
    }

    @Override
    public void register(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void unRegister(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        notificationAlertObserverList.forEach(observer -> observer.update());

    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void setStockCount(int stockCountToBeAdded) {
        if (stockCount == 0) {
            stockCount += stockCountToBeAdded;
            notifySubscribers();
        } else {
            stockCount += stockCountToBeAdded;
        }
    }
}
