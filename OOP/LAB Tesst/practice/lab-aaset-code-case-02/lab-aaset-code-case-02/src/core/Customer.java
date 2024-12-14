package core;

//Step 3: Update the Customer Class

import strategy.TicketRetrievalStrategy;

import java.util.List;

public class Customer {

    private final String customerName;
    private TicketRetrievalStrategy retrievalStrategy;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    // Set the strategy dynamically
    public void setRetrievalStrategy(TicketRetrievalStrategy strategy) {
        this.retrievalStrategy = strategy;
    }

    // Retrieve a ticket using the current strategy
    public Ticket retrieveTicket(List<Ticket> tickets) {
        if (retrievalStrategy == null) {
            throw new IllegalStateException("Retrieval strategy not set.");
        }
        return retrievalStrategy.retrieveTicket(tickets);
    }

    public String getCustomerName() {
        return customerName;
    }
}
