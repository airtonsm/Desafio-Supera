package com.airton.desafiosupera.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_shopcart")
public class Shopcart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime moment;

    @OneToMany(mappedBy = "id.shopcart", cascade = CascadeType.ALL) //mapping id OrderItem
    private Set<ShopcartProduct> products = new HashSet<>();

    public Shopcart(){

    }

    public Shopcart(Long id, LocalDateTime moment) {
        this.id = id;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public Set<ShopcartProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<ShopcartProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shopcart)) return false;

        Shopcart shopcart = (Shopcart) o;

        return getId() != null ? getId().equals(shopcart.getId()) : shopcart.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
