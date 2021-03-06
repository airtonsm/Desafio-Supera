package com.airton.desafiosupera.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopcartDTO {

    private Long id;
    private LocalDateTime moment;
    private BigDecimal shipping;
    private BigDecimal total;
    private BigDecimal subtotal;
    private Integer productQuantity = 0;


    private List<ProductDTO> products = new ArrayList<>();

    public void calcPrice(){
        this.shipping = new BigDecimal("0.0");
        this.total = new BigDecimal("0.0");
        this.subtotal = new BigDecimal("0.0");

        for (ProductDTO product : this.products) {
            this.subtotal = this.subtotal.add(product.calcTotal());
        }

        if(subtotal.intValue() < 250){
            this.shipping = BigDecimal.valueOf(productQuantity*10);
        }
        this.total = this.shipping.add(subtotal);
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

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
