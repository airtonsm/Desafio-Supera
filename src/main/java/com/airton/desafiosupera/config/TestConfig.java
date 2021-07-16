package com.airton.desafiosupera.config;

import com.airton.desafiosupera.entities.Product;
import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.entities.ShopcartProduct;
import com.airton.desafiosupera.repository.ProductRepository;
import com.airton.desafiosupera.repository.ShopcartProductRepository;
import com.airton.desafiosupera.repository.ShopcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ShopcartRepository shopcartRepository;

    @Autowired
    private ShopcartProductRepository sprepository;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(null, "Super Mario Odyssey",new BigDecimal("197.88"), Short.parseShort("100"), "super-mario-odyssey.png");
        Product p2 = new Product(null, "Call Of Duty Infinite Warfare",new BigDecimal("49.99"), Short.parseShort("80"), "sCall Of Duty Infinite Warfare.png");
        Product p3 = new Product(null, "The Witcher III Wild Hunt",new BigDecimal("119.5"), Short.parseShort("250"), "The Witcher III Wild Hunt.png");

        repository.saveAll((Arrays.asList(p1,p2,p3)));

        Shopcart shop1 = new Shopcart(null, LocalDateTime.now());
        Shopcart shop2 = new Shopcart(null, LocalDateTime.now());
        Shopcart shop3 = new Shopcart(null, LocalDateTime.now());


        shop1.getProducts().add(new ShopcartProduct(shop1, p1, 2));
        shop1.getProducts().add(new ShopcartProduct(shop1, p2, 1));

        shop2.getProducts().add(new ShopcartProduct(shop2, p2, 2));
        shop2.getProducts().add(new ShopcartProduct(shop2, p3, 1));



        shopcartRepository.saveAll((Arrays.asList(shop1,shop2,shop3)));
        //sprepository.saveAll((Arrays.asList(sp1,sp2)));


    }
}
