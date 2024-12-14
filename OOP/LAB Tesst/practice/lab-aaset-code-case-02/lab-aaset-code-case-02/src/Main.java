import config.Configuration;
import core.Customer;
import core.Ticket;
import core.TicketPool;
import logging.Logger;
import strategy.IDRetrieval;
import strategy.PriorityRetrieval;
import threads.Vendor;
import ui.CommandLineInterface;

import java.util.ArrayList;
import java.util.List;

/**
 2. Extending Customer Functionality with Interfaces
 Question:
 Refactor the system to allow customers to retrieve tickets either:
 • By ticket priority.
 • By ticket ID.
 Create an interface TicketRetrievalStrategy with methods for both retrieval approaches.
 Implement two concrete classes, PriorityRetrieval and IDRetrieval, and modify
 the Customer class to use these strategies. Write a test case to demonstrate both
 retrieval methods.
 */

/**
What We Will Do
Define an Interface:
Create an interface TicketRetrievalStrategy that specifies the methods for retrieving tickets.

Implement Two Concrete Strategies:

PriorityRetrieval: Retrieves tickets based on priority.
        IDRetrieval: Retrieves tickets based on ticket ID.
Update the Customer Class:
Modify the Customer class to use a TicketRetrievalStrategy. This allows customers to dynamically switch strategies (priority or ID retrieval).

Test Both Strategies:
Write a test case that demonstrates retrieving tickets using both strategies.
 */

//Step 1: Create the TicketRetrievalStrategy Interface
//Step 2: Implement Two Concrete Strategies
//Step 3: Update the Customer Class
//Step 4: Add a Ticket Class
//Step 5: Test the System

public class Main {
    public static void main(String[] args) {

//        Configuration config = CommandLineInterface.configureSystem();
//        TicketPool ticketPool = new TicketPool();
//
//        Thread vendor = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate()));
//
//        Thread customer = new Thread(new Customer(ticketPool));
//
//        vendor.start();
//        customer.start();
//
//        try {
//            vendor.join();
//            customer.join();
//        } catch (InterruptedException e) {
//            Logger.log("Main thread interrupted");
//            throw new RuntimeException(e);
//        }
//
//        Logger.log("System terminated");

        // Create a list of tickets
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("T1", 3)); // ID: T1, Priority: 3
        tickets.add(new Ticket("T2", 1)); // ID: T2, Priority: 1
        tickets.add(new Ticket("T3", 2)); // ID: T3, Priority: 2

        // Create a customer
        core.Customer customer = new Customer("John Doe");

        // Test Priority Retrieval Strategy
        System.out.println("Testing Priority Retrieval...");
        customer.setRetrievalStrategy(new PriorityRetrieval());
        Ticket priorityTicket = customer.retrieveTicket(tickets);
        System.out.println("Retrieved Ticket: " + priorityTicket);

        // Test ID Retrieval Strategy
        System.out.println("\nTesting ID Retrieval...");
        customer.setRetrievalStrategy(new IDRetrieval());
        Ticket idTicket = customer.retrieveTicket(tickets);
        System.out.println("Retrieved Ticket: " + idTicket);

    }
}