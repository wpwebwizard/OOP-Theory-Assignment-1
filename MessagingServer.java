import java.io.*;
import java.net.*;

public class MessagingServer {
    private ServerSocket serverSocket;
    private MessageManager messageManager;

    public MessagingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        messageManager = new MessageManager(); // Initialize MessageManager
    }

    public void start() {
        System.out.println("Server is running and waiting for connections...");
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("Client connected.");

            // Create a thread to handle receiving messages from the client
            Thread receiveThread = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received: " + inputLine);

                        // Parse and add the message
                        String[] parts = inputLine.split(";", 3);
                        if (parts.length == 3) {
                            String senderID = parts[0].trim();
                            String receiverID = parts[1].trim();
                            String text = parts[2].trim();

                            addMessage(senderID, receiverID, text);
                            System.out.println("Message added to server.");
                        } else {
                            System.out.println("Invalid message format.");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error receiving message: " + e.getMessage());
                }
            });

            receiveThread.start(); // Start the receiving thread

            // Main thread for sending messages to the client
            try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
                String userMessage;
                while (true) {
                    System.out.print("Enter message to client (SenderID;ReceiverID;MessageText) or 'exit' to quit: ");
                    userMessage = userInput.readLine();
                    if (userMessage.equalsIgnoreCase("exit")) {
                        break;
                    }
                    out.println(userMessage);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addMessage(String senderID, String receiverID, String text) {
        // Use the MessageManager to add the message
        messageManager.sendMessage(senderID, receiverID, text);
    }

    public static void main(String[] args) {
        int port = 12345;
        try {
            MessagingServer server = new MessagingServer(port);
            server.start();
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }
}
