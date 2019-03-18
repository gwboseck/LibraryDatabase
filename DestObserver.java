package hw1;

public class DestObserver implements Observer{
    //A DestObserver tracks library books arriving at a new state

    private int hash;
    private String observerName;

    public DestObserver(String name) {
        hash = name.hashCode();
        observerName = name;
    }

    public void Update(LibraryBook book) {
        System.out.println(observerName+" OBSERVED "+book.getBookName()+" REACHING STATE: "+book.getState());
    }

    public String toString() {
        return Integer.toString(hash);
    }

    public String getName() {
        return observerName;
    }
}
