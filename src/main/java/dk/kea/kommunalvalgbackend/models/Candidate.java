package dk.kea.kommunalvalgbackend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="candidates")
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private Party party;
}
