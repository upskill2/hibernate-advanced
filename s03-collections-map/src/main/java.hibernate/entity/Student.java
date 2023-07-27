package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "student")
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

    @ElementCollection
    @CollectionTable (name = "image", joinColumns = @JoinColumn (name = "student_id"))
    @Column (name = "file_name")
    private Set<String> images = new HashSet<> ();

    @ElementCollection
    @CollectionTable (name = "images_list", joinColumns = @JoinColumn (name = "student_id"))
    @Column (name = "file_name_list")
    @OrderColumn
    private List<String> imagesList = new ArrayList<> ();

    @ElementCollection
    @CollectionTable (name = "images_map", joinColumns = @JoinColumn (name = "student_id"))
    @MapKeyColumn (name = "file_name_m")
    @Column (name = "image_name_m")
    private Map<String, String> imagesMap = new HashMap<> ();



    public Student (String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
