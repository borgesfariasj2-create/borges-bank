public class Account {
    String name;
    String cpf;
    String email;
    String password;
    double balance;

    public Account(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount of " + amount + " deposited successfully!");
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdraw completed successfully!");
            System.out.println("New balance: " + balance);
        }
    }
    public void transfer(Account destination, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            destination.balance += amount;
            System.out.println("Transfer completed successfully!");
            System.out.println("New balance: " + balance);
        }
    }
    public void showBalance() {
        System.out.println("Current balance: " + balance);
    }
}