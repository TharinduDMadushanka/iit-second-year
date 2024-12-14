package core;

import logging.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TicketPool {

    private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());

    // Add tickets to the pool and log the operation
    public synchronized void addTickets(String ticketID) {
        tickets.add(ticketID);
        Logger.logTicketOperation("ADD", ticketID);
    }

    // Remove a ticket from the pool and log the operation
    public synchronized String removeTickets() {
        if (tickets.isEmpty()) {
            return null; // No tickets to remove
        }
        String ticketID = tickets.remove(0);
        Logger.logTicketOperation("REMOVE", ticketID);
        return ticketID;
    }

    // Get the current ticket count
    public int getTicketCount() {
        return tickets.size();
    }
}
/**
Explanation:
    addTickets():

    Adds a ticket to the synchronized list.
    Logs the operation using Logger.logTicketOperation("ADD", ticketID).
    removeTickets():

    Removes a ticket from the list.
    Logs the operation with "REMOVE" and the ticket ID.
    Returns null if no tickets are available.
*/