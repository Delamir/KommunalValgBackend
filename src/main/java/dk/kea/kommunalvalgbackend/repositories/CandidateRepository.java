package dk.kea.kommunalvalgbackend.repositories;

import dk.kea.kommunalvalgbackend.models.Candidate;
import dk.kea.kommunalvalgbackend.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findAllByParty(Party party);
}
