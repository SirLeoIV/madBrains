package src;

public class Learning {
    
    public static double deltaW(double ai, double ak, double target, double y) {
        return y * (target - ak) * ai;
    }
}
