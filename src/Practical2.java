package src;

import src.support.Debug;
import src.support.Input;

public class Practical2 {

    public static Target target;
    public static int customFXA;
    public static int customFXB;
    public static int customFXX = 1 ;
    public static int customFXY = 1 ;

    public enum Target {
        AND, OR, _2X1, CUSTOM_FX
    }

    public static void main(String[] args) {
        Input.specifyLogLevel();
        Input.specifyTargetFunction();
        Input.specifyLearningConstant();
        runSimulation();
    }

    private static void runSimulation() {
        Network network = new Network();

        boolean valid = false;
        int counter = 0;
        while (!valid) {
            counter++;
            Debug.log1("Iteration: " + counter);
            Debug.log2(network);
            if(target == Target._2X1) Debug.log4("Test function: \"y = 2x + 1\"");
            if(target == Target.CUSTOM_FX) Debug.log4("Test function: \"y = " + customFXA + "x + " + customFXB + "\"");
            valid = true;
            int output = 0;

            for (int in1 = 0; in1 <= customFXX && valid; in1++) {
                for (int in2 = 0; in2 <= customFXY && valid; in2++) {
                    output = network.perform(in1, in2);
                    int expected = 1;
                    
                    switch (target) {
                        case AND -> expected = expectedResultAND(in1, in2);
                        case OR -> expected = expectedResultOR(in1, in2);
                        case _2X1 -> expected = expectedResult2X1(in1, in2);
                        case CUSTOM_FX -> expected = expectedResultCustomFX(in1, in2);
                    }

                    if(target == Target._2X1 || target == Target.CUSTOM_FX) {
                        Debug.log3("INPUT: x=" + in1 + " : y=" + in2 + "; EXPECTED: " + expected + "; ACTUAL: " + output);
                    } else Debug.log3("INPUT: " + in1 + " : " + in2 + "; EXPECTED: " + expected + "; ACTUAL: " + output);

                    if (expected != output) {
                        valid = false;
                        network.updateWeights(in1, in2, expected, output);
                    }
                }
            }
                    
            Debug.log3("Network valid: " + valid);
            Debug.log3("----------------");
        }
        Debug.log1("Finished training. Network status: " + network);
    }

    static int expectedResultOR(double in1, double in2) {
        if(in1 > 0 || in2 > 0) return 1;
        else return 0;
    }
    

    static int expectedResultAND(double in1, double in2) {
        if(in1 > 0 && in2 > 0) return 1;
        else return 0;
    }
    

    static int expectedResult2X1(double in1, double in2) {
        if (in2 >= (2.0 * in1 + 1.0)) return 1;
        else return 0;
    }
    
    static int expectedResultCustomFX(double in1, double in2) {
        if (in2 >= (customFXA * in1 + customFXB)) return 1;
        else return 0;
    }

    public static double round(double d) {
        return ((int) Math.round(d * 10)) / 10.0;
    }
}