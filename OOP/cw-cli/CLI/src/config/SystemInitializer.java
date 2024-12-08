package config;

import dto.SystemConfigDTO;

import java.io.*;
import java.util.Scanner;

public class SystemInitializer {

    private static final String CONFIG_FILE = "system_config.txt";
    private final Scanner scanner = new Scanner(System.in);

    public SystemConfigDTO initializeSystemConfig() {

        System.out.println("Do you want to initialize system using previous config data? (y/n)");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("y") && new File(CONFIG_FILE).exists()) {

            return loadSystemConfigFile();

        }else {
            SystemConfigDTO config = getUserConfig();
            saveSystemConfigFile(config);
            return config;
        }

    }

    private SystemConfigDTO getUserConfig() {

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

    private void saveSystemConfigFile(SystemConfigDTO configDTO) {

        try (FileWriter fileWriter = new FileWriter(CONFIG_FILE)){

            fileWriter.write(configDTO.getTotalTickets()+"\n");
            fileWriter.write(configDTO.getTicketReleaseRate()+"\n");
            fileWriter.write(configDTO.getCustomerRetrievalRate()+"\n");
            fileWriter.write(configDTO.getMaxTicketCapacity()+"\n");
            System.out.println("Configuration data saved to " + CONFIG_FILE);

        } catch (IOException e) {
            System.out.println("An error occurred while saving system configuration file!");
        }

    }

    private SystemConfigDTO loadSystemConfigFile() {

        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE))){

            systemConfigDTO.setTotalTickets(Integer.parseInt(bufferedReader.readLine()));
            systemConfigDTO.setTicketReleaseRate(Integer.parseInt(bufferedReader.readLine()));
            systemConfigDTO.setCustomerRetrievalRate(Integer.parseInt(bufferedReader.readLine()));
            systemConfigDTO.setMaxTicketCapacity(Integer.parseInt(bufferedReader.readLine()));

            System.out.println("Configuration data loaded from " + CONFIG_FILE);
            saveSystemConfigFile(systemConfigDTO);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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


