package JDBC.Exercise3;


public class EmployeePreparedDemo {

    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();

        dao.addEmployee("Charlie", 50000);
        dao.addEmployee("Diana", 72000);
        dao.removeDuplicates();
        dao.orderByName();
        dao.updateSalary(2, 80000);
        dao.listEmployees();
    }
}