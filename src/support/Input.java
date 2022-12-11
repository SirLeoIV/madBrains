package src.support;

import src.Learning;
import src.Practical2;

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
        String[] options = {"1", "2"};

        System.out.println("What target function should be represented by the network?");
        System.out.println("    1: logical AND");
        System.out.println("    2: logical OR");

        switch(ConsoleIN.readInputOptions(options).toLowerCase()) {
            case "1" -> Practical2.targetAND = true;
            case "2" -> Practical2.targetAND = false;
        }
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
