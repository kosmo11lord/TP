package Inter;

public enum Distance {
    LONG(16),
    SHORT(8),
    HIGH(10),
    LOW(1.3);
    private double dist;
    public double getDist() {
        return dist;
    }
    Distance(double dist) {
        this.dist = dist;
    }
}
