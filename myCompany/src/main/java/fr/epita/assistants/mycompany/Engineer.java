package fr.epita.assistants.mycompany;

public class Engineer extends Employee implements Assignable{

    private String project;
    public Engineer(String firstName, String lastName) {
        super(firstName, lastName);
        this.project = "";
    }

    @Override
    public void sayMyJob() {
        System.out.println(toString() + " is an engineer.");
    }

    @Override
    public void addProject(String project) {
        this.project = project;
    }

    @Override
    public boolean hasProject(String project) {
        return this.project.equals(project);
    }

    @Override
    public void listProjects() {
        System.out.println(this.toString() + "'s current project is " + project);
    }
}
