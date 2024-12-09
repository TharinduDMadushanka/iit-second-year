package lk.iit.TicketSystem.controller;

import lk.iit.TicketSystem.dto.AdminDTO;
import lk.iit.TicketSystem.service.AdminService;
import lk.iit.TicketSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/save-admin")
    public ResponseEntity<StandardResponse> saveAdmin(@RequestBody AdminDTO adminDTO) {

        String message = adminService.saveAdmin(adminDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );

    }

    @GetMapping("/admin-login/{email}/{password}")
    public ResponseEntity<StandardResponse> adminLogin(@PathVariable String email, @PathVariable String password) {

        AdminDTO adminDTO = adminService.loginAdmin(email,password);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",adminDTO), HttpStatus.CREATED
        );

    }

}
