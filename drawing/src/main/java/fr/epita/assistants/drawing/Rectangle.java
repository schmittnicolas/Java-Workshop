package fr.epita.assistants.drawing;

public class Rectangle extends Sharp{
    private int width;

    public Rectangle(int width, int length){
        super(length);
        this.width = width;
    }

    @Override
    public void draw() {
        for (int l = 0; l < length; l++){
            for (int w = 0; w < width; w++){
                if (l == 0 || l == length -1 || w == 0 || w == width - 1){
                    System.out.print("# ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
