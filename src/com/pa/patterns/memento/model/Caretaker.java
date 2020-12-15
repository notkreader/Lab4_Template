package com.pa.patterns.memento.model;

import java.util.Stack;

public class Caretaker {
    private Originator cartOriginator;
    private Stack<Memento> mementos;

    public Caretaker(ShoppingCart cart) {
        mementos = new Stack<>();
        cartOriginator = cart;
        saveState();
    }

    public void saveState() {
        mementos.push(cartOriginator.createMemento());
    }

    public void restoreState() {
        if(mementos.isEmpty())
            throw new NoMementoException("No memento");
        cartOriginator.setMemento(mementos.pop());
    }
}
