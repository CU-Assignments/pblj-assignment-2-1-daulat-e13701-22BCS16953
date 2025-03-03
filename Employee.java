import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManager {
    static ArrayList<Employee> employees = new ArrayList<>();

    static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }

    static void updateEmployee(int id, String name, double salary) {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.id == id) {
                e.name = name;
                e.salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                employees.remove(i);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void searchEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.id == id) {
                e.display();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addEmployee(1, "Shivangi", 50000);
        addEmployee(2, "Priyanka", 60000);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            int id;
            String name;
            double salary;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    salary = scanner.nextDouble();
                    addEmployee(id, name, salary);
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    salary = scanner.nextDouble();
                    updateEmployee(id, name, salary);
                    break;
                case 3:
                    System.out.print("Enter ID to remove: ");
                    id = scanner.nextInt();
                    removeEmployee(id);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    id = scanner.nextInt();
                    searchEmployee(id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
