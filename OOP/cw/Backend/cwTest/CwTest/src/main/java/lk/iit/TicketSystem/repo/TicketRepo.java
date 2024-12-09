package lk.iit.TicketSystem.repo;

import lk.iit.TicketSystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTicketByTicketStatusFalse();
}
