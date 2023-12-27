package Inter;

public class Wall implements Obstacle{
    double height;

    public Wall(Distance distance) {
        this.height = distance.getDist();
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean isCan(Participants participant) {
        if (participant.Jump(height, participant.getMaxJump())) {
                System.out.println(participant.getName() + " успешно прыгнул на " + height + " метров.");
                return true;
            } else {
                System.out.println(participant.getName() + " не смог прыгнуть на " + height + " метров.");
                return false;
            }
        }
    }

