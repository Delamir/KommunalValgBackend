package dk.kea.kommunalvalgbackend.controllers;

import dk.kea.kommunalvalgbackend.models.Candidate;
import dk.kea.kommunalvalgbackend.models.Party;
import dk.kea.kommunalvalgbackend.repositories.CandidateRepository;
import dk.kea.kommunalvalgbackend.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartyController {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/parties")
    public List<Party> getParties() {
        return partyRepository.findAll();
    }

    @GetMapping("/parties/candidates/{partyid}")
    public List<Candidate> getCandidatesInSpecificParty(@PathVariable Long partyid) {
        Party party = partyRepository.findById(partyid).get();
        return candidateRepository.findAllByParty(party);
    }
}
