package hw1;

public class Returned implements LBState {
    private static Returned instance = null;

    protected Returned() {}

    public static Returned getInst() {
        if (instance == null) {
            instance = new Returned();
            System.out.println("Returned Instance Created");
        }
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) {
        book.changeState(Shelved.getInst());
    }

    @Override
    public void borrow(LibraryBook book) {
        try {
            throw new NotAllowedException("borrow", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void extend(LibraryBook book) {
        try {
            throw new NotAllowedException("extend", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void returnBook(LibraryBook book) {
        try {
            throw new NotAllowedException("returnBook", instance.toString());
        } catch (NotAllowedException e) {}
    }

    public String toString() {
        return ("Returned");
    }
}
