package com.pkslow.springboot.web;

import com.pkslow.ai.Answer;
import com.pkslow.ai.AnswerStatus;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.springboot.web.dto.BardAnswer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/google-bard")
public class BardController {
    private final GoogleBardClient client;

    public BardController(GoogleBardClient client) {
        this.client = client;
    }


    @GetMapping("/ask")
    public BardAnswer ask(@RequestParam("q") String question) {
        Answer answer = client.ask(question);
        if (answer.status() == AnswerStatus.OK) {
            return new BardAnswer(answer.chosenAnswer(), answer.draftAnswers());
        }

        if (answer.status() == AnswerStatus.NO_ANSWER) {
            return new BardAnswer("No Answer", null);
        }

        throw new RuntimeException("Can't access to Google Bard");

    }
}
