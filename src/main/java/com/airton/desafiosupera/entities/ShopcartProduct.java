package com.airton.desafiosupera.entities;

import com.airton.desafiosupera.entities.PK.ShopcartProductPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="tb_shopcartProduct")
public class ShopcartProduct implements Serializable {

    @EmbeddedId
    private ShopcartProductPK id = new ShopcartProductPK(); //PK composed

    private Integer quantity;

    public ShopcartProduct(){}

    public ShopcartProduct(Shopcart shopcart, Product product, Integer quantity) {
        id.setShopcart(shopcart);
        id.setProduct(product);
        this.quantity = quantity;
    }

    public Shopcart setOrder(){
        return id.getShopcart();
    }

    public void setOrder(Shopcart shopcart){
        id.setShopcart(shopcart);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopcartProduct)) return false;

        ShopcartProduct shopcartProduct = (ShopcartProduct) o;

        return id != null ? id.equals(shopcartProduct.id) : shopcartProduct.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
