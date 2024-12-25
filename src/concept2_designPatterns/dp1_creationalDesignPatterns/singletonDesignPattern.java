/*
 *  Singleton Method Design Pattern
 *      - It is used when we have to create only one instance of the class.
 *      - It guarantees that a class has just one instance and offers a way to access it globally.
 * 
 * Ex:
 *      Data Base Connection.
 * 
 *  No of ways to acchive this:
 *      - Eager
 *      - Lazy
 *      - Synchronized method
 *      - Double locking(Industry Standard)
 */

// Eager Initilization.
class Db1Connection {
    // creating static var, which is available for only class.
    // Eagerly Initilizing, when the class is created or loaded.
    private static Db1Connection conObj = new Db1Connection();

    private Db1Connection() {
    }

    public static Db1Connection getInstance() {
        return conObj;
    }

    void check() {
        System.out.println("DB1 Connected.");
    }
}

// Lagy Initilization.
class Db2Connection {
    private static Db2Connection conObj;

    private Db2Connection() {
    }

    public static Db2Connection getInstance() {
        // when two threads comes at same time, then conObj is null, then two objectes
        // will get created.
        // this is not thread safe.
        if (conObj == null)
            conObj = new Db2Connection();
        return conObj;
    }

    void check() {
        System.out.println("DB2 Connected.");
    }
}

// Lagy Initilization with Synchronized method(Thread safe).
class Db3Connection {
    private static Db3Connection conObj;

    private Db3Connection() {
    }
    // let's say 10k threads want to access this method, for every thread 
    // we are restricting it to access this method, even after creation of conObj.
    // locking on the method level, leads to waiting of threads.
    synchronized public static Db3Connection getInstance() {
        if (conObj == null)
            conObj = new Db3Connection();
        return conObj;
    }

    void check() {
        System.out.println("DB3 Connected.");
    }
}



// Lagy Initilization with Double locking.
class Db4Connection{
    private static Db4Connection conObj;
    private Db4Connection(){}

    public static Db4Connection getInstance(){
        // If conObj is already initialized, there is no need to acquire the lock.
        if(conObj == null){                       
            // This prevents other threads from entering this block simultaneously, ensuring thread safety.  
            synchronized(Db4Connection.class){     
                // The second check ensures that no other thread has created the instance while the current
                // thread was waiting for the lock. 
                if(conObj == null)                  
                    conObj = new Db4Connection();
            }
        }
        return conObj;
    }

    void check() {
        System.out.println("DB4 Connected.");
    }
}

public class singletonDesignPattern {
    public static void main(String[] args) {
        Db1Connection dbConObj1 = Db1Connection.getInstance();
        dbConObj1.check();

        Db2Connection dbConObj2 = Db2Connection.getInstance();
        dbConObj2.check();

        Db3Connection dbConObj3 = Db3Connection.getInstance();
        dbConObj3.check();

        Db4Connection dbConObj4 = Db4Connection.getInstance();
        dbConObj4.check();
    }
}
