package lk.iit.TicketSystem.service;

import lk.iit.TicketSystem.dto.VendorDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VendorService {
    String saveVendor(VendorDTO vendorDTO);
    String deleteVendor(int id);
    List<VendorDTO> getAllVendors();
    String updateVendor(VendorDTO vendorDTO);
    String startAllVendorThreads();
    String stopAllVendorThreads();
}