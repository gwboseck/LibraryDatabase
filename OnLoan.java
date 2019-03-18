package hw1;

public class OnLoan implements LBState{
    private static OnLoan instance = null;


    protected OnLoan() {}

    public static OnLoan getInst() {
        /*Concrete states are implemented as singletons because they maintain no
        local state, so they can be shared, and only one instance of each is
        required. Src p. 312 Gang of Four*/
        if (instance == null) {
            instance = new OnLoan();
            System.out.println("OnLoan Instance Created");
        }
        return instance;
    }
    @Override
    public void shelf(LibraryBook book) {
      //You can't shelf a book that is on loan
        try {
            throw new NotAllowedException("shelf", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void borrow(LibraryBook book) {
      //You can't borrow a book that is on loan
        try {
            throw new NotAllowedException("borrow", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void extend(LibraryBook book) {
      //You can extend a book that is on loan
        book.changeState(OnLoan.getInst());
    }

    @Override
    public void returnBook(LibraryBook book) {
      //You can return a book that is on loan
        book.changeState(Returned.getInst());
    }

    public String toString() {
        return ("OnLoan");
    }
}
