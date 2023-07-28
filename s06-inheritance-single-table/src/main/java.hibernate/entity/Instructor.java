package entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue ("INSTRUCTOR_VALUE")
public class Instructor extends User {

    private Double salary;

    public Instructor (final String firstName, final String lastName, final String email, Double salary) {
        super (firstName, lastName, email);
        this.salary = salary;
    }
}
