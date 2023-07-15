package hospital.userservice.model;

import hospital.userservice.model.enums.Profession;
import hospital.userservice.model.enums.Title;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private UUID employeeId = UUID.randomUUID();
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String jmbg;
    @Column(name = "residential_address", nullable = false)
    private String residentialAddress;
    @Column(name = "place_of_living", nullable = false)
    private String placeOfLiving;
    @Column
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Title title;
    @Enumerated
    @Column(nullable = false)
    private Profession profession;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    @ManyToMany
    @JoinTable(
            name = "user_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

}