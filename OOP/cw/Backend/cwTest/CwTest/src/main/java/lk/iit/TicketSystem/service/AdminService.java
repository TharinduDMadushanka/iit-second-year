package lk.iit.TicketSystem.service;

import lk.iit.TicketSystem.dto.AdminDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    String saveAdmin(AdminDTO adminDTO);

    AdminDTO loginAdmin(String email, String password);
}
