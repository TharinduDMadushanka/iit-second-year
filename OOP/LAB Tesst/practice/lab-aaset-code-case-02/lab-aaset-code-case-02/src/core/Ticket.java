package core;

//Step 4: Add a Ticket Class

public class Ticket {

    private final String ticketID;
    private final int priority;

    public Ticket(String ticketID, int priority) {
        this.ticketID = ticketID;
        this.priority = priority;
    }

    public String getTicketID() {
        return ticketID;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Ticket{ID='" + ticketID + "', Priority=" + priority + "}";
    }
}
