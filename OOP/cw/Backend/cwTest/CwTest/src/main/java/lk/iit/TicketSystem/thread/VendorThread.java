package lk.iit.TicketSystem.thread;

import lk.iit.TicketSystem.dto.ConfigurationDTO;
import lk.iit.TicketSystem.entity.Ticket;
import lk.iit.TicketSystem.entity.Vendor;
import lk.iit.TicketSystem.repo.TicketRepo;

import java.util.Date;

public class VendorThread implements Runnable {
    private final Vendor vendor;
    private final TicketRepo ticketRepo;
    private final ConfigurationDTO configurationDTO;
    private volatile boolean running = true;
    private int ticketsCreated = 0;

    public VendorThread(Vendor vendor, TicketRepo ticketRepo, ConfigurationDTO configurationDTO) {
        this.vendor = vendor;
        this.ticketRepo = ticketRepo;
        this.configurationDTO = configurationDTO;
    }

    public void stopThread() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            while (running && ticketsCreated < configurationDTO.getMaxTicketCapacity()) {
                Ticket ticket = createTicket();
                ticketRepo.save(ticket);
                ticketsCreated++;

                System.out.println("Vendor " + vendor.getVendorId() +
                        ": Created ticket " + ticketsCreated + " of " +
                        configurationDTO.getMaxTicketCapacity());

                // Sleep for the configured release rate
                Thread.sleep(configurationDTO.getTicketReleaseRate());
            }

            if (ticketsCreated >= configurationDTO.getMaxTicketCapacity()) {
                System.out.println("Vendor " + vendor.getVendorId() +
                        ": Reached maximum ticket capacity of " +
                        configurationDTO.getMaxTicketCapacity());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Vendor " + vendor.getVendorId() + " thread interrupted.");
        }
    }

    private Ticket createTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketName("Vendor " + vendor.getVendorId() + " - Ticket " + (ticketsCreated + 1));
        ticket.setTicketType(vendor.getTicketType());
        ticket.setTicketStatus(false);
        ticket.setTicketPrice(vendor.getTicketPrice());
        ticket.setDate(new Date());
        ticket.setVendor(vendor);
        return ticket;
    }
}