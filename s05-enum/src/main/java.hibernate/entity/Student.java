package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "student_enumerated")
@Data
public class Student {

    @Id
    @GeneratedValue (strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Enumerated (EnumType.STRING)
    @Column (name = "status")
    private Status status;

    public Student (String firstName, String lastName, String email, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }
}
