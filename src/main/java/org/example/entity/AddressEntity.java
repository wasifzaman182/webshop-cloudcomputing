package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private Integer addressId;

    @Column(name = "Street", length = 255)
    private String street;

    @Column(name = "City", length = 255)
    private String city;

    @Column(name = "State", length = 255)
    private String state;

    @Column(name = "ZipCode", length = 10)
    private String zipCode;

    @Column(name = "Country", length = 255)
    private String country;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @JsonBackReference
    private CustomerEntity customer;
}
