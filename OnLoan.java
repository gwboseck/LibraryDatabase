package hw1;

public class OnLoan implements LBState{
    private static OnLoan instance = null;

    protected OnLoan() {}

    public static OnLoan getInst() {
        if (instance == null) {
            instance = new OnLoan();
            System.out.println("OnLoan Instance Created");
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
        try {
            throw new NotAllowedException("borrow", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void extend(LibraryBook book) {
        book.changeState(OnLoan.getInst());
    }

    @Override
    public void returnBook(LibraryBook book) {
        book.changeState(Returned.getInst());
    }

    public String toString() {
        return ("OnLoan");
    }
}
