import java.util.Scanner;

public class SimpleCalculatorT1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while(true) {      
                System.out.print("Enter the First Number : ");
                double num1 = sc.nextDouble();

                System.out.print("Enter the Second Number : ");
                double num2 = sc.nextDouble();

                System.out.print("Enter the operation (+, -, *, /) or type 'exit' to quit : ");
                String operation = sc.next();

                if (operation.equals("exit")) {  
                    System.out.println("Thank you for using the calculator");
                    break;  
                }

                switch (operation) {
                    case "+" -> System.out.println("Result of sum : " + (num1 + num2));
                    case "-" -> System.out.println("Result of subtraction : " + (num1 - num2));
                    case "*" -> System.out.println("Result of multiplication : " + (num1 * num2));
                    case "/" -> {
                        if (num2 != 0) {
                            System.out.println("Result of division : " + (num1 / num2));  
                        } else {
                            System.out.println("Cannot divide by zero");
                        }
                    }
                default -> System.out.println("Invalid operation, Please Try again");
                } 
                System.out.println();
            }
        }   
    }
}

