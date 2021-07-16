package com.airton.desafiosupera.repository;

import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.entities.ShopcartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopcartProductRepository extends JpaRepository<ShopcartProduct, Long> {



}
