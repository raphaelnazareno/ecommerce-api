package com.raphael.home.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarouselDTO(
        @JsonProperty("_id") Long id,

        @NotBlank 
        @NotNull 
        @Length(max = 150) String image,

        @NotBlank 
        @NotNull 
        @Length(max = 40) String description,

        @NotBlank 
        @NotNull 
        @Length(max = 80) String route) {

}
