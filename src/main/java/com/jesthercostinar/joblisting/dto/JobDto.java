package com.jesthercostinar.joblisting.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long id;

    @NotEmpty(message = "Job title is required")
    private String name;
    private String description;
    private int noOfOpenPosition;
    private BigDecimal salary;
    private int yearsOfExperience;
    private String companyName;
    private String location;
    private boolean companyNameHidden;
    private boolean active;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
