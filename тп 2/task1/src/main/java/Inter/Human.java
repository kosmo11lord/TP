package Inter;

public class Human extends Participants implements RunNJump {
    double maxRun;
    double maxJump;
    String name;
    boolean participation;

    public Human(double maxRun, double maxJump, String name) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
        this.participation = true;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    double getMaxRun() {
        return maxRun;
    }
    @Override
    double getMaxJump() {
        return maxJump;
    }
}
