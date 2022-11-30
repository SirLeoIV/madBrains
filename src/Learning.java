package src;

public class Learning {
    
    public static double deltaW(double ai, double ak, double target, double y) {
        return (int) (y * (target - ak) * ai * 10) / 10.0;
    }
}
