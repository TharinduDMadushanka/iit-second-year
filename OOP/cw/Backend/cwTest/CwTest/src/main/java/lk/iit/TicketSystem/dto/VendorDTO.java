package lk.iit.TicketSystem.dto;

import lk.iit.TicketSystem.util.enums.TicketType;

public class VendorDTO {
    private int vendorId;
    private String vendorName;
    private String email;
    private int releaseInterval;
    private TicketType ticketType;
    private double ticketPrice;

    public VendorDTO() {
    }

    public VendorDTO(int vendorId, String vendorName, String email, int releaseInterval, TicketType ticketType, double ticketPrice) {
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
}