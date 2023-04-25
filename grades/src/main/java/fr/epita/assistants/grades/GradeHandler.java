package fr.epita.assistants.grades;

import fr.epita.assistants.grades.model.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class GradeHandler {
    private final List<Activity> activities;
    private final List<Student> students;

    public GradeHandler() {
        this.activities = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * @param activity The {@link Activity} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addActivity(Activity activity) {
        return activities.add(activity);
    }

    /**
     * @param student The {@link Student} to be added
     * @return {@code true} (as specified by {@link List#add})
     */
    public boolean addStudent(Student student) {
        return students.add(student);
    }

    /**
     * @param name The name of the desired {@link Student}
     * @return The desired student
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student getStudent(String name) throws EntryNotFoundException {
        for (Student student : students) {
            if (student.name().equals(name)){
                return student;
            }
        }

        throw new EntryNotFoundException(Student.class, name);
    }

    /**
     * @param grade The {@link Grade} to be added to the {@link Student}
     * @param name  The name of the desired {@link Student}
     * @return {@code true} (as specified by {@link List#add})
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public boolean addGradeToStudent(Grade grade, String name) throws EntryNotFoundException {
        for (Student student : students) {
            if (student.name().equals(name)){
                return student.grades().add(grade);
            }
        }

        throw new EntryNotFoundException(Student.class, name);
    }

    /**
     * @param name The name of the desired {@link Student} to remove
     * @return The removed {@link Student}
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public Student removeStudent(String name) throws EntryNotFoundException {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.name().equals(name)){
                studentToRemove = student;
            }
        }

        if (studentToRemove == null){
            throw new EntryNotFoundException(Student.class, name);
        }else{
            students.remove(studentToRemove);
            return studentToRemove;
        }
    }

    /**
     * @param name     The name of the desired {@link Student}
     * @param function A {@link Function} returning an updated {@link Student} from the given one
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public void updateStudent(String name, Function<Student, Student> function) throws EntryNotFoundException {
        for (Student student : students) {
            if (student.name().equals(name)){
                student = function.apply(student);
                return;
            }
        }

        throw new EntryNotFoundException(Student.class, name);
    }

    /**
     * @param name    The name of the {@link Student} from which to get grades
     * @param subject The {@link Subject} from which we want the student's average
     * @return The student's average grade in the specified subject (0 if no grades are available)
     * @throws EntryNotFoundException No known {@link Student} with the given name
     */
    public double getStudentAverageInSubject(String name, Subject subject) throws EntryNotFoundException {
        Student student = null;
        for (Student student1 : students) {
            if (student1.name().equals(name)){
                student = student1;
            }
        }

        if (student == null){
            throw new EntryNotFoundException(getClass(), name);
        }

        List<Grade> grades = student.grades();
        return grades.stream().filter(grade -> grade.activity().subject() == subject).mapToInt(Grade::grade).average().orElse(0.0);
    }
}
