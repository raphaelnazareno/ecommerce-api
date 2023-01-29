package com.raphael.home.dto.mapper;

import org.springframework.stereotype.Component;

import com.raphael.home.dto.CarouselDTO;
import com.raphael.home.model.Carousel;

@Component
public class CarouselMapper {
    
    public CarouselDTO toDTO(Carousel carousel){
        if (carousel == null) {
            return null;
        }
        return new CarouselDTO(carousel.getId(), carousel.getImage(), carousel.getDescription(), carousel.getRoute());
    }

    public Carousel toEntity(CarouselDTO carouselDTO){
        if (carouselDTO == null) {
            return null;
        }
        Carousel carousel = new Carousel();
        if (carousel.getId() != null) {
            carousel.setId(carouselDTO.id());
        }
        carousel.setDescription(carouselDTO.description());
        carousel.setImage(carouselDTO.image());
        carousel.setRoute(carouselDTO.route());
        return carousel;
    }
}
