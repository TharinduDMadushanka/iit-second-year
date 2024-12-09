package lk.iit.TicketSystem.config;

import lk.iit.TicketSystem.dto.ConfigurationDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SystemInitializer {

    private final Scanner scanner = new Scanner(System.in);

    @Bean
    public ConfigurationDTO initializeSystem() {
        ConfigurationDTO configDTO = new ConfigurationDTO();

        System.out.println("=== Real-Time Event Ticketing System Configuration ===");

        // Prompt for Total Tickets
        configDTO.setTotalTickets(getValidatedInput("Enter the total number of tickets: ", 1, Integer.MAX_VALUE));

        // Prompt for Ticket Release Rate
        configDTO.setTicketReleaseRate(getValidatedInput("Enter the ticket release rate (tickets per millisecond): ", 1, 10000));

        // Prompt for Customer Retrieval Rate
        configDTO.setCustomerRetrievalRate(getValidatedInput("Enter the customer retrieval rate (tickets per millisecond): ", 1, 10000));

        // Prompt for Maximum Ticket Capacity
        configDTO.setMaxTicketCapacity(getValidatedInput("Enter the maximum ticket capacity: ", 1, Integer.MAX_VALUE));

        System.out.println("\nSystem Configuration Completed:");
        System.out.println(configDTO);
        return configDTO;
    }

    private int getValidatedInput(String prompt, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a value between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

}
