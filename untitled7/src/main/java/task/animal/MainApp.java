package task.animal;

public class MainApp {
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Murzik", 5),
                new Dog("Bobik", 7),
                new Dog("Bobik1", 12),
                new Dog("Bobik2", 8),
                new Tiger("tigar", 15, 0),
                new Cat("Murzik1", 3),
                new Tiger("tigar", 20, 30),
        };
        Regional[] regionals = {
                new Hare("Заяц"),
                new Hare("Заяц1"),
                new Hare("Заяц2"),
                new Moose("Лось"),
                new Moose("Лось1"),
                new Beaver(("Бобёр"))
        };
        //     System.out.println(animals[0].getName() +" "+animals[0].getAge());

        for (Animal a : animals) {
            a.run(600);
            a.swim(12);
            System.out.println();
        }
        System.out.println("Кол-во собак = " + Dog.getCount());
        System.out.println("Кол-во котов = " + Cat.getCount());
        System.out.println("Кол-во тигров = " + Tiger.getCount());

        for (Regional a : regionals) {
            a.dangerous();
        }
        System.out.println("Кол-во зайцев = " + Hare.getCount());
        System.out.println("Кол-во бобров = " + Beaver.getCount());
        System.out.println("Кол-во лосей = " + Moose.getCount());
        System.out.println("Кол-во региональных животных = " + Regional.getCount());
    }
}
