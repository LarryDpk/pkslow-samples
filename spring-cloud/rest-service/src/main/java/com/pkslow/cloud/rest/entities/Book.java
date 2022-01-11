package com.pkslow.cloud.rest.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Integer id;
    private String title;
}
