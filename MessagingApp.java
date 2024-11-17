import java.util.Scanner;

public class MessagingApp {
    public static void main(String[] args) {
        MessageManager messageManager = new MessageManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Messaging System Menu ---");
            System.out.println("1. Send a Message");
            System.out.println("2. Search Messages");
            System.out.println("3. Delete Messages for a Contact");
            System.out.println("4. Mark Messages as Read");
            System.out.println("5. Mark Messages as Unread");
            System.out.println("6. Display Messages for a Contact");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Sender ID: ");
                    String senderID = scanner.nextLine();
                    System.out.print("Enter Receiver ID: ");
                    String receiverID = scanner.nextLine();
                    System.out.print("Enter Message Text: ");
                    String text = scanner.nextLine();
                    messageManager.sendMessage(senderID, receiverID, text);
                    break;
                case 2:
                    System.out.print("Enter text to search for: ");
                    String searchText = scanner.nextLine();
                    messageManager.searchMessages(searchText);
                    break;
                case 3:
                    System.out.print("Enter contact ID to delete messages for: ");
                    String deleteID = scanner.nextLine();
                    messageManager.deleteMessagesForContact(deleteID);
                    break;
                case 4:
                    System.out.print("Enter contact ID to mark messages as read: ");
                    String readID = scanner.nextLine();
                    messageManager.markMessagesAsRead(readID);
                    break;
                case 5:
                    System.out.print("Enter contact ID to mark messages as unread: ");
                    String unreadID = scanner.nextLine();
                    messageManager.markMessagesAsUnread(unreadID);
                    break;
                case 6:
                    System.out.print("Enter contact ID to display messages for: ");
                    String displayID = scanner.nextLine();
                    messageManager.displayMessagesForContact(displayID);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
