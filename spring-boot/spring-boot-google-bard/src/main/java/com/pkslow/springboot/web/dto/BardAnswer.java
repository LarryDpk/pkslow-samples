package com.pkslow.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BardAnswer {
    private String chosenAnswer;
    private List<String> draftAnswers;
}
