package com.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FootballRestController.BASE_URI)
public class FootballRestController {
    public static final String BASE_URI = "v1/football";

    @GetMapping("/match-results/{match-id}")
    @HystrixCommand(fallbackMethod = "getMatchResultsFallback")
    public String matchResults(@PathVariable("match-id") int matchId) {
        if (matchId != 5)
            throw new RuntimeException("no results for match id : " + matchId);

        return "football results :  manchester united 3:1 Chelsea";
    }

    private String getMatchResultsFallback(int matchId) {
        return "results (TBA)- to be announced soon!! for match id : " + matchId;
    }
}
