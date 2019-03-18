package hw1;

/**
 * Created by garrettboseck on 1/26/18.
 */
public interface Observer {
    public void Update(LibraryBook book);
    public String getName();
    public String toString();
}
