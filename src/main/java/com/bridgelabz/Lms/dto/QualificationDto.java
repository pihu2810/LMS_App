package com.bridgelabz.Lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class QualificationDto {

    @NotNull
    private long id;
    @NotNull
    private String collageName;
    @NotNull
    private String degree;
    @NotNull
    private String percentage;
    @NotNull
    private String yearOfPassing;
    @NotNull
    private String course;
    @NotNull
    private String document;

}
