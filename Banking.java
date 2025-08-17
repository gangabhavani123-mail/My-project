import java.util.Scanner;

// Abstract class for common banking operations
abstract class AbstractBank {
    abstract void addCustomer(String name, int accountNumber, double balance);
    abstract void deleteCustomer(int accountNumber);
    abstract void showCustomers();

    // Abstract method for statistics
    abstract void showStatistics();
}

// Node to store customer details
class CustomerNode {
    String name;
    int accountNumber;
    double balance;
    String status; // "completed" or "pending"
    CustomerNode next, prev;

    CustomerNode(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = "pending"; // default
    }
}

// Implementation using a doubly linked list
class DoublyBankList extends AbstractBank {
    private CustomerNode head;

    public void addCustomer(String name, int accountNumber, double balance) {
        CustomerNode newNode = new CustomerNode(name, accountNumber, balance);

        if (head == null) {
            head = newNode;
        } else {
            CustomerNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Customer added successfully!");
    }

    public void deleteCustomer(int accountNumber) {
        if (head == null) {
            System.out.println("No customers to delete.");
            return;
        }
        CustomerNode temp = head;
        while (temp != null && temp.accountNumber != accountNumber) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
        System.out.println("Customer deleted successfully!");
    }

    public void showCustomers() {
        if (head == null) {
            System.out.println("No customers available.");
            return;
        }
        CustomerNode temp = head;
        System.out.println("\n--- Customer List ---");
        while (temp != null) {
            System.out.println("[Name: " + temp.name +
                               " | Account: " + temp.accountNumber +
                               " | Balance: " + temp.balance +
                               " | Status: " + temp.status + "]");
            temp = temp.next;
        }
    }

    // Show statistics
    public void showStatistics() {
        int total = 0, completed = 0, pending = 0;
        CustomerNode temp = head;

        while (temp != null) {
            total++;
            if (temp.status.equalsIgnoreCase("completed")) {
                completed++;
            } else {
                pending++;
            }
            temp = temp.next;
        }

        System.out.println("\n=== Customer Statistics ===");
        System.out.println("Total customers : " + total);
        System.out.println("Completed       : " + completed);
        System.out.println("Pending         : " + pending);
    }
}

// Main Banking System class
public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractBank bank = new DoublyBankList();

        int choice = 0;

        do {
            System.out.println("\n===== BANKING MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. View Customers");
            System.out.println("4. Show Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    sc.nextLine(); // consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    bank.addCustomer(name, accNo, balance);
                    break;

                case 2:
                    System.out.print("Enter account number to delete: ");
                    int delAccNo = sc.nextInt();
                    bank.deleteCustomer(delAccNo);
                    break;

                case 3:
                    bank.showCustomers();
                    break;

                case 4:
                    bank.showStatistics();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
