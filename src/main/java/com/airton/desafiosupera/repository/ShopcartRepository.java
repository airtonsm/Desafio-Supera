package com.airton.desafiosupera.repository;

import com.airton.desafiosupera.entities.Product;
import com.airton.desafiosupera.entities.Shopcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopcartRepository extends JpaRepository<Shopcart, Long> {



}
