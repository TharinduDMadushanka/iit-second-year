package lk.iit.TicketSystem.controller;

import lk.iit.TicketSystem.dto.VendorDTO;
import lk.iit.TicketSystem.service.VendorService;
import lk.iit.TicketSystem.util.StandardResponse;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/vendor")
public class VendorController {

    private static final Logger logger = LogManager.getLogger(VendorController.class);

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "/save-vendor")
    public ResponseEntity<StandardResponse> saveVendor(@RequestBody VendorDTO vendorDTO) {
        String message = vendorService.saveVendor(vendorDTO);

        if (message != null) {
            logger.info(vendorDTO.getVendorName()+ " saved successfully as a vendor!");
        } else {
            logger.error(vendorDTO.getVendorName()+ " saved failed!");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/delete-vendor", params = "id")
    public ResponseEntity<StandardResponse> deleteVendor(@RequestParam int id) {
        String message = vendorService.deleteVendor(id);

        if (message != null) {
            logger.info("Successfully deleted vendor: " + id);
        } else {
            logger.error("Vendor with id " + id + " not found!");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/start-all-vendor-threads")
    public ResponseEntity<StandardResponse> startAllVendorThreads() {
        String message = vendorService.startAllVendorThreads();
        logger.info(message);
        return new ResponseEntity<>(new StandardResponse(200, "Success", message), HttpStatus.OK);
    }

    @PostMapping(path = "/stop-all-vendor-threads")
    public ResponseEntity<StandardResponse> stopAllVendorThreads() {
        String message = vendorService.stopAllVendorThreads();
        logger.info(message);
        return new ResponseEntity<>(new StandardResponse(200, "Success", message), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-vendors")
    public ResponseEntity<List<VendorDTO>> getAllVendors() {
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        if (vendorDTOS != null) {
            logger.info("Vendor list found!");
        } else {
            logger.error("Vendor list not found!");
        }

        return ResponseEntity.status(200).body(vendorDTOS);
    }

    @PutMapping(path = "update-vendor")
    public ResponseEntity<StandardResponse> updateVendor(@RequestBody VendorDTO vendorDTO) {
        String message = vendorService.updateVendor(vendorDTO);

        if (message != null) {
            logger.info("Successfully updated vendor: " + vendorDTO.getVendorName());
        } else {
            logger.error("Vendor with id " + vendorDTO.getVendorId() + " not found for updating!");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }
}