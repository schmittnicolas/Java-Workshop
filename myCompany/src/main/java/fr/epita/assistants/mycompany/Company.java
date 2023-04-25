package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees;
    private HashMap<Employee, Manager> employeeManagement;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
        employeeManagement = new HashMap<>();
    }

    public int size() {
        return employees.size();
    }

    public void hire(Employee p) {
        employees.add(p);
    }

    public void fire(Employee p) {
        employees.remove(p);
    }

    public void printEmployees() {
        System.out.println("The company " + name + " employs:");

        employees.forEach(employee -> {
            System.out.println("- " + employee.toString());
        });
    }

    public boolean addEmployeeManagement(Employee e, Manager m) {
        if (!employees.contains(e) || !employees.contains(m)) {
            if (!employees.contains(e)) {
                System.out.println(e.toString() + " is not employed by " + name + ".");
            }
            if (!employees.contains(m)) {
                System.out.println(m.toString() + " is not employed by " + name + ".");
            }
            return false;
        } else {
            if (employeeManagement.containsKey(e)) {
                System.out.println(e.toString() + " now has a manager.");
            } else {
                System.out.println(e.toString() + " has a new manager.");
            }
            return true;
        }
    }


    public void printManager(Employee e) {
        Manager manager = employeeManagement.get(e);
        if (manager == null) {
            System.out.println(e.toString() + " is managed by nobody.");
        } else {
            System.out.println(manager.toString() + " manages " + e.toString() + ".");
        }
    }
}
