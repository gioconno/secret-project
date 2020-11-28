package com.rz.secret.project.persistance.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_PUNTO_VENDITA")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "CATENA", nullable = false)
    private String chain;

    @Column(name = "DESCRIZIONE", nullable = false)
    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store", fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INDIRIZZO")
    private Address address;

    @Column(name = "PARTITA_IVA", nullable = true)
    private String vat;

    @Column(name = "TELEFONO", nullable = true)
    private String phone;

    @OneToMany(mappedBy = "store",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Receipt> receipts;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.address.setStore(this);
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        receipt.setStore(this);
    }
}
