package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    // Log file path
    private static final String LOG_FILE = "resources/logs.txt";

    // Method to log any message with timestamp
    public static void log(String message) {
        String timeStampedMessage = LocalDateTime.now() + " : " + message;

        // Print to console
        System.out.println(timeStampedMessage);

        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(timeStampedMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to log ticket operations (add/remove)
    public static void logTicketOperation(String operationType, String ticketID) {
        String formattedMessage = String.format(
                "Ticket Operation: %s | Ticket ID: %s | Timestamp: %s",
                operationType, ticketID, LocalDateTime.now()
        );
        log(formattedMessage); // Call the general log method
    }
}
