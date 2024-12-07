package threads;

import dto.SystemConfigDTO;

public class TicketPool {
    private final SystemConfigDTO systemConfigDTO;
    private int ticketsInPool = 0; // Tracks current tickets in the pool
    private int totalTicketsAdded = 0; // Tracks total tickets added
    private int totalTicketsSold = 0; // Tracks total tickets sold

    public TicketPool(SystemConfigDTO systemConfigDTO) {
        this.systemConfigDTO = systemConfigDTO;
    }

    public synchronized void addTicket() {
        while (ticketsInPool >= systemConfigDTO.getMaxTicketCapacity() ||
                totalTicketsAdded >= systemConfigDTO.getTotalTickets()) {
            try {
                wait(); // Wait until space is available or total tickets are sold
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Add ticket logic
        ticketsInPool++;
        totalTicketsAdded++;
        System.out.println(Thread.currentThread().getName() + " added a ticket. Tickets in pool: " + ticketsInPool);

        notifyAll(); // Notify waiting customer threads
    }

    public synchronized void removeTicket() {
        while (ticketsInPool <= 0 && totalTicketsSold < systemConfigDTO.getTotalTickets()) {
            try {
                wait(); // Wait until tickets are available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (totalTicketsSold >= systemConfigDTO.getTotalTickets()) {
            return; // Stop if all tickets are sold
        }

        // Remove ticket logic
        ticketsInPool--;
        totalTicketsSold++;
        System.out.println(Thread.currentThread().getName() + " purchased a ticket. Tickets left in pool: " + ticketsInPool);

        notifyAll(); // Notify waiting vendor threads
    }
}
