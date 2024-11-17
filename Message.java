import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String senderID;
    private String receiverID;
    private String text;
    private LocalDateTime timestamp;
    private boolean isRead;

    // Constructor
    public Message(String senderID, String receiverID, String text) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.text = text;
        this.timestamp = LocalDateTime.now(); // Record current time
        this.isRead = false; // Default unread
    }

    // Getters
    public String getSenderID() {
        return senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public String getText() {
        return text;
    }

    public boolean isRead() {
        return isRead;
    }

    // Mark the message as read
    public void markAsRead() {
        this.isRead = true;
    }

    // Mark the message as unread
    public void markAsUnread() {
        this.isRead = false;
    }

    // Display message details
    public void displayMessage() {
        String status = isRead ? "Read" : "Unread";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + timestamp.format(formatter) + "] " + senderID + " -> " + receiverID + ": " 
                           + text + " (" + status + ")");
    }
}
