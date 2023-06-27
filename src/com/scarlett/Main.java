package com.scarlett;

import java.util.*;

public class Main {
    private static Account account;

    public static void main(String[] args) {
        account = new Account();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 7) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    viewTransactionHistory();
                    break;
                case 3:
                    viewTotalIncome();
                    break;
                case 4:
                    viewTotalExpenses();
                    break;
                case 5:
                    viewSavings();
                    break;
                case 6:
                    viewFinancialInsights();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Welcome to Personal Finance Tracker! What would you like to do today?\n");
        System.out.println("1. Add a transaction");
        System.out.println("2. View transaction history");
        System.out.println("3. View total income");
        System.out.println("4. View total expenses");
        System.out.println("5. View savings");
        System.out.println("6. View financial insights");
        System.out.println("7. Exit");
        System.out.print("\nPlease enter a number (1-7): ");
    }

    private static void addTransaction(Scanner scanner) {
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the date (MM/DD/YYYY): ");
        String dateString = scanner.nextLine();
        // Parse the date string and create a Date object

        System.out.print("Enter the type (income/expense): ");
        String type = scanner.nextLine();

        System.out.print("Enter the description: ");
        String description = scanner.nextLine();

        Transaction transaction = new Transaction(amount, new Date(), type, description);
        account.addTransaction(transaction);

        System.out.println("Transaction added successfully!");
    }

    private static void viewTransactionHistory() {
        List<Transaction> transactions = account.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getDescription() + ": " + transaction.getAmount());
            }
        }
    }

    private static void viewTotalIncome() {
        double totalIncome = 0.0;
        for (Transaction transaction : account.getTransactions()) {
            if (transaction.getType().equals("income")) {
                totalIncome += transaction.getAmount();
            }
        }
        System.out.println("Total Income: " + totalIncome);
    }

    private static void viewTotalExpenses() {
        double totalExpenses = 0.0;
        for (Transaction transaction : account.getTransactions()) {
            if (transaction.getType().equals("expense")) {
                totalExpenses += transaction.getAmount();
            }
        }
        System.out.println("Total Expenses: " + totalExpenses);
    }

    private static void viewSavings() {
        double totalIncome = 0.0;
        double totalExpenses = 0.0;
        for (Transaction transaction : account.getTransactions()) {
            if (transaction.getType().equals("income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equals("expense")) {
                totalExpenses += transaction.getAmount();
            }
        }
        double savings = totalIncome - totalExpenses;
        System.out.println("Savings: " + savings);
    }

    private static void viewFinancialInsights() {
        List<Transaction> transactions = account.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found. Add transactions to get financial insights.");
            return;
        }

        double totalExpenses = 0.0;
        double maxExpense = Double.MIN_VALUE;
        double minExpense = Double.MAX_VALUE;

        Map<String, Double> expenseCategories = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("expense")) {
                totalExpenses += transaction.getAmount();
                maxExpense = Math.max(maxExpense, transaction.getAmount());
                minExpense = Math.min(minExpense, transaction.getAmount());

                String category = getCategoryFromDescription(transaction.getDescription());
                expenseCategories.put(category, expenseCategories.getOrDefault(category, 0.0) + transaction.getAmount());
            }
        }

        double averageExpense = totalExpenses / transactions.size();

        System.out.println("Financial Insights:");
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Average Monthly Expenses: " + averageExpense);
        System.out.println("Highest Expense: " + maxExpense);
        System.out.println("Lowest Expense: " + minExpense);

        System.out.println("Expense Categories:");
        for (Map.Entry<String, Double> entry : expenseCategories.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String getCategoryFromDescription(String description) {
        // You can implement your logic to extract a category from the transaction description
        // For simplicity, let's assume the category is the first word in the description
        String[] words = description.split(" ");
        if (words.length > 0) {
            return words[0];
        }
        return "";
    }
}
