package Inter;
public interface RunNJump {
    default boolean Run(double length, double maxRun) {
        if (length<=maxRun){
            return true;
        } else if (superRun()) {
            System.out.print("Использован super run: ");
            return true;
        }
        return false;
    }
    default boolean superRun() {
        return Participants.superRun-->0;
    }
    default boolean Jump(double height, double maxJump) {
        return height<=maxJump;
    }
}
