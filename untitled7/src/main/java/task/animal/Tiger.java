package task.animal;

public class Tiger extends Animal {
    private  static int count = 0;
    public Tiger(String name, int age, int maxSwimDist) {
        super(name, age, 700, maxSwimDist);
        count++;
    }
    public static int getCount() {
        return count;
    }
}
