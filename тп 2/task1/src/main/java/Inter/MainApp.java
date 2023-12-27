package Inter;

public class MainApp {


    public static void main(String[] args) {


       Participants[] participants =
               {                       new Robot (2,4,"Mk-1.2"),
                       new Robot (2,4,"Mk-1.3"),
                       new Cat(10,2,"Барсик"),
                       new Cat(10,2,"Барсик1"),

                new Human (2,1.7,"Олег"),
                new Robot (2,4,"Mk-1.2"),
                new Robot (10,3,"Mk-1.5")};

        Obstacle[] obstacles = {

                new Treadmill(Distance.LONG),
                new Treadmill(Distance.LONG),
                new Treadmill(Distance.LONG)
//                new Wall(Distance.HIGH),
//                new Wall(Distance.HIGH),
//                new Treadmill(Distance.LONG)
        };
        for (var participant: participants) {
            for (var obstacle: obstacles) {
                if (!obstacle.isCan(participant)){
                break;}
            }
        }
    }
}