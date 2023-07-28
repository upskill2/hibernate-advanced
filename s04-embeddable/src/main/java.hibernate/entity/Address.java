package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Data
@Table (name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column (name = "street")
    private String street;

    @Column (name = "city")
    private String city;

    @Column (name = "zipcode")
    private int zipcode;

}
