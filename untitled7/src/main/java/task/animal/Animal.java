package task.animal;

public abstract class Animal {
    private  static int count = 0;
    public static int getCount() {
        return count;
    }
    private String name;
    private int age;
    private int maxRunDist;
    private int maxSwimDist;

    public Animal(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.age = age;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaxRunDist() {
        return maxRunDist;
    }

    public void setMaxRunDist(int maxRunDist) {
        this.maxRunDist = maxRunDist;
    }

    public int getMaxSwimDist() {
        return maxSwimDist;
    }

    public void setMaxSwimDist(int maxSwimDist) {
        this.maxSwimDist = maxSwimDist;
    }

    public void run(int dist){
        if (dist<= this.maxRunDist){
            System.out.println(this.name + " пробежал " + dist);
        }
        else{
            System.out.println(this.name + " не пробежал " + dist);
        }
    }
    public void swim (int dist){
        if (this.maxSwimDist == 0){
            System.out.println(this.name + " не умеет плавать");
        }
        else{
            if (this.maxSwimDist<dist) System.out.println(this.name + " не проплыл " + dist);
            else System.out.println(this.name + " проплыл " + dist);
        }
    }
}
