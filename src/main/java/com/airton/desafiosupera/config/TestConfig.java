package com.airton.desafiosupera.config;

import com.airton.desafiosupera.entities.Product;
import com.airton.desafiosupera.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;


    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(null, "Super Mario Odyssey",new BigDecimal("197.88"), Short.parseShort("100"), "super-mario-odyssey.png");
        Product p2 = new Product(null, "Call Of Duty Infinite Warfare",new BigDecimal("49.99"), Short.parseShort("80"), "sCall Of Duty Infinite Warfare.png");
        Product p3 = new Product(null, "The Witcher III Wild Hunt",new BigDecimal("119.5"), Short.parseShort("250"), "The Witcher III Wild Hunt.png");

        repository.saveAll((Arrays.asList(p1,p2,p3)));

    }
}
