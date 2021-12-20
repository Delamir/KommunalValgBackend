package dk.kea.kommunalvalgbackend.repositories;

import dk.kea.kommunalvalgbackend.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
