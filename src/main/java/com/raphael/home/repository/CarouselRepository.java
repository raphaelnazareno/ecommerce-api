package com.raphael.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raphael.home.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {
    
}
