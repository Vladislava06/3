import java.util.Comparator;

class Employee {
    private String name;
    private int salary;
    private int year;
    private int month;
    private int day;

    public Employee(String name, int salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getSalary() {
        return salary;
    }

    // Пример компаратора для сравнения дат
    public static Comparator<Employee> dateComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            if (e1.year != e2.year) {
                return Integer.compare(e1.year, e2.year);
            } else if (e1.month != e2.month) {
                return Integer.compare(e1.month, e2.month);
            } else {
                return Integer.compare(e1.day, e2.day);
            }
        }
    };
}

class Manager extends Employee {
    public Manager(String name, int salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    // Метод для повышения зарплаты сотрудников, кроме руководителей
    public static void increaseSalary(Employee[] employees, int amount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.salary += amount;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("John", 5000, 2022, 5, 10);
        employees[1] = new Manager("Alice", 8000, 2021, 8, 15);
        employees[2] = new Employee("Bob", 4000, 2022, 3, 25);
        employees[3] = new Employee("Eva", 6000, 2022, 7, 5);

        Manager.increaseSalary(employees, 1000);

        for (Employee employee : employees) {
            System.out.println(employee.getSalary());
        }
    }
}