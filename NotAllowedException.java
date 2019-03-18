package hw1;

/**
 * Created by garrettboseck on 1/25/18.
 */
public class NotAllowedException extends Exception {
    public NotAllowedException(String method, String currentState) {
        System.out.println(NotAllowedException.class.getCanonicalName()+": Can't use "+method+" in "+currentState+" state");
    }
}
