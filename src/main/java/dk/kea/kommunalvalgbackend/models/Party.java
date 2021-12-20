package dk.kea.kommunalvalgbackend.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name="parties")
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String party;

    @Column
    private String votes;
}
