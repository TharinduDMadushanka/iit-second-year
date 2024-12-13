package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TicketPool implements TicketOperation{

    private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());

    @Override
    public synchronized void addTickets(String tickets) {
        this.tickets.add(tickets);
    }

    @Override
    public String removeTickets() {
        return tickets.isEmpty() ? null : tickets.remove(0);
    }

    public int getTicketCount() {
        return tickets.size();
    }

}
