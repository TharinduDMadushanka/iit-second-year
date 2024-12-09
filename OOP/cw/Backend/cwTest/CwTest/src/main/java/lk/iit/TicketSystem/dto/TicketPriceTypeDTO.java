package lk.iit.TicketSystem.dto;

import lk.iit.TicketSystem.util.enums.TicketType;

public class TicketPriceTypeDTO {

    private TicketType ticketType;
    private double ticketPrice;

    public TicketPriceTypeDTO() {
    }

    public TicketPriceTypeDTO(TicketType ticketType, double ticketPrice) {
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
