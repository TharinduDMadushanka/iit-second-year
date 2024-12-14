package strategy;

//Step 1: Create the TicketRetrievalStrategy Interface

import core.Ticket;

import java.util.List;

public interface TicketRetrievalStrategy {
    Ticket retrieveTicket(List<Ticket> tickets); // Define a method to retrieve tickets
}
