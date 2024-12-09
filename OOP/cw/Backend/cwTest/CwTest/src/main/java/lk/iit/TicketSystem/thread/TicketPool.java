package lk.iit.TicketSystem.thread;

import lk.iit.TicketSystem.entity.Ticket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private final Queue<Ticket> tickets = new LinkedList<>();
    private final int maxCapacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTicket(int vendorId, Ticket ticket) {
        lock.lock();
        try {
            while (tickets.size() >= maxCapacity) {
                System.out.println("TicketPool is full. Vendor " + vendorId + " is waiting...");
                notFull.await(); // Wait until there is space in the pool
            }
            tickets.add(ticket);
            System.out.println("Vendor " + vendorId + " added ticket: " + ticket.toString());
            notEmpty.signalAll(); // Notify customers that a ticket is available
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println("Vendor thread interrupted while adding a ticket.");
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

    public synchronized Ticket removeTicket(int customerId) {
        lock.lock();
        try {
            while (tickets.isEmpty()) {
                System.out.println("TicketPool is empty. Customer " + customerId + " is waiting...");
                notEmpty.await(); // Wait until there is at least one ticket
            }
            Ticket ticket = tickets.poll(); // Remove the first ticket
            System.out.println("Customer " + customerId + " purchased ticket: " + ticket.toString());
            notFull.signalAll(); // Notify vendors that space is available
            return ticket;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println("Customer thread interrupted while removing a ticket.");
            return null;
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

}
