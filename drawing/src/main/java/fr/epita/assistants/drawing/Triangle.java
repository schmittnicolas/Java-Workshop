package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    public Triangle(int length) {
        super(length);
    }


    @Override
    public void draw() {
        for (int i = 1; i <= length; i++) {
            for (int k = i; k > 0; k--){
                if (k == i || k == 1 || i == 1 || i == length)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            for (int j = i; j < length; j++)
                System.out.print(" ");
            System.out.println();
        }
    }
}
