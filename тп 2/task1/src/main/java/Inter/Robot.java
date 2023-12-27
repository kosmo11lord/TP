package Inter;

public class Robot extends Participants implements RunNJump {
    static int countSuperRun = 2;
    double maxRun;
    double maxJump;
    String name;
    boolean participation;

    public Robot(double maxRun, double maxJump, String name) {
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

    @Override
    public boolean Run(double length, double maxRun) {
        if (length<=maxRun){
            return true;
        }else if(super.superRun()){
            System.out.print("Использован super run: ");
            return true;
        } else if (this.superRun()) {
            System.out.print("Использован (robot) bonus super run: ");
            return true;
        }
        return false;
    }

    @Override
    public boolean superRun() {
        return countSuperRun-->0;
    }
}
