import java.util.Scanner;

    class Calculator {
        
        public void add(double num1, double num2) {
            System.out.println("Result of addition: " + (num1 + num2));
        }

        public void subtract(double num1, double num2) {
            System.out.println("Result of subtraction: " + (num1 - num2));
        }

        public void multiply(double num1, double num2) {
            System.out.println("Result of multiplication: " + (num1 * num2));
        }

        public void divide(double num1, double num2) {
            if (num2 != 0) {
                System.out.println("Result of division : " + (num1 / num2));  
            } else {
                System.out.println("Cannot divide by zero");
            }
        }
    }

public class OopsCalculatorT2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Calculator calculator = new Calculator(); 

            while (true) {
                System.out.print("Enter the First Number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter the Second Number: ");
                double num2 = sc.nextDouble();

                System.out.print("Enter the operation (+, -, *, /) or type 'exit' to quit: ");
                String operation = sc.next();

                if (operation.equals("exit")) {
                    System.out.println("Thank you for using the calculator.");
                    break; 
                }

                switch (operation) {
                    case "+" -> calculator.add(num1, num2);
                    case "-" -> calculator.subtract(num1, num2);
                    case "*" -> calculator.multiply(num1, num2);
                    case "/" -> calculator.divide(num1, num2);
                    default -> System.out.println("Invalid operation, please try again.");
                }
                System.out.println();
            }
        }
    }
}
