package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "client_gym_program", schema = "gym_storage")
public class ClientGymProgram {

    @EmbeddedId
    private Complex id;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

    public ClientGymProgram(LocalTime time, String dayOfWeek) {
        this.time = time;
        this.dayOfWeek = dayOfWeek;
    }
}
