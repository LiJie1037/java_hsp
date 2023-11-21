package homework_;

public class Work08 {
    public static void main(String[] args) {
        for (Color color: Color.values()) {
//            System.out.println(color);
            color.show();
        }

        System.out.println();
        for (Color color : Color.values()) {
            switch (color) {
                case RED :
                    System.out.println("匹配到黄色");
                    break;
                case BLUE :
                    System.out.println("匹配到蓝色");
                    break;
            }
        }

    }
}

enum Color implements IA{
    RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0);

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    private int redValue;
    private int greenValue;
    private int blueValue;

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name() + "{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }
}

interface IA {
    public void show();
}