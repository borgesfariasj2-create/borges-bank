import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            do {
                System.out.println("===== BORGES BANK =====");
                System.out.println("=== Choose an option ===");
                System.out.println(">>> [1] Login");
                System.out.println(">>> [2] Register");
                System.out.println(">>> [3] Exit");
                System.out.println("=======================");
                System.out.print("Which option do you want? : ");
                option = sc.nextInt();
                sc.nextLine();

                if (option < 1 || option > 3) {
                    System.out.println("Invalid option, choose a valid option.\n");
                }

            } while (option < 1 || option > 3);

            switch (option) {
                case 1:
                    System.out.println("\n=== LOGIN ===");

                    if (accounts.size() == 0) {
                        System.out.println("No accounts registered yet. Please register first.\n");
                        break;
                    }

                    System.out.print("Enter your email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = sc.nextLine();

                    boolean found = false;
                    Account loggedUser = null;

                    for (Account account : accounts) {
                        if (account.email.equals(loginEmail) && account.password.equals(loginPassword)) {
                            loggedUser = account;
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("\nLogin successful!");
                        System.out.println("Welcome, " + loggedUser.name + "!\n");

                        int option2;

                        do {
                            System.out.println("=== WELCOME " + loggedUser.name + " ===");
                            System.out.println("What do you want to do?");
                            System.out.println(">>> [1] Deposit");
                            System.out.println(">>> [2] Withdraw");
                            System.out.println(">>> [3] Transfer");
                            System.out.println(">>> [4] See balance");
                            System.out.println(">>> [5] Exit");
                            System.out.print("Which one do you want to choose? : ");
                            option2 = sc.nextInt();
                            sc.nextLine();

                            switch (option2) {
                                case 1:
                                    System.out.print("Enter deposit amount: ");
                                    double amount = sc.nextDouble();
                                    sc.nextLine();
                                    loggedUser.deposit(amount);
                                    break;

                                case 2:
                                    System.out.print("Enter withdraw amount: ");
                                    double withdrawAmount = sc.nextDouble();
                                    sc.nextLine();
                                    loggedUser.withdraw(withdrawAmount);
                                    break;

                                case 3:
                                    System.out.print("Enter destination email: ");
                                    String destinationEmail = sc.nextLine();

                                    Account destinationAccount = null;

                                    for (Account account : accounts) {
                                        if (account.email.equals(destinationEmail)) {
                                            destinationAccount = account;
                                            break;
                                        }
                                    }

                                    if (destinationAccount == null) {
                                        System.out.println("Destination account not found.");
                                    } else if (destinationAccount.email.equals(loggedUser.email)) {
                                        System.out.println("You cannot transfer to your own account.");
                                    } else {
                                        System.out.print("Enter transfer amount: ");
                                        double transferAmount = sc.nextDouble();
                                        sc.nextLine();
                                        loggedUser.transfer(destinationAccount, transferAmount);
                                    }
                                    break;

                                case 4:
                                    loggedUser.showBalance();
                                    break;

                                case 5:
                                    System.out.println("Returning to main menu...\n");
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }

                            System.out.println();

                        } while (option2 != 5);

                    } else {
                        System.out.println("\nIncorrect email or password.\n");
                    }

                    break;

                case 2:
                    System.out.println("\n=== REGISTER ===");

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter your CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Enter your email: ");
                    String email = sc.nextLine();

                    System.out.print("Create a password: ");
                    String password = sc.nextLine();

                    Account newAccount = new Account(name, cpf, email, password);
                    accounts.add(newAccount);

                    System.out.println("\nUser registered successfully!\n");
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;
            }

        } while (option != 3);

        sc.close();
    }
}