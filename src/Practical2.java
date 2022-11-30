package src;

public class Practical2 {

    public static void main(String[] args) {
        runSimulation();
    }

    private static void runSimulation() {
        Network network = new Network();

        boolean valid = false;
        while (!valid) {
            System.out.println(network);
            valid = true;
            int output = 0;

            for (int in1 = 0; in1 <=1 && valid; in1++) {
                for (int in2 = 0; in2 <= 1 && valid; in2++) {
                    output = network.perform(in1, in2);
                    int expected = expectedResultOR(in1, in2);
                    System.out.println("INPUT: " + in1 + " : " + in2 + " EXPECTED: " + expected + "; ACTUAL: " + output);
                    if (expected != output) {
                        valid = false;
                        network.updateWeights(in1, in2, expected, output);
                    }
                }
            }
            System.out.println(valid);
        }
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