package hw1;

/*
 Sources: https://www.javaworld.com/article/2073352/core-java/simply-singleton.html
 */
public class DatabaseManager {

    private static DatabaseManager instance = null;

    protected DatabaseManager() {}

    public static DatabaseManager TheDatabaseManager () {
        if (instance == null) {
            instance = new DatabaseManager();
            System.out.println("Instance Created");
        } else {
            System.out.println("Previously Created instance returned");
        }
        return instance;
    }
}
