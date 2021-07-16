package com.airton.desafiosupera.entities.PK;

import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ShopcartProductPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "shopcart_id")
    private Shopcart shopcart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Shopcart getShopcart() {
        return shopcart;
    }

    public void setShopcart(Shopcart shopcart) {
        this.shopcart = shopcart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
