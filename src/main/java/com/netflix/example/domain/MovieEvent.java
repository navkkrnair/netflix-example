package com.netflix.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieEvent
{
    private String id;
    private LocalDate date;
}
