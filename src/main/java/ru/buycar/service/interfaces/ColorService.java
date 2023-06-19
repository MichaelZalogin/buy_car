package ru.buycar.service.interfaces;

import ru.buycar.entity.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {

    List<Color> findAllColours();

    Optional<Color> findColourById(Long colourId);

}