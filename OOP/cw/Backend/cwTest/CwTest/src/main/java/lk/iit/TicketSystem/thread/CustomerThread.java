package lk.iit.TicketSystem.thread;

import lk.iit.TicketSystem.entity.Customer;
import lk.iit.TicketSystem.entity.Ticket;
import lk.iit.TicketSystem.entity.TicketPurchase;
import lk.iit.TicketSystem.repo.CustomerRepo;
import lk.iit.TicketSystem.repo.TicketPurchaseRepo;
import lk.iit.TicketSystem.repo.TicketRepo;

import javax.transaction.Transactional;
import java.util.Date;

public class CustomerThread implements Runnable {

    private final Customer customer;
    private final TicketPool ticketPool;
    private final CustomerRepo customerRepo;
    private final TicketRepo ticketRepo;
    private final TicketPurchaseRepo ticketPurchaseRepo;
    private final int customerRetrievalRate;
    private volatile boolean running = true;

    public CustomerThread(Customer customer, TicketPool ticketPool, CustomerRepo customerRepo, TicketRepo ticketRepo, TicketPurchaseRepo ticketPurchaseRepo, int customerRetrievalRate) {
        this.customer = customer;
        this.ticketPool = ticketPool;
        this.customerRepo = customerRepo;
        this.ticketRepo = ticketRepo;
        this.ticketPurchaseRepo = ticketPurchaseRepo;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    @Transactional
    public void run() {
        while (running) {
            try {
                // Step 1: Remove a ticket from the pool
                Ticket ticket = ticketPool.removeTicket(customer.getCustomerId());

                if (ticket != null) {
                    // Step 2: Mark the ticket as purchased (status = true)
                    ticket.setTicketStatus(true);
                    ticketRepo.save(ticket);

                    // Step 3: Save the ticket purchase details
                    TicketPurchase purchase = new TicketPurchase();
                    purchase.setPurchaseDate(new Date());
                    purchase.setTicketType(ticket.getTicketType());
                    purchase.setCustomer(customer);
                    purchase.setTicket(ticket);

                    ticketPurchaseRepo.save(purchase);

                    System.out.println("Customer " + customer.getCustomerId() + " purchased ticket: " + ticket.getTicketName());
                } else {
                    System.out.println("No tickets available for Customer " + customer.getCustomerId());
                }

                // Step 4: Simulate retrieval rate
                Thread.sleep(customerRetrievalRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer thread interrupted.");
                break;
            }
        }
    }
}
