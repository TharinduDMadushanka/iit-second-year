package strategy;

//Step 2: Implement Two Concrete Strategies
//IDRetrieval: Retrieves tickets based on ticket ID.

import core.Ticket;

import java.util.Comparator;
import java.util.List;

public class IDRetrieval implements TicketRetrievalStrategy {

    @Override
    public Ticket retrieveTicket(List<Ticket> tickets) {
        // Find the ticket with the smallest ID
        return tickets.stream()
                .min(Comparator.comparing(Ticket::getTicketID))
                .orElse(null); // Return null if no tickets are available
    }
}
