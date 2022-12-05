package src;

import src.support.Debug;
import static src.support.Debug.dString;

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

        double deltaWeight1 = Learning.deltaW(in1, actual, target, y);
        double deltaWeight2 = Learning.deltaW(in2, actual, target, y);
        double deltaWeightBias = Learning.deltaW(biasUnit, actual, target, y);

        Debug.log4("Learning: ");
        Debug.log4("Weight 1: " 
        + " current value = " + dString(weight1) + ", delta w = " + dString(deltaWeight1) + ", new value = " + dString(weight1 + deltaWeight1));
        
        Debug.log4("Weight 2: " 
        + " current value = " + dString(weight2) + ", delta w = " + dString(deltaWeight2) + ", new value = " + dString(weight2 + deltaWeight2));
        
        Debug.log4("Bias Weight: " 
        + " current value = " + dString(weightBias) + ", delta w = " + dString(deltaWeightBias) + ", new value = " + dString(weightBias + deltaWeightBias));

        weight1 = weight1 + deltaWeight1;
        weight2 = weight2 + deltaWeight2;
        weightBias = weightBias + deltaWeightBias;
    }
    
    @Override
    public String toString() {
        return "Network: (" + "Bias weight: " + dString(weightBias) + ", Weight 1: " + dString(weight1) + ", Weight 2: " + dString(weight2) + ")";
    }
}
