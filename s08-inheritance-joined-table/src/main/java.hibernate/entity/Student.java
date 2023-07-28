package entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table (name = "student_joined_table")
public class Student extends User {

    private String course;

    public Student (final String firstName, final String lastName, final String email, String course) {
        super (firstName, lastName, email);
        this.course = course;
    }
}
