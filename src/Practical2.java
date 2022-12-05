package src;

import src.support.Debug;
import src.support.Input;

public class Practical2 {

    public static boolean targetAND = true;

    public static void main(String[] args) {
        Input.specifyLogLevel();
        Input.specifyTargetFunction();
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
            valid = true;
            int output = 0;

            for (int in1 = 0; in1 <=1 && valid; in1++) {
                for (int in2 = 0; in2 <= 1 && valid; in2++) {
                    output = network.perform(in1, in2);
                    int expected = expectedResultOR(in1, in2);
                    if(targetAND) expected = expectedResultAND(in1, in2);
                    Debug.log3("INPUT: " + in1 + " : " + in2 + "; EXPECTED: " + expected + "; ACTUAL: " + output);
                    if (expected != output) {
                        valid = false;
                        network.updateWeights(in1, in2, expected, output);
                    }
                }
            }
            Debug.log3("Network valid: " + valid);
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
}