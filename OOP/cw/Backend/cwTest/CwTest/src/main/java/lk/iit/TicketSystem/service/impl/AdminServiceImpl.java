package lk.iit.TicketSystem.service.impl;

import lk.iit.TicketSystem.dto.AdminDTO;
import lk.iit.TicketSystem.entity.Admin;
import lk.iit.TicketSystem.repo.AdminRepo;
import lk.iit.TicketSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public String saveAdmin(AdminDTO adminDTO) {

        Admin admin = new Admin(
                adminDTO.getAdminId(),
                adminDTO.getAdminName(),
                adminDTO.getEmail(),
                adminDTO.getPassword()
        );

        if (!adminRepo.existsById(admin.getAdminId())) {
            adminRepo.save(admin);
            return "Admin added..!";
        }else {
            return "Admin already exists!";
        }

    }

    @Override
    public AdminDTO loginAdmin(String email, String password) {

        List<Admin> admins = adminRepo.getAdminByEmailAndPassword(email,password);

        if (!admins.isEmpty()) {
            Admin admin = admins.get(0);
            return new AdminDTO(
                    admin.getAdminId(),
                    admin.getAdminName(),
                    admin.getEmail(),
                    admin.getPassword()
            );
        }else {
            return null;
        }

    }

}
