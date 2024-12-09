package lk.iit.TicketSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.iit.TicketSystem.util.enums.TicketType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @Column(name = "ticket_status")
    private boolean ticketStatus;

    @Column(name = "ticket_price")
    private double ticketPrice;

    @Column(name = "date")
    private Date date;

    @ManyToOne
//    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @OneToMany(mappedBy = "ticket")
    private Set<TicketPurchase> ticketPurchases;

    public Ticket() {
    }

    public Ticket(int ticketId, String ticketName, TicketType ticketType, boolean ticketStatus, double ticketPrice, Date date, Vendor vendor) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.vendor = vendor;
    }

    public Ticket(int ticketId, String ticketName, TicketType ticketType, boolean ticketStatus, double ticketPrice, Date date, Vendor vendor, Set<TicketPurchase> ticketPurchases) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.vendor = vendor;
        this.ticketPurchases = ticketPurchases;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Set<TicketPurchase> getTicketPurchases() {
        return ticketPurchases;
    }

    public void setTicketPurchases(Set<TicketPurchase> ticketPurchases) {
        this.ticketPurchases = ticketPurchases;
    }
}
