package lk.iit.TicketSystem.service;

import lk.iit.TicketSystem.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    String purchaseTicket(int ticketId, int customerId);

    List<Ticket> getAllTickets();
}
