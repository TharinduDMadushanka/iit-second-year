package lk.iit.TicketSystem.controller;

import lk.iit.TicketSystem.entity.Ticket;
import lk.iit.TicketSystem.service.TicketService;
import lk.iit.TicketSystem.util.StandardResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RequestMapping("api/v1/ticket")
public class TicketController {

    private static final Logger logger = LogManager.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

//    @PostMapping(
//            path = "/ticket-purchase",
//            params = {"ticketId", "customerId"}
//    )
//    public ResponseEntity<StandardResponse> purchaseTicket(
//            @RequestParam(name = "ticketId") int ticketId,
//            @RequestParam(name = "customerId") int customerId
//    ) {
//        String purchaseData = ticketService.purchaseTicket(ticketId, customerId);
//
//        return new ResponseEntity<>(
//                new StandardResponse(201, "Success", purchaseData),
//                HttpStatus.CREATED
//        );
//    }

    @PostMapping("/ticket-purchase/{ticketId}/{customerId}")
    public ResponseEntity<StandardResponse> purchaseTicket(@PathVariable("ticketId") int ticketId,@PathVariable int customerId) {

        String purchaseData = ticketService.purchaseTicket(ticketId, customerId);

        if (purchaseData != null) {
            logger.info("customer "+customerId + " purchased ticket with id " + ticketId );
        }else {
            logger.error("Can't purchase ticket with id " + ticketId );
        }

        return new ResponseEntity<>(
                new StandardResponse(201, "Success", purchaseData),
                HttpStatus.CREATED
        );

    }

    @GetMapping(
            path = "/get-all-tickets"
    )
    public ResponseEntity<StandardResponse> getAllTickets() {
        List<Ticket> tickets =ticketService.getAllTickets();

        if (tickets != null) {
            logger.info("Ticket list found.!");
        }else {
            logger.error("No tickets found!");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", tickets), HttpStatus.CREATED
        );
    }
}

