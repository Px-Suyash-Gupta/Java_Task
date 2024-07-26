import java.util.*;

public class CalCollectionT4 {
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) 
        {

        List<String> calculationHistory = new ArrayList<>();

        Set<String> uniqueCalculations = new HashSet<>();

        Map<String, Double> operationResults = new HashMap<>();

        while (true) {
            System.out.print("Enter the First Number: ");
            double num1 = sc.nextDouble(); 

            System.out.print("Enter the Second Number: ");
            double num2 = sc.nextDouble(); 

            System.out.print("Enter the operation (+, -, *, /) or type 'exit' to quit: ");
            String operation = sc.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the calculator.");
                break;
            }

            Double result = calculate(num1, operation, num2); 
            if (result != null) {
                String operationString = num1 + " " + operation + " " + num2;

                calculationHistory.add(operationString);

                uniqueCalculations.add(operationString);

                operationResults.put(operationString, result);

                System.out.println("Result: " + result);
            }
            
            System.out.println(); 

        }

        System.out.println(); 

        System.out.println("Calculation History:");
        displayResults(calculationHistory, operationResults);

        System.out.println();

        System.out.println("Unique Calculations:");
        displayResults(uniqueCalculations, operationResults);

        System.out.println();

    }
}
    private static Double calculate(double num1, String operator, double num2) {
        
        switch (operator) {
            case "+" -> {
                return num1 + num2; 
            }
            case "-" -> {
                return num1 - num2; 
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                if (num2 != 0) { 
                    return num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero."); 
                    return null;
                }
            }
            default -> {
                System.out.println("Error: Invalid operator."); 
                return null;
            }
        }
    }

    private static void displayResults(Collection<String> operations, Map<String, Double> results) {
        operations.forEach(operation -> System.out.println(operation + " = " + results.get(operation)));
    }

 }
    

    

