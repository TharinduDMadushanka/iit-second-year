package ex2;

public class Ticket {

    private static int numTicketSold;
    private int ticketNum;

    public Ticket() {
        numTicketSold++;
        ticketNum = numTicketSold;
    }

    public static int getNumTicketSold() {
        return numTicketSold;
    }

    public void setNumTicketSold(int numTicketSold) {
        this.numTicketSold = numTicketSold;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum++;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numTicketSold=" + numTicketSold +
                ", ticketNum=" + ticketNum +
                '}';
    }
}
