import config.SystemInitializer;
import dto.SystemConfigDTO;
import threads.CustomerThread;
import threads.TicketPool;
import threads.VendorThread;

public class Main {
    public static void main(String[] args) {
        SystemInitializer initializer = new SystemInitializer();
        SystemConfigDTO config = initializer.initializeSystemConfig();
        TicketPool ticketPool = new TicketPool(config);

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
    }
}
