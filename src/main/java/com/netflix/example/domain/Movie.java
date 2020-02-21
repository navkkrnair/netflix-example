package com.netflix.example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
public class Movie
{
    @Id
    private final String id;

    @NotNull
    private final String title;
}
