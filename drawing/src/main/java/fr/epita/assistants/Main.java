package fr.epita.assistants;

import fr.epita.assistants.drawing.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List.of(new Rectangle(3,
                              4),
                new Square(4),
                new Triangle(4),
                new Circle(3))
            .forEach(IDrawable::draw);
    }
}
