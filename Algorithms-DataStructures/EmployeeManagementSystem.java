class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int id, String name, String pos, double sal) {
        employeeId = id;
        this.name = name;
        position = pos;
        salary = sal;
    }

    public String toString() {
        return employeeId + " - " + name + ", " + position + ": $" + salary;
    }
}

public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[10];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < employees.length) employees[count++] = e;
    }

    public static void searchEmployee(int id) {
        for (Employee e : employees) {
            if (e != null && e.employeeId == id) {
                System.out.println("Found: " + e);
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i] = employees[count - 1];
                employees[--count] = null;
                break;
            }
        }
    }

    public static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "John", "Manager", 50000));
        addEmployee(new Employee(2, "Jane", "Clerk", 30000));
        traverseEmployees();
        searchEmployee(2);
        deleteEmployee(1);
        System.out.println("\nAfter Deletion:");
        traverseEmployees();
    }
}
