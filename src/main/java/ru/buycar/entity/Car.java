package ru.buycar.entity;

import java.util.HashSet;
import java.util.Set;

public class Car {

    private int id;

    private Engine engine;

    private Set<Owner> owners = new HashSet<>();
}
