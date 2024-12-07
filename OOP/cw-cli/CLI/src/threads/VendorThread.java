package threads;

import dto.SystemConfigDTO;

public class VendorThread implements Runnable {

    private final TicketPool ticketPool;
    private final SystemConfigDTO systemConfigDTO;

    public VendorThread(TicketPool ticketPool, SystemConfigDTO systemConfigDTO) {
        this.ticketPool = ticketPool;
        this.systemConfigDTO = systemConfigDTO;
    }

    @Override
    public void run() {
        int ticketCounter = 1;
        while (true) {
            String ticket = "Ticket " + ticketCounter++;
            ticketPool.addTicket();

            try {
                Thread.sleep(systemConfigDTO.getTicketReleaseRate());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Vendor thread interrupted");
                break;
            }

        }
    }
}
