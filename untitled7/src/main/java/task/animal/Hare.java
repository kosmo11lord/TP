package task.animal;

public class Hare extends Regional{
    private  static int count = 0;
    public Hare(String name) {
        super(name, "Ничем");
        count++;
    }
    public static int getCount() {
        return count;
    }
}
