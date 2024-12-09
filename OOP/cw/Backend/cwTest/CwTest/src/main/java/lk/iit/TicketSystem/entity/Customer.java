package lk.iit.TicketSystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "retrieval_interval")
    private int retrievalInterval;

    @OneToMany(mappedBy = "customer")
    private Set<TicketPurchase> ticketPurchases;


    public Customer() {
    }

    public Customer(int customerId, String customerName, String email, String phone, String password, int retrievalInterval) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.retrievalInterval = retrievalInterval;
    }

    public Customer(int customerId, String customerName, String email, String phone, String password, int retrievalInterval, Set<TicketPurchase> ticketPurchases) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.retrievalInterval = retrievalInterval;
        this.ticketPurchases = ticketPurchases;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRetrievalInterval() {
        return retrievalInterval;
    }

    public void setRetrievalInterval(int retrievalInterval) {
        this.retrievalInterval = retrievalInterval;
    }

    public Set<TicketPurchase> getTicketPurchases() {
        return ticketPurchases;
    }

    public void setTicketPurchases(Set<TicketPurchase> ticketPurchases) {
        this.ticketPurchases = ticketPurchases;
    }
}
