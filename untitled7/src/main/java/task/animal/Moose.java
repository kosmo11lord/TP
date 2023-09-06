package task.animal;

public class Moose extends Regional{
    private  static int count = 0;
    public Moose(String name) {
        super(name, "Представляет опасность возможностью насадится на рога");
        count++;
    }
    public static int getCount() {
        return count;
    }
}
