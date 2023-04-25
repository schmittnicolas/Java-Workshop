package fr.epita.assistants.exceptions;

import java.util.Arrays;

public class Student {
    private String name;
    private int age;
    private String major;

    private static final String[] majors = {"IMAGE", "GISTRE", "SRS", "SCIA", "MTI", "TCOM", "SIGL", "GITM", "ICE", "SANTE", "SSIE", "IF", "STARTUP", "Q"};

    public Student(String name, int age, String major) throws InvalidNameException, InvalidAgeException, InvalidMajorException {
        if (containsNumber(name)) {
            throw new InvalidNameException(name);
        }
        if (age <= 0 || age >= 130) {
            throw new InvalidAgeException(age);
        }
        if (!Arrays.asList(majors).contains(major.toUpperCase())) {
            throw new InvalidMajorException(major);
        }
        this.name = name;
        this.age = age;
        this.major = major.toUpperCase();
    }

    private static boolean containsNumber(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}
