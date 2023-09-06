package task.animal;

public class Dog extends Animal{
    private  static int count = 0;
    public Dog(String name, int age) {
        super(name, age, 500, 10);
        count++;
    }
    public static int getCount() {
        return count;
    }
}
