package src;

import static src.Practical2.round;

public class Learning {

    public static double y = 0.1;
    
    public static double deltaW(double ai, double ak, double target) {
        return round(y * (target - ak) * ai);
    }
}
