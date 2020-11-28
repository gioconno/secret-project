package com.rz.secret.project.persistance.model;

import javax.persistence.*;

@Entity
@Table(name = "T_INDIRIZZO")
public class Address {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STORE")
    @MapsId
    private Store store;

    @Column(name = "VIA")
    private String address;

    @Column(name = "NUM_CIVICO")
    private String number;

    @Column(name = "CITTA")
    private String city;

    @Column(name = "PROVINCIA")
    private String province;

    @Column(name = "CAP")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
