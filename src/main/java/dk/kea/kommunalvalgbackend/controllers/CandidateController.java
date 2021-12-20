package dk.kea.kommunalvalgbackend.controllers;

import dk.kea.kommunalvalgbackend.models.Candidate;
import dk.kea.kommunalvalgbackend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/candidates")
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @PostMapping("/candidates")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        candidate.setId(null);
        return candidateRepository.save(candidate);
    }

    @PatchMapping("/candidates/{id}")
    public String updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        try {
            candidateRepository.findById(id).map(foundCandidate -> {
                if (candidate.getName() != null) {
                    foundCandidate.setName(candidate.getName());
                }
                if (candidate.getParty() != null) {
                    foundCandidate.setParty(candidate.getParty());
                }
                candidateRepository.save(foundCandidate);
                return "Kandidat Opdateret";
            });
        } catch (Exception e) {
            e.printStackTrace();
            return "Kandidaten eksisterer ikke";
        }
        return null;
    }

    @DeleteMapping("/candidates/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateRepository.deleteById(id);
    }

}
