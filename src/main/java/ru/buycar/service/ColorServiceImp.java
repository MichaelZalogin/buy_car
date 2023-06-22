package ru.buycar.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.buycar.entity.Color;
import ru.buycar.repository.interfaces.ColorRepository;
import ru.buycar.service.interfaces.ColorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ThreadSafe
public class ColorServiceImp implements ColorService {

    private final ColorRepository colorRepository;

    @Override
    public List<Color> findAllColours() {
        return colorRepository.findAllColours();
    }

    @Override
    public Optional<Color> findColourById(Long colourId) {
        return colorRepository.findColourById(colourId);
    }

}