package lk.iit.TicketSystem.dto;

import javax.persistence.Column;

public class CustomerDTO {

    private int customerId;

    private String customerName;

    private String email;

    private String phone;

    private String password;

    private int retrievalInterval;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String email, String phone, String password, int retrievalInterval) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.retrievalInterval = retrievalInterval;
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
}
