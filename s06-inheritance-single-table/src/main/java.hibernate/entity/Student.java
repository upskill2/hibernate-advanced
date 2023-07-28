package entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue ("STUDENT_VALUE")
public class Student extends User {

    private String course;

    public Student (final String firstName, final String lastName, final String email, String course) {
        super (firstName, lastName, email);
        this.course = course;
    }
}
