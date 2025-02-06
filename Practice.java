import java.util.Scanner;

class Stack {
    int top;
    int arr[] = new int[5];

    Stack() {
        top = -1;
        for (int i = 0; i <= 4; i++) {
            arr[i] = 0;
        }
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (top == 4) {
            return true;
        } else {
            return false;
        }
    }

    void pushItem(int item) {
        if (isFull()) {
            System.out.println("Stack is Full!");
        } else {
            top++;
            arr[top] = item;
            System.out.println("Item is pushed in the Stack!");
        }
    }

    int popItem() {
        int popedItem;

        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return 0;
        } else {
            popedItem = arr[top];
            arr[top] = 0;
            top--;
            System.out.println("Top item is poped!");
            return popedItem;
        }
    }

    int peekItem(int position) {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return 0;
        } else {
            return arr[position];
        }
    }

    void updateItem(int position, int newItem) {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
        } else {
            arr[position] = newItem;
            System.out.println("item is updated!");
        }
    }

    int countItem() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return 0;
        } else {
            return (top + 1);
        }
    }

    void displayItem() {
        System.out.println("=== All Stack Items ===");
        for (int i = 4; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();
        int option, position, value;

        do {
            System.out.println("Enter 0 for exit from program -> ");
            System.out.println("Enter 1 for check stack is full -> ");
            System.out.println("Enter 2 for check stack is empty -> ");
            System.out.println("Enter 3 for push item in stack -> ");
            System.out.println("Enter 4 for pop item from stack -> ");
            System.out.println("Enter 5 for peek item from stack -> ");
            System.out.println("Enter 6 for update item in stack -> ");
            System.out.println("Enter 7 for count item of stack -> ");
            System.out.println("Enter 8 for display all item of stack -> ");
            System.out.println("Enter 9 for clear screen ->");

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    if (stack.isFull()) {
                        System.out.println("Yes! Stack is Full!");
                    } else {
                        System.out.println("No! Stack is not Full!");
                    }
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Yes! Stack is Empty!");
                    } else {
                        System.out.println("No! Stack is not Empty!");
                    }
                    break;

                case 3:
                    System.out.println("Enter an item for push in the Stack: ");
                    value = scanner.nextInt();
                    stack.pushItem(value);
                    break;

                case 4:
                    System.out.println("Pop method called!");
                    System.out.println("Poped item is: " + stack.popItem());
                    break;

                case 5:
                    System.out.println("Enter a position what you want to peek: ");
                    position = scanner.nextInt();
                    int peekedItem = stack.peekItem(position);
                    System.out.println("Peeked item is: " + peekedItem);
                    break;

                case 6:
                    System.out.println("Enter position and new item for update: ");
                    value = scanner.nextInt();
                    position = scanner.nextInt();
                    stack.updateItem(position, value);
                    break;

                case 7:
                    System.out.println("Total items are: " + stack.countItem());
                    break;

                case 8:
                    stack.displayItem();
                    break;

                case 9:
                    System.out.println("\033[H\033[2J");
                    break;

                default:
                    System.out.println("Enter valid option!");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}