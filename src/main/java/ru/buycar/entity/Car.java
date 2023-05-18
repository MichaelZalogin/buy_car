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
@ToString(exclude = {"owners", "engine"})
@Table(name = "car")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "owner_id", nullable = false, updatable = false)})
    private Set<Owner> owners = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_brand")
    private CarBrand carBrand;

}