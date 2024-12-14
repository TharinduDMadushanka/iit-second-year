package threads;

//Step 3: Update the Customer Class

import core.AbstractTicketHandler;
import core.TicketPool;
import logging.Logger;

public class Customer extends AbstractTicketHandler implements Runnable {

    public Customer(TicketPool ticketPool) {
        super(ticketPool);
    }

    @Override
    public void run() {
        while (true) {
            String ticket = ticketPool.removeTickets();

            if (ticket != null) {
//                System.out.println("Customer retrieved: " + ticket);
                Logger.log("Customer retrieved: " + ticket);
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
//                System.out.println("Customer interrupted");
                Logger.log("Customer interrupted");
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void handleTickets() {
        run();
    }
}
