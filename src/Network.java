package src;

public class Network {

    double biasUnit = 1;
    
    double weight1;
    double weight2;
    double weightBias;


    public Network() {
        weight1 = (((int) ((Math.random()*10))) / 10.0);
        weight2 = (((int) ((Math.random() * 10))) / 10.0);
        weightBias = (((int) ((Math.random() * 10))) / 10.0);

        weight1 = ((int) (weight1 * 10)) / 10.0;
        weight2 = ((int) (weight2 * 10)) / 10.0;
        weightBias = ((int) (weightBias * 10)) / 10.0;
    }

    public int perform(double in1, double in2) {
        if ((in1 * weight1 + in2 * weight2 + biasUnit * weightBias) < 0) return 0;
        else return 1;
    }


    public void updateWeights(double in1, double in2, double target, double actual) {
        double y = 0.1;
        weight1 = weight1 + Learning.deltaW(in1, actual, target, y);
        weight2 = weight2 + Learning.deltaW(in2, actual, target, y);
        weightBias = weightBias + Learning.deltaW(biasUnit, actual, target, y);
    }
    
    @Override
    public String toString() {
        return "Network: (" + "Bias weight: " + ((int) (weightBias * 10)) / 10.0 + ", Weight 1: " + ((int) (weight1 * 10)) / 10.0 + ", Weight 2: " + ((int) (weight2 * 10)) / 10.0 + ")";
    }
}
