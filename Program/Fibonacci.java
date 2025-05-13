import java.util.Scanner;

/**
 * This class demonstrates different methods to generate Fibonacci sequence
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * Each number is the sum of the two preceding ones
 */
public class Fibonacci {
    /**
     * Method 1: Recursive approach to calculate Fibonacci number
     * @param n: The position in Fibonacci sequence (0-based)
     * @return: The Fibonacci number at position n
     * Time Complexity: O(2^n) - Exponential
     * Space Complexity: O(n) - Due to recursion stack
     */
    public static int fibonacciRecursive(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n <= 1) {
            return n;
        }
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * Method 2: Iterative approach to calculate Fibonacci number
     * @param n: The position in Fibonacci sequence (0-based)
     * @return: The Fibonacci number at position n
     * Time Complexity: O(n) - Linear
     * Space Complexity: O(1) - Constant
     */
    public static int fibonacciIterative(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n <= 1) {
            return n;
        }
        
        // Initialize first two Fibonacci numbers
        int a = 0, b = 1, c;
        // Calculate Fibonacci number iteratively
        for (int i = 2; i <= n; i++) {
            c = a + b;  // Calculate next number
            a = b;      // Move a to next position
            b = c;      // Move b to next position
        }
        return b;
    }

    /**
     * Method 3: Print the entire Fibonacci series up to n terms
     * @param n: Number of terms to print
     * Time Complexity: O(n) - Linear
     * Space Complexity: O(1) - Constant
     */
    public static void printFibonacciSeries(int n) {
        // Initialize first two Fibonacci numbers
        int a = 0, b = 1;
        System.out.println("Fibonacci Series up to " + n + " terms:");
        
        // Print each term in the series
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;  // Calculate next number
            a = b;          // Move a to next position
            b = c;          // Move b to next position
        }
        System.out.println();
    }

    /**
     * Main method to demonstrate Fibonacci sequence generation
     * Provides interactive menu for user to choose method and number of terms
     */
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get number of terms from user
        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int n = scanner.nextInt();
        
        // Input validation
        if (n < 0) {
            System.out.println("Please enter a non-negative number!");
            return;
        }
        
        // Display menu for method selection
        System.out.println("\nChoose the method to generate Fibonacci sequence:");
        System.out.println("1. Recursive Method");
        System.out.println("2. Iterative Method");
        System.out.println("3. Print Series Method");
        System.out.println("4. All Methods");
        System.out.print("Enter your choice (1-4): ");
        
        // Get user's choice
        int choice = scanner.nextInt();
        
        // Process user's choice using switch statement
        switch (choice) {
            case 1:
                // Generate sequence using recursive method
                System.out.println("\nUsing Recursive Method:");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacciRecursive(i) + " ");
                }
                break;
                
            case 2:
                // Generate sequence using iterative method
                System.out.println("\nUsing Iterative Method:");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacciIterative(i) + " ");
                }
                break;
                
            case 3:
                // Print the series directly
                printFibonacciSeries(n);
                break;
                
            case 4:
                // Demonstrate all three methods
                System.out.println("\nUsing Recursive Method:");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacciRecursive(i) + " ");
                }
                System.out.println("\n");
                
                System.out.println("Using Iterative Method:");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacciIterative(i) + " ");
                }
                System.out.println("\n");
                
                printFibonacciSeries(n);
                break;
                
            default:
                // Handle invalid input
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
        }
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
} 