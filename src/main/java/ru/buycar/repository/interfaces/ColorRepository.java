package ru.buycar.repository.interfaces;

import ru.buycar.entity.Color;

import java.util.List;
import java.util.Optional;

public interface ColorRepository {

    List<Color> findAllColours();

    Optional<Color> findColourById(Long colourId);

}