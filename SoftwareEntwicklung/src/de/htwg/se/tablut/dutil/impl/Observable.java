package de.htwg.se.tablut.dutil.impl;


import java.util.ArrayList;
import java.util.List;

import de.htwg.se.tablut.dutil.Event;
import de.htwg.se.tablut.dutil.IObservable;
import de.htwg.se.tablut.dutil.IObserver;

public class Observable implements IObservable {
/* Fields */
    private List<IObserver> subscribers = new ArrayList<IObserver>(2);

/* Methods */
    @Override
    public void addObserver(IObserver s) {
        subscribers.add(s);
    }

    @Override
    public void removeObserver(IObserver s) {
        subscribers.remove(s);
    }

    @Override
    public void removeAllObservers() {
        subscribers.clear();
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Event e) {
        for (IObserver observer: subscribers) {
            observer.update(e);
        }
    }
}