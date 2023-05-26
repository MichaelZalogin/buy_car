package ru.buycar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_brand")
    private Brand brand;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<HistoryOwner> historyOwners = new ArrayList<>();

    //todo обновить таблицы
    @Column(name = "year")
    private int year;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_id")
    private Body body;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_fuel_id")
    private FuelType typeOfFuel;

    //todo обновить таблицы
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "door_id")
    private DoorCount doorCount;

}