package hw1;

public class Shelved implements LBState{

    private static Shelved instance = null;

    protected Shelved() {}

    public static Shelved getInst() {
        if (instance == null) {
            instance = new Shelved();
            System.out.println("Shelved Instance Created");
        }
        return instance;
    }
    @Override
    public void shelf(LibraryBook book) {
        try {
            throw new NotAllowedException("shelf", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void borrow(LibraryBook book) {
        book.changeState(OnLoan.getInst());
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
        return ("Shelved");
    }
}
