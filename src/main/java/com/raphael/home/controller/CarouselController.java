package com.raphael.home.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.raphael.home.dto.CarouselDTO;
import com.raphael.home.service.CarouselService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/carousel")
public class CarouselController {

    private final CarouselService carouselService;

    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @GetMapping
    public @ResponseBody List<CarouselDTO> list() {
        return carouselService.list();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarouselDTO create(@RequestBody @Valid @NotNull CarouselDTO carouselDTO) {
        return carouselService.create(carouselDTO);
    }

    @GetMapping("/{id}")
    public CarouselDTO findById(@PathVariable @NotNull @Positive Long id) {
        return carouselService.findById(id);
    }


}
