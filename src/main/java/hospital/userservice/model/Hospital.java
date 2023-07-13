package hospital.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private UUID hospitalCode;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String shortName;
    @Column(nullable = false)
    private String place;
    @Column(nullable = false)
    private String address;
}
