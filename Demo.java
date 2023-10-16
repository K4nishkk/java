
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        Employee employee = new Employee("Brian", "CEO");
        Employee employee2 = new Employee("Maya", "CFO");
        Employee employee3 = new Employee("Andre", "CTO");
        Employee employee4 = new Employee("Megan", "director");
        Employee employee5 = new Employee("David", "director");
        Employee employee6 = new Employee("Sam", "director");
        Employee employee7 = new Employee("Greg", "manager");
        Employee employee8 = new Employee("Mona", "manager");
        Employee employee9 = new Employee("Marcus", "manager");
        Employee employee10 = new Employee("Blake", "manager");
        Employee employee11 = new Employee("Nate", "manager");
        Employee employee12 = new Employee("Cristie", "manager");

        employee.subordinate.add(employee2);
        employee.subordinate.add(employee3);
        employee2.subordinate.add(employee4);
        employee2.subordinate.add(employee5);
        employee3.subordinate.add(employee6);
        employee4.subordinate.add(employee7);
        employee4.subordinate.add(employee8);
        employee5.subordinate.add(employee9);
        employee5.subordinate.add(employee10);
        employee6.subordinate.add(employee11);
        employee6.subordinate.add(employee12);

        Structure structure = new Structure();
        structure.root = employee;
        structure.displayTree(structure.root, 0);
    }
}

class Employee {
    String name;
    String rank;
    ArrayList<Employee> subordinate;

    // constructor
    Employee(String name, String rank) {
        this.name = name;
        this.rank = rank;
        this.subordinate = new ArrayList<Employee>(); // intializing with empty ArrayList
    }
}

class Structure {
    Employee root;

    // constructor
    Structure() {
        this.root = null;
    }

    // display tree
    void displayStructure() {
        if (this.root == null) {
            return;
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.add(this.root);
        int count = 1;
        int childCount = 0;
        
        while (queue.isEmpty() == false) {
            Employee temp = queue.remove();
            count--;

            for (Employee employee : temp.subordinate) {
                queue.add(employee);
                childCount++;
            }

            System.out.print(temp.name + ", " + temp.rank + "   ");
            if (count == 0) {
                System.out.println();
                count = childCount;
                childCount = 0;
            }
        }
    }

    void displayTree(Employee focusNode, int n) {
        if (this.root == null) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }

        System.out.println((char)16 + " " + focusNode.name + ", " + focusNode.rank);
        if (focusNode.subordinate.isEmpty() == false) {
            for (Employee employee : focusNode.subordinate) {
                displayTree(employee, n + 1);
            }
        }
    }
}