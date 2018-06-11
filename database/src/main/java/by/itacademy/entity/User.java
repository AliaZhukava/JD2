package by.itacademy.entity;


import by.itacademy.entity.enum_entity.GymUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name = "gym_user", schema = "gym_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntity<Long> {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gym_user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private GymUserRole gymUserRole;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private Long phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
}
