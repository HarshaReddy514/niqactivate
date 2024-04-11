package com.niq.activate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shoppers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shopper {

    @Id
    private String shopperId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Shelf> shelf;

}
