package lk.iit.TicketSystem.service.impl;

import lk.iit.TicketSystem.entity.Customer;
import lk.iit.TicketSystem.entity.Ticket;
import lk.iit.TicketSystem.entity.TicketPurchase;
import lk.iit.TicketSystem.repo.CustomerRepo;
import lk.iit.TicketSystem.repo.TicketPurchaseRepo;
import lk.iit.TicketSystem.repo.TicketRepo;
import lk.iit.TicketSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private TicketPurchaseRepo ticketPurchaseRepo;

    @Override
    public String purchaseTicket(int ticketId, int customerId) {
        // Step 1: Validate the customer
        Customer customer = customerRepo.findById(customerId).orElseThrow(() ->
                new RuntimeException("Customer with ID " + customerId + " not found.")
        );

        // Step 2: Validate the ticket
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() ->
                new RuntimeException("Ticket with ID " + ticketId + " not found.")
        );

        // Step 3: Check if the ticket is already purchased
        if (ticket.isTicketStatus()) {
            throw new RuntimeException("Ticket with ID " + ticketId + " is already purchased.");
        }

        // Step 4: Update the ticket status
        ticket.setTicketStatus(true);
        ticketRepo.save(ticket);

        // Step 5: Save the ticket purchase record
        TicketPurchase purchase = new TicketPurchase();
        purchase.setPurchaseDate(new Date());
        purchase.setTicketType(ticket.getTicketType());
        purchase.setCustomer(customer);
        purchase.setTicket(ticket);

        ticketPurchaseRepo.save(purchase);

        // Step 6: Return confirmation
        return "Ticket with ID " + ticketId + " successfully purchased by Customer ID " + customerId + ".";
    }

    @Override
    public List<Ticket> getAllTickets() {
//        List<Ticket> allTickets = ticketRepo.findAll();

        List<Ticket> allTickets = ticketRepo.findTicketByTicketStatusFalse();

        if (allTickets.isEmpty()) {
            return null;
        }else {
            return allTickets;
        }

    }
}

