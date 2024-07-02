import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private final String description;
    private final double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + ": $" + amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        expenses.add(new Expense(description, amount));
                        System.out.println("Expense added.");
                    }
                    case 2 -> {
                        System.out.println("Expenses:");
                        for (Expense expense : expenses) {
                            System.out.println(expense);
                        }
                    }
                    case 3 -> {
                        System.out.println("Exiting...");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            scanner.close();
        }
    }
}