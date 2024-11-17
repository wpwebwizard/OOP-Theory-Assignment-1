import java.io.*;
import java.net.*;

public class MessagingClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");

            // Create a thread to handle receiving messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println("Server: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Error receiving message: " + e.getMessage());
                }
            });

            receiveThread.start(); // Start the receiving thread

            // Main thread for sending messages to the server
            String clientMessage;
            while (true) {
                System.out.print("Enter message to server (SenderID;ReceiverID;MessageText) or 'exit' to quit: ");
                clientMessage = userInput.readLine();
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(clientMessage);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
