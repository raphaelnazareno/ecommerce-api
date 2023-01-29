package com.raphael.home.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Carousel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 150)
    @Column(length = 150, nullable = false)
    private String image;

    @NotBlank
    @NotNull
    @Length(max = 40)
    @Column(length = 40, nullable = false)
    private String description;

    @NotBlank
    @NotNull
    @Length(max = 80)
    @Column(length = 80, nullable = false)
    private String route;
}
