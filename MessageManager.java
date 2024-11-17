import java.util.ArrayList;

public class MessageManager {
    private ArrayList<Message> messages;

    // Constructor
    public MessageManager() {
        messages = new ArrayList<>();
    }

    // Send a message
    public void sendMessage(String senderID, String receiverID, String text) {
        Message newMessage = new Message(senderID, receiverID, text);
        messages.add(newMessage);
        System.out.println("Message sent!");
    }

    // Search messages by text
    public void searchMessages(String searchText) {
        boolean found = false;
        for (Message message : messages) {
            if (message.getText().toLowerCase().contains(searchText.toLowerCase())) {
                message.displayMessage();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages found containing: " + searchText);
        }
    }

    // Delete all messages for a specific contact
    public void deleteMessagesForContact(String contactID) {
        boolean found = messages.removeIf(message -> 
            message.getSenderID().equals(contactID) || message.getReceiverID().equals(contactID)
        );
        if (found) {
            System.out.println("All messages for contact ID " + contactID + " have been deleted.");
        } else {
            System.out.println("No messages found for contact ID: " + contactID);
        }
    }

    // Mark all messages from a specific contact as read
    public void markMessagesAsRead(String contactID) {
        boolean found = false;
        for (Message message : messages) {
            if (message.getSenderID().equals(contactID)) {
                message.markAsRead();
                found = true;
            }
        }
        if (found) {
            System.out.println("All messages from contact ID " + contactID + " marked as read.");
        } else {
            System.out.println("No messages found for contact ID: " + contactID);
        }
    }

    // Mark all messages from a specific contact as unread
    public void markMessagesAsUnread(String contactID) {
        boolean found = false;
        for (Message message : messages) {
            if (message.getSenderID().equals(contactID)) {
                message.markAsUnread();
                found = true;
            }
        }
        if (found) {
            System.out.println("All messages from contact ID " + contactID + " marked as unread.");
        } else {
            System.out.println("No messages found for contact ID: " + contactID);
        }
    }

    // Display all messages for a specific contact
    public void displayMessagesForContact(String contactID) {
        boolean found = false;
        for (Message message : messages) {
            if (message.getSenderID().equals(contactID) || message.getReceiverID().equals(contactID)) {
                message.displayMessage();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages found for contact ID: " + contactID);
        }
    }
}
