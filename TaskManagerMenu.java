import java.util.Scanner;
abstract class AbstractTaskList {
    abstract void addTask(String task, int priority);
    abstract void showTasks();
    abstract void deleteTask(String task);
}
class TaskNode {
    String taskName;
    int priority;
    TaskNode next;
    TaskNode prev;
    TaskNode(String name, int priority) {
        this.taskName = name;
        this.priority = priority;
        this.prev = null;
        this.next = null;
    }
}
class DoublyTaskList extends AbstractTaskList {
    private TaskNode head;
    @Override
    void addTask(String name, int priority) {
        TaskNode newNode = new TaskNode(name, priority);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Task added: " + name + " [Priority: " + priority + "]");
    }
    @Override
    void showTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        System.out.println("\n--- Task List ---");
        while (temp != null) {
            System.out.println("Task: " + temp.taskName + " | Priority: " + temp.priority);
            temp = temp.next;
        }
    }
    @Override
    void deleteTask(String name) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        TaskNode temp = head;
        while (temp != null && !temp.taskName.equalsIgnoreCase(name)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Task not found: " + name);
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // deleting head
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        System.out.println("Deleted task: " + name);
    }
}
public class TaskManagerMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractTaskList taskList = new DoublyTaskList();
        int choice;
        do {
            System.out.println("\n===== Task Manager Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next(); 
            }
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter task priority (integer): ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Please enter a valid priority (integer): ");
                        sc.next();
                    }
                    int priority = sc.nextInt();
                    sc.nextLine(); // consume newline
                    taskList.addTask(name, priority);
                    break;
                case 2:
                    taskList.showTasks();
                    break;
                case 3:
                    System.out.print("Enter task name to delete: ");
                    String delName = sc.nextLine();
                    taskList.deleteTask(delName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
