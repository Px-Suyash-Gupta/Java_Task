import java.io.*;
import java.util.Scanner;

public class CalculatorFileT3 {
    private static final String FILE_NAME = "history.txt";
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while(true) {      
                System.out.print("Enter the First Number : ");
                double num1 = sc.nextDouble();

                System.out.print("Enter the Second Number : ");
                double num2 = sc.nextDouble();

                System.out.print("Enter the operation (+, -, *, /) or type 'exit' to quit or type 'History' to see history : ");
                String operation = sc.next();

                if (operation.equals("Exit")) {  
                    System.out.println("Thank you for using the calculator");
                    break;  
                    } else if (operation.equals("History")) 
                        {
                            readHistory();
                }
                double result = 0;
                
                switch (operation) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> {
                        if (num2 != 0) {
                            result = num1 / num2;  
                        } else {
                            System.out.println("Cannot divide by zero");
                        }
                    }
                default -> System.out.println("Invalid operation, Please Try again");
                } 
                System.out.println("Result: " + result);
                writeHistory(num1, num2, operation, result);
                System.out.println();
            }
        }   
    }
    private static void writeHistory(double num1, double num2, String operation, double result) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            writer.write(num1 + " " + operation + " " + num2 + " = " + result);
            writer.newLine(); 
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static void readHistory() {
        try (FileReader fileReader = new FileReader(FILE_NAME);
        BufferedReader reader = new BufferedReader(fileReader)) {

       System.out.println("Calculation History:");
       String line;
       while ((line = reader.readLine()) != null) {
           System.out.println(line);
       }
    } catch (IOException e ) {
       System.out.println("Error reading from file.");
        }
    }

        
}

