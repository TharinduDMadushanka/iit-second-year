import config.SystemInitializer;
import dto.SystemConfigDTO;
import threads.CustomerThread;
import threads.TicketPool;
import threads.VendorThread;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        SystemInitializer initializer = new SystemInitializer();
        SystemConfigDTO config = initializer.initializeSystemConfig();
        TicketPool ticketPool = new TicketPool(config);

        boolean controlChoice = false;

        do {

            System.out.print("Do you want to start the system? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("y")) {

                // Start vendor threads
                int vendorCount = config.getTotalTickets() / config.getMaxTicketCapacity();
                for (int i = 1; i <= vendorCount; i++) {
                    Thread vendorThread = new Thread(new VendorThread(ticketPool, config), "Vendor-" + i);
                    vendorThread.start();
                }

                // Start customer threads
                int customerCount = 10; // You can decide how many customers participate
                for (int i = 1; i <= customerCount; i++) {
                    Thread customerThread = new Thread(new CustomerThread(ticketPool, config), "Customer-" + i);
                    customerThread.start();
                }

                controlChoice = true;

            } else if (choice.equals("n")) {
                System.out.println("System configuration data is saved & exit from the system!");
                controlChoice = true;
            }else {
                System.out.println("Enter a valid choice(y/n)");
            }

        }while(!controlChoice);


    }
}
