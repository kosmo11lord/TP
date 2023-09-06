package task.animal;

public abstract class Regional extends Animal {
    private static int count = 0;

    private final String isDangerous;

    public Regional(String name, String isDangerous) {
        super(name, 0, 0, 0);
        this.isDangerous = isDangerous;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void dangerous() {
        System.out.println(isDangerous);
    }


}