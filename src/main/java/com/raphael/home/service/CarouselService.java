package com.raphael.home.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.raphael.home.dto.CarouselDTO;
import com.raphael.home.dto.mapper.CarouselMapper;
import com.raphael.home.exception.RecordNotFoundException;
import com.raphael.home.repository.CarouselRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CarouselService {

    private final CarouselRepository carouselRepository;
    private final CarouselMapper carouselMapper;

    public CarouselService(CarouselRepository carouselRepository, CarouselMapper carouselMapper) {
        this.carouselRepository = carouselRepository;
        this.carouselMapper = carouselMapper;
    }

    public List<CarouselDTO> list() {
        return carouselRepository.findAll()
                .stream()
                .map(carouselMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CarouselDTO create(CarouselDTO carousel) {
        return carouselMapper.toDTO(carouselRepository.save(carouselMapper.toEntity(carousel)));
    }

    public CarouselDTO findById(@PathVariable @NotNull @Positive Long id) {
        return carouselRepository.findById(id).map(carouselMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
}
