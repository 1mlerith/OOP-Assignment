import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // default customers
        bank.addCustomer("John", "Stewart");
        bank.addCustomer("John", "Constantine");
        bank.getCustomer(0).setAccount(new Account(50000.00));
        bank.getCustomer(1).setAccount(new Account(1000000.00));

        int choice;
        do {
            System.out.println("==============================");
            System.out.println("            ATM Menu          ");
            System.out.println("==============================");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. List Customers");
            System.out.println("6. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initBalance = scanner.nextDouble();
                    scanner.nextLine();

                    bank.addCustomer(firstName, lastName);
                    bank.getCustomer(bank.getNumOfCustomers() - 1).setAccount(new Account(initBalance));
                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("No customers available.");
                        break;
                    }
                    printCustomerList(bank);
                    System.out.print("Select customer (index): ");
                    int depIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (depIndex < 0 || depIndex >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid customer index.");
                        break;
                    }

                    System.out.print("Enter deposit amount: ");
                    double depAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.getCustomer(depIndex).getAccount().deposit(depAmount)) {
                        System.out.println("Deposit successful!");
                        System.out.println("New balance: " + bank.getCustomer(depIndex).getAccount().getBalance());
                    } else {
                        System.out.println("Deposit failed. Invalid amount.");
                    }
                    break;

                case 3:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("No customers available.");
                        break;
                    }
                    printCustomerList(bank);
                    System.out.print("Select customer (index): ");
                    int wdIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (wdIndex < 0 || wdIndex >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid customer index.");
                        break;
                    }

                    System.out.print("Enter withdrawal amount: ");
                    double wdAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.getCustomer(wdIndex).getAccount().withdraw(wdAmount)) {
                        System.out.println("Withdrawal successful!");
                        System.out.println("New balance: " + bank.getCustomer(wdIndex).getAccount().getBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                    }
                    break;

                case 4:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("No customers available.");
                        break;
                    }
                    printCustomerList(bank);
                    System.out.print("Select customer (index): ");
                    int balIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (balIndex < 0 || balIndex >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid customer index.");
                        break;
                    }

                    Customer c = bank.getCustomer(balIndex);
                    System.out.println("Customer: " + c.getFirstName() + " " + c.getLastName());
                    System.out.println("Balance: " + c.getAccount().getBalance());
                    break;

                case 5:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("No customers available.");
                        break;
                    }
                    System.out.println("--- Customer List ---");
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer cust = bank.getCustomer(i);
                        System.out.println(i + ". " + cust.getFirstName() + " " + cust.getLastName());
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 6);

        scanner.close();
    }

    private static void printCustomerList(Bank bank) {
        System.out.println("--- Customers ---");
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer cust = bank.getCustomer(i);
            System.out.println(i + ". " + cust.getFirstName() + " " + cust.getLastName());
        }
    }
}
