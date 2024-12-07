package threads;

import dto.SystemConfigDTO;

public class CustomerThread implements Runnable {

    private final TicketPool ticketPool;
    private final SystemConfigDTO systemConfigDTO;

    public CustomerThread(TicketPool ticketPool, SystemConfigDTO systemConfigDTO) {
        this.ticketPool = ticketPool;
        this.systemConfigDTO = systemConfigDTO;
    }


    @Override
    public void run() {
        while (true) {
            ticketPool.removeTicket();

            try {
                Thread.sleep(systemConfigDTO.getCustomerRetrievalRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer thread interrupted");
                break;
            }
        }
    }
}
