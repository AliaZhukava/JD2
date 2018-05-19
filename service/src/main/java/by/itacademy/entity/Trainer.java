package by.itacademy.entity;

import by.itacademy.entity.enum_entity.Category;
import by.itacademy.entity.enum_entity.GymUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainer", schema = "gym_storage")
@DiscriminatorValue("TRAINER")
public class Trainer extends User {

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.ALL})
    private Set<GymProgram> gymPrograms = new HashSet<>();

    public Trainer (String login, String password, GymUserRole gymUserRole, String name,
                    Long phoneNumber, String email, Category category) {
        super(login, password, gymUserRole, name, phoneNumber, email);
        this.category = category;
    }
}
