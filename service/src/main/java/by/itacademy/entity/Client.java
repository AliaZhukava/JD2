package by.itacademy.entity;

import by.itacademy.entity.enum_entity.GymUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client", schema = "gym_storage")
@DiscriminatorValue("CLIENT")
public class Client extends User {

    @Column (name = "bonus_count")
    private Integer bonusCount;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private Review review;

    @OneToMany(mappedBy = "id.client")
    private Set<ClientGymProgram> clientGymPrograms;

    @ManyToMany
    @JoinTable(name = "client_gym_program", schema = "gym_storage",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "gym_program_id")})
    private Set<Training> trainings = new HashSet<>();

    public Client(String login, String password, GymUserRole gymUserRole, String name,
                  Long phoneNumber, String email, Integer bonusCount) {
        super(login, password, gymUserRole, name, phoneNumber, email);
        this.bonusCount = bonusCount;
    }
}

