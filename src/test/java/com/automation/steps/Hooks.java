package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.HashSet;
import java.util.Set;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ReportManager.initReporter(scenario);
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ReportManager.attachScreenshot();
        }
        DriverManager.getDriver().quit();
    }

    public static String solution(int[][] operations) {
        // Set to keep track of obstacle coordinates
        Set<Integer> obstacles = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Iterate through the operations
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                // Operation type 1: Add an obstacle at coordinate x
                int x = operation[1];
                obstacles.add(x);
            } else if (operation[0] == 2) {
                // Operation type 2: Check if a block can be built of size 'size' ending at x-1
                int x = operation[1];
                int size = operation[2];
                boolean canBuild = true;

                // Check the range from (x - size) to (x - 1)
                for (int i = x - size; i < x; i++) {
                    if (obstacles.contains(i)) {
                        canBuild = false;
                        break;
                    }
                }

                // Append the result: '1' if possible, '0' otherwise
                if (canBuild) {
                    result.append("1");
                } else {
                    result.append("0");
                }
            }
        }

        // Return the result as a binary string
        return result.toString();
    }

    public static void main(String[] args) {
        // Example test case
        int[][] operations = {
                {1, 2},
                {1, 5},
                {2, 5, 2},
                {2, 6, 3},
                {2, 2, 1},
                {2, 3, 2}
        };

        System.out.println(solution(operations));  // Output: "1010"
    }


}
