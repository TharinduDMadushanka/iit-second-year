package lk.iit.TicketSystem.dto;

import lk.iit.TicketSystem.entity.Customer;
import lk.iit.TicketSystem.entity.Vendor;
import lk.iit.TicketSystem.util.enums.TicketType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


public class TicketDTO {

    private int ticketId;

    private String ticketName;

    private TicketType ticketType;

    private boolean ticketStatus;

    private double ticketPrice;

    private Date date;

    private int vendorId;

    public TicketDTO() {
    }

    public TicketDTO(int ticketId, String ticketName, TicketType ticketType, boolean ticketStatus, double ticketPrice, Date date, int vendorId) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.vendorId = vendorId;
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

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}
