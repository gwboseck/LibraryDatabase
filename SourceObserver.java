package hw1;

import java.util.*;

public class SourceObserver implements Observer{
  //A SourceObserver tracks books leaving a state


    private int hash;
    private String observerName;
    private List<LibraryBook> subjectList = new Vector<LibraryBook>(); //list to store books
    private List<LBState> stateList = new Vector<LBState>(); //list to store last observed state of book
    //indices of the lists align, so index 0 is the book and last observed state of the first book
    //index 1 is the book and last observed state of the 2nd book, etc.


    public SourceObserver(String name) {
        hash = name.hashCode();
        observerName = name;
    }

    public void Update(LibraryBook book) {
        LBState currentState;
        LBState sourceState;
        if(!(subjectList.contains(book))) {
            /*An observer cannot know what state the book was in before it started observing.
              Once it starts observing, and the book makes a state change it can begin accurately
              tracking the books state (until it is deattached) */
            System.out.println(observerName+" OBSERVED "+book.getBookName()+" LEAVING STATE: UNOBSERVED");
            subjectList.add(book);
            currentState = book.getState();
            stateList.add(currentState);
        } else {
            int listIndex = subjectList.indexOf(book);
            sourceState = stateList.get(listIndex);
            System.out.println(observerName+" OBSERVED "+book.getBookName()+" LEAVING STATE: "+sourceState);
            currentState = book.getState();
            stateList.set(listIndex,currentState);
        }
    }
    public String toString() {
        return Integer.toString(hash);
    }

    public String getName() {
        return observerName;
    }

}
