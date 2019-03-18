package hw1;

/**
 * Created by garrettboseck on 1/26/18.
 */
public interface Observer {
    //Interface forces classes which implement it to implement all methods within it
    public void Update(LibraryBook book);
    public String getName();
    public String toString();
}
