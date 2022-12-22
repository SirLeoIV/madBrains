package src.support;

import src.Learning;
import src.Practical2;
import src.Practical2.Target;

public class Input {
    
    public static void specifyLogLevel() {
        String[] options = {"1", "2", "3", "4", "help", "?"};

        System.out.println("What log-level do you like to set? (1-4 or \"?\" for explanation)");

        switch(ConsoleIN.readInputOptions(options).toLowerCase()) {
            case "1" -> Debug.LOG_LEVEL = 1;
            case "2" -> Debug.LOG_LEVEL = 2;
            case "3" -> Debug.LOG_LEVEL = 3;
            case "4" -> Debug.LOG_LEVEL = 4;
            case "help", "?" -> {
                System.out.println("Log-Level 1: See only basic information like the number of iterations nedded to reach the target.");
                System.out.println("Log-Level 2: See some more information like the status of the networ after each iteration.");
                System.out.println("Log-Level 3: See even more information like all the inputs and outputs of the test-runs of the network.");
                System.out.println("Log-Level 4: See a lot of information about also the specific learning-functions of each weight.");
                specifyLogLevel();
            }
        }
    }
    
    public static void specifyTargetFunction() {
        String[] options = {"1", "2", "3", "4"};

        System.out.println("What target function should be represented by the network?");
        System.out.println("    1: logical AND");
        System.out.println("    2: logical OR");
        System.out.println("    3: linear function y = 2x + 1");
        System.out.println("    4: custom linear function y = ax + b");

        switch(ConsoleIN.readInputOptions(options).toLowerCase()) {
            case "1" -> Practical2.target = Target.AND;
            case "2" -> Practical2.target = Target.OR;
            case "3" -> {
                Practical2.target = Target._2X1;
                specifyCustomFunctionXRange();
                specifyCustomFunctionYRange();
            }
            case "4" -> {
                Practical2.target = Target.CUSTOM_FX;
                specifyCustomFunctionA();
                specifyCustomFunctionB();
                specifyCustomFunctionXRange();
                specifyCustomFunctionYRange();
            }
        }
    }    

    public static void specifyCustomFunctionA() {
        System.out.println("What value should \"a\" have in the function \"y = ax + b\"? (integer)");

        Integer input = ConsoleIN.readInt();
        if (input == null) specifyCustomFunctionA();
        else Practical2.customFXA = input;
    }

    public static void specifyCustomFunctionB() {
        System.out.println("What value should \"b\" have in the function \"y = " + Practical2.customFXA + "x + b\"? (integer)");

        Integer input = ConsoleIN.readInt();
        if (input == null) specifyCustomFunctionB();
        else Practical2.customFXB = input;
    }
    

    public static void specifyCustomFunctionXRange() {
        System.out.println("For what values for \"x\" should the network perform its calculations? (integer (max x), 1-20, leave blank for 0-2)");

        Integer input = ConsoleIN.readInt();
        if (input == null || input > 20 || input < 1) Practical2.customFXX = 2;
        else Practical2.customFXX = input;
    }
    

    public static void specifyCustomFunctionYRange() {
        System.out.println("For what values for \"y\" should the network perform its calculations? (integer (max y), 1-20, leave blank for 0-5)");

        Integer input = ConsoleIN.readInt();
        if (input == null || input > 20 || input < 1) Practical2.customFXY = 2;
        else Practical2.customFXY = input;
    }
    
    
    public static void specifyLearningConstant() {
        String[] options = {"1", "0.1", "2", "0.2", "3", "0.3", "4", "0.4", "5", "0.5"};

        System.out.println("How high should the learning constant be?");
        System.out.print("    1: 0.1");
        System.out.print("    2: 0.2");
        System.out.print("    3: 0.3");
        System.out.print("    4: 0.4");
        System.out.println("    5: 0.5");

        switch(ConsoleIN.readInputOptions(options).toLowerCase()) {
            case "1", "0.1" -> Learning.y = 0.1;
            case "2", "0.2" -> Learning.y = 0.2;
            case "3", "0.3" -> Learning.y = 0.3;
            case "4", "0.4" -> Learning.y = 0.4;
            case "5", "0.5" -> Learning.y = 0.5;
        }
    }
    
}
