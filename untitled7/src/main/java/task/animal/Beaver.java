package task.animal;

public class Beaver extends Regional{

    private  static int count = 0;
    public Beaver(String name) {
        super(name, "Бобры опасны острыми зубами и опасностью лесоповала");
        count++;
    }
    public static int getCount() {
        return count;
    }
}
