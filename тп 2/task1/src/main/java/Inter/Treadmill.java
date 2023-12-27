package Inter;

public class Treadmill implements Obstacle{
    double length;

    public Treadmill(Distance distance) {
        this.length = distance.getDist();
    }

    public double getLength() {
        return length;
    }

    @Override
    public boolean isCan(Participants participant) {
        if (participant.Run(length, participant.getMaxRun())) {
                System.out.println(participant.getName() + " успешно пробежал " + length + " метров.");
                return true;
            } else {
                System.out.println(participant.getName() + " не смог пробежать " + length + " метров.");
            return false;
            }

    }
}
