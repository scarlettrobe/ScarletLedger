# Personal Finance Tracker

## Description

A simple Java-based personal finance tracker to monitor income and expenses. The application provides features to add transactions, view transaction history, calculate total income and expenses, and provide financial insights.

## Features

1. **Add Transaction**: You can add income or expense transactions, each transaction impacts the total account balance.
2. **View Transaction History**: Displays a list of all the transactions that have been made.
3. **Calculate Total Income/Expense**: Shows total income and total expenses separately.
4. **Calculate Saving**: Calculates savings by finding the difference between total income and total expenses.
5. **Financial Insights**: Provides simple insights like average monthly expenses.

## Classes

- `Transaction`: Represents a transaction with properties such as `amount`, `date`, `type` (income or expense), and `description`.
- `Account`: Represents an account with properties like `balance` and a `List<Transaction>` to store all transactions.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or newer.
- A Java IDE (like IntelliJ IDEA or Eclipse).

### Installation

1. Clone the repo:
2. Open the project in your Java IDE.
3. Build and run the `Main` class.

## Usage

Upon running the application, the user is presented with a menu of operations:

Welcome to Personal Finance Tracker! What would you like to do today?

Add a transaction
View transaction history
View total income
View total expenses
View savings
View financial insights
Exit
Please enter a number (1-7):
The user can then input a number to select what operation they would like to perform.

## Future Improvements

1. Implement data persistence so that transactions aren't lost when the program ends.
2. Develop a graphical user interface for a more user-friendly experience.
3. Provide more complex financial insights, perhaps integrating with a financial API to provide investment suggestions.

## Contribute

Please feel free to fork this repository and submit pull requests. All contributions are welcome!

