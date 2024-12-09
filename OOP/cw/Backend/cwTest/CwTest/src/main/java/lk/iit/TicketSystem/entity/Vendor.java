package lk.iit.TicketSystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lk.iit.TicketSystem.dto.VendorDTO;
import lk.iit.TicketSystem.util.enums.TicketType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id", nullable = false)
    private int vendorId;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "release_interval")
    private int releaseInterval;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @Column(name = "ticket_price")
    private double ticketPrice;

    @OneToMany(mappedBy = "vendor")
    private Set<Ticket> tickets;

    public Vendor() {
    }

    public Vendor(int vendorId, String vendorName, String email, int releaseInterval, TicketType ticketType, double ticketPrice) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.email = email;
        this.releaseInterval = releaseInterval;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    // Existing getters and setters


    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReleaseInterval() {
        return releaseInterval;
    }

    public void setReleaseInterval(int releaseInterval) {
        this.releaseInterval = releaseInterval;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}