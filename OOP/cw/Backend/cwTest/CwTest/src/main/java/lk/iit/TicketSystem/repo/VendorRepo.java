package lk.iit.TicketSystem.repo;

import lk.iit.TicketSystem.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface VendorRepo extends JpaRepository<Vendor, Integer> {
}
