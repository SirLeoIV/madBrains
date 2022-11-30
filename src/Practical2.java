package src;

public class Practical2 {

    public static void main(String[] args) {
        Network network = new Network();

        boolean valid = false;
        while (!valid) {
            System.out.println(network);
            valid = true;
            double in1 = 0;
            double in2 = 0;
            double output = 0;
            for (;in1 <=1 && valid; in1++) {
                for (;in2 <= 1 && valid; in2++) {
                    output = network.perform(in1, in2);
                    double expected = expectedResultAND(in1, in2);
                    if (expected != output) {
                        valid = false;
                        network.updateWeights(in1, in2, expected, output);
                    }
                }
            }
        }
    }

    static double expectedResultOR(double in1, double in2) {
        if(in1 > 0 || in2 > 0) return 1;
        else return 0;
    }
    

    static double expectedResultAND(double in1, double in2) {
        if(in1 > 0 && in2 > 0) return 1;
        else return 0;
    }
}