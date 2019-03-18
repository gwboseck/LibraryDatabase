package hw1;

public class Shelved implements LBState{

    private static Shelved instance = null;

    protected Shelved() {}

    public static Shelved getInst() {
      /*Concrete states are implemented as singletons because they maintain no
      local state, so they can be shared, and only one instance of each is
      required. Src p. 312 Gang of Four*/
        if (instance == null) {
            instance = new Shelved();
            System.out.println("Shelved Instance Created");
        }
        return instance;
    }
    @Override
    public void shelf(LibraryBook book) {
      //You can't shelf a book that has been shelved
        try {
            throw new NotAllowedException("shelf", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void borrow(LibraryBook book) {
      //You can borrow a book that has been shelved
        book.changeState(OnLoan.getInst());
    }

    @Override
    public void extend(LibraryBook book) {
      //You can't extend a book that has been shelved
        try {
            throw new NotAllowedException("extend", instance.toString());
        } catch (NotAllowedException e) {}
    }

    @Override
    public void returnBook(LibraryBook book) {
      //You can't return a book tha has been shelved
        try {
            throw new NotAllowedException("returnBook", instance.toString());
        } catch (NotAllowedException e) {}
    }

    public String toString() {
        return ("Shelved");
    }
}
