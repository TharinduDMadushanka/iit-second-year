package lk.iit.TicketSystem.repo;

import lk.iit.TicketSystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    List<Admin> getAdminByEmailAndPassword(String email, String password);
}
