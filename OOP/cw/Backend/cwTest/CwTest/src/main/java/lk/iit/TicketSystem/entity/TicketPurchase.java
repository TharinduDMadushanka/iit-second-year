package lk.iit.TicketSystem.entity;

import lk.iit.TicketSystem.util.enums.TicketType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_purchase")
public class TicketPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseID;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "ticket_type")
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    public TicketPurchase() {
    }

    public TicketPurchase(int purchaseID, Date purchaseDate, TicketType ticketType, Customer customer, Ticket ticket) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.ticketType = ticketType;
        this.customer = customer;
        this.ticket = ticket;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
