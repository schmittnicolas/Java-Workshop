package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements Assignable{

    List<String> projects;
    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
        projects = new ArrayList<>();
    }

    @Override
    public void sayMyJob() {
        System.out.println(this.toString() + " is a manager.");
    }

    @Override
    public void addProject(String project) {
        projects.add(project);
    }

    @Override
    public boolean hasProject(String project) {
        return projects.contains(project);
    }

    @Override
    public void listProjects() {
        System.out.println(this.toString() + "'s current projects are:");
        projects.forEach(project -> {
            System.out.println("- " + project);
        });
    }
}
