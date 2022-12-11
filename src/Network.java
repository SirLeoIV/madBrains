package src;

import src.support.Debug;
import static src.support.Debug.dString;
import static src.Practical2.round;

public class Network {

    double biasUnit = 1;
    
    double weight1;
    double weight2;
    double weightBias;


    public Network() {
        weight1 = round(Math.random() * 2 - 1);
        weight2 = round(Math.random() * 2 - 1);
        weightBias = round(Math.random() * 2 - 1);

        // weight1 = 0.6;
        // weight2 = -0.2;
        // weightBias = -0.3;
    }

    public int perform(double in1, double in2) {
        if ((in1 * weight1 + in2 * weight2 + biasUnit * weightBias) <= 0) return 0;
        else return 1;
    }


    public void updateWeights(double in1, double in2, double target, double actual) {

        double deltaWeight1 = Learning.deltaW(in1, actual, target);
        double deltaWeight2 = Learning.deltaW(in2, actual, target);
        double deltaWeightBias = Learning.deltaW(biasUnit, actual, target);

        Debug.log4("Learning: ");
        Debug.log4("Weight 1:    " 
        + " current value = " + dString(weight1) + ", delta w = " + dString(deltaWeight1) + ", new value = " + dString(weight1 + deltaWeight1));
        
        Debug.log4("Weight 2:    " 
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
