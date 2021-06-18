package com.airton.desafiosupera.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;


public class Order{


    private Long id;

    private Instant moment;


}
