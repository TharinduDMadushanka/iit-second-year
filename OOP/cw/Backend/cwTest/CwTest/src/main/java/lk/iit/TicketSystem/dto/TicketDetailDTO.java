package lk.iit.TicketSystem.dto;

import lk.iit.TicketSystem.util.enums.TicketType;

public class TicketDetailDTO {

    private double ticketPrice;
    private TicketType ticketType;
    private int ticketCount;

    public TicketDetailDTO() {
    }

    public TicketDetailDTO(double ticketPrice, TicketType ticketType, int ticketCount) {
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
        this.ticketCount = ticketCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
