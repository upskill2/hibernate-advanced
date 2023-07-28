package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "student_address")
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

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides ({
            @AttributeOverride (name = "city", column = @Column (name = "billing_city")),
            @AttributeOverride (name = "street", column = @Column (name = "billing_street")),
            @AttributeOverride (name = "zipcode", column = @Column (name = "billing_zipcode"))
    })
    private Address billingAddress;

    public Student (String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = new Address ();
    }
}
