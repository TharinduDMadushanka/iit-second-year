package lk.iit.TicketSystem.dto;

import lk.iit.TicketSystem.util.enums.TicketType;

import java.util.Date;

public class TicketPurchaseDTO {


    private int purchaseID;

    private Date purchaseDate;

    private TicketType ticketType;

    private int customerID;

    private int ticketId;

    public TicketPurchaseDTO() {
    }

    public TicketPurchaseDTO(int purchaseID, Date purchaseDate, TicketType ticketType, int customerID, int ticketId) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.ticketType = ticketType;
        this.customerID = customerID;
        this.ticketId = ticketId;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
