package ru.buycar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Table(name = "car")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_owner",
            joinColumns = {@JoinColumn(name = "car")},
            inverseJoinColumns = {@JoinColumn(name = "owner")}
    )
    private Set<Owner> owners = new HashSet<>();
}