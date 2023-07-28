package entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table (name = "instructor_joined_table")
public class Instructor extends User {

    private Double salary;

    public Instructor (final String firstName, final String lastName, final String email, Double salary) {
        super (firstName, lastName, email);
        this.salary = salary;
    }
}
