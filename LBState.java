package hw1;

public interface LBState {
    void shelf(LibraryBook book);
    void borrow(LibraryBook book);
    void extend(LibraryBook book);
    void returnBook(LibraryBook book);
    String toString();
}
