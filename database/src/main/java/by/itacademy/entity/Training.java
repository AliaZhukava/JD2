package by.itacademy.entity;

import by.itacademy.entity.enum_entity.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "training", schema = "gym_storage")
public class Training extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    public Training (String name, Level level) {
        this.name  = name;
        this.level = level;
    }
}
