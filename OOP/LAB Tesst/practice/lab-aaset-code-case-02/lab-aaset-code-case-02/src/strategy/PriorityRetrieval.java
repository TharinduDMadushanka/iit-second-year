package strategy;

//Step 2: Implement Two Concrete Strategies
//PriorityRetrieval: Retrieves tickets based on priority.

import core.Ticket;

import java.util.Comparator;
import java.util.List;

public class PriorityRetrieval implements TicketRetrievalStrategy {

    @Override
    public Ticket retrieveTicket(List<Ticket> tickets) {
        // Find the ticket with the highest priority (lowest value of priority)
        return tickets.stream()
                .min(Comparator.comparingInt(Ticket::getPriority))
                .orElse(null); // Return null if no tickets are available
    }
}
