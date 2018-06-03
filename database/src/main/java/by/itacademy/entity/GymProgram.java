package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gym_program", schema = "gym_storage")
public class GymProgram extends BaseEntity<Long>{

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    public GymProgram(String name, Trainer trainer, Training training, Integer cost) {
        this.name = name;
        this.trainer = trainer;
        this.training = training;
        this.cost = cost;
    }
}
