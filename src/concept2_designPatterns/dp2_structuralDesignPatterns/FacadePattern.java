/*
 *  Facade Method Design Pattern:
 *      - This pattern helps to hide the system complexity from the client, 
 *        Expose only necessary things to the client.
 * 
 *      - Facade Method Design Pattern provides a unified interface to a set of interfaces in a subsystem.
 *      - Facade defines a high-level interface that makes the subsystem easier to use.
 */

class EmployeDAO {
    void insert() {
        System.out.println("EMP Data Inserted.");
    }

    void update() {
        System.out.println("EMP Data update.");
    }

    void delete() {
        System.out.println("EMP Data delete.");
    }
}

class EmployeFacade {
    EmployeDAO employeDAO;

    EmployeFacade(EmployeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }

    void insert() { // The Facade is exposing only the insert, the update and delete is hidden to
                    // the client.
        employeDAO.insert();
    }
}

class EmployeClient {
    EmployeFacade employeFacade;

    EmployeClient(EmployeFacade employeFacade) {
        this.employeFacade = employeFacade;
    }

    void insert() {
        employeFacade.insert();
    }
}

class FacadePattern {
    public static void main(String[] args) {
        EmployeClient employeClient = new EmployeClient(new EmployeFacade(new EmployeDAO()));
        employeClient.insert();
    }
}