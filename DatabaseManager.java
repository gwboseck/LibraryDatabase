package hw1;

/*
 Sources: https://www.javaworld.com/article/2073352/core-java/simply-singleton.html
 */
public class DatabaseManager {

    private static DatabaseManager instance = null;

    protected DatabaseManager() {}

    public static DatabaseManager TheDatabaseManager () {
    //This function handles the singleton pattern
        if (instance == null) {
            instance = new DatabaseManager();
            System.out.println("Instance Created");
            /*We will only get the above output on the first call, each
            subsequent call will output the below print statement and return the
            already created instance*/
        } else {
            System.out.println("Previously Created instance returned");
        }
        return instance;
    }
}
