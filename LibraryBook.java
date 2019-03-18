package hw1;

import java.util.*;

/*
Sources:
-https://en.wikipedia.org/wiki/State_pattern#Java
-https://www.youtube.com/watch?v=MGEx35FjBuo
-https://www.ibm.com/developerworks/community/blogs/738b7897-cd38-4f24-9f05-48dd69116837/entry/declare_your_own_java_exceptions?lang=en

Context class for State pattern
*/

public class LibraryBook {
    private LBState state;
    private List<Observer> observers = new Vector<Observer>();
    private String bookName;

    public LibraryBook(String name) {
        //A library book is initialized with a given name, and a starting state of shelved
        bookName = name;
        state = Shelved.getInst();
    }

    protected void changeState(LBState newState) {
        System.out.println("Leaving State "+state.toString()+" for State "+newState.toString());
        if(state == newState) {
            state = newState;
        } else {
            state = newState;
            Notify();
            /*All attached observers are notified of state changes here */
        }
    }

    public void shelf() {
        state.shelf(this);
    }

    public void borrow() {
        state.borrow(this);
    }

    public void extend() {
        state.extend(this);
    }

    public void returnBook() {
        state.returnBook(this);
    }

    public LBState getState() {
        return state;
    }

    public void attach(Observer o) {
        observers.add(o);
        System.out.println(o.getName()+" is now watching "+this.getBookName());

    }

    public void detach(Observer o) {
        if(!(observers.isEmpty())){
            observers.remove(o);
            System.out.println(o.getName()+" is no longer watching "+this.getBookName());
        }
    }

    private void Notify() {
        Iterator<Observer> notifyIterator = observers.iterator();
        while (notifyIterator.hasNext()) {
            notifyIterator.next().Update(this);
        }
    }

    public String getBookName() {
        return bookName;
    }

}
