package config;

import dto.SystemConfigDTO;

import java.util.Scanner;

public class SystemInitializer {

    private Scanner scanner = new Scanner(System.in);

    public SystemConfigDTO initializeSystemConfig() {

        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();

        System.out.println("=== Real-Time Event Ticketing System Configuration ===");

        // Prompt for Total Tickets
        systemConfigDTO.setTotalTickets(getValidatedInput("Enter the total number of tickets: ", 1, Integer.MAX_VALUE));

        // Prompt for Ticket Release Rate
        systemConfigDTO.setTicketReleaseRate(getValidatedInput("Enter the ticket release rate (tickets per millisecond): ", 1, 10000));

        // Prompt for Customer Retrieval Rate
        systemConfigDTO.setCustomerRetrievalRate(getValidatedInput("Enter the customer retrieval rate (tickets per millisecond): ", 1, 10000));

        // Prompt for Maximum Ticket Capacity
        systemConfigDTO.setMaxTicketCapacity(getValidatedInput("Enter the maximum ticket capacity: ", 1, Integer.MAX_VALUE));

        System.out.println("\nSystem Configuration Completed");
        System.out.println(systemConfigDTO);
        return systemConfigDTO;
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


