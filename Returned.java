package hw1;

public class Returned implements LBState {
    private static Returned instance = null;

    protected Returned() {}

    public static Returned getInst() {
      /*Concrete states are implemented as singletons because they maintain no
      local state, so they can be shared, and only one instance of each is
      required. Src p. 312 Gang of Four*/
        if (instance == null) {
            instance = new Returned();
            System.out.println("Returned Instance Created");
        }
        return instance;
    }

    @Override
    public void shelf(LibraryBook book) {
      //You can shelf a book that has been returned
        book.changeState(Shelved.getInst());
    }

    @Override
    public void borrow(LibraryBook book) {
      //You can't borrow a book that has been returned (it has not yet been shelved)
        try {
            throw new NotAllowedException("borrow", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void extend(LibraryBook book) {
      //You can't extend a book that has been returned
        try {
            throw new NotAllowedException("extend", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void returnBook(LibraryBook book) {
      //You can't return a book that has been returned
        try {
            throw new NotAllowedException("returnBook", instance.toString());
        } catch (NotAllowedException e) {}
    }

    public String toString() {
        return ("Returned");
    }
}
