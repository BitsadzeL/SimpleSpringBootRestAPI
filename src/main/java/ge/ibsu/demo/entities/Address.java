package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="address")

public class Address {
    @Id
    @SequenceGenerator(name="address_address_id_seq",sequenceName = "address_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_address_id_seq")
    @Column(name="address_id")
    private long id;

    @Column(name="address")
    private String address;

    @Column(name="postal_code")
    private String postalCode;



    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
