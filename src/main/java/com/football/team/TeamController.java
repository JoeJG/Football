package com.football.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/footballTeams/")
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(method = GET)
    public HttpEntity<List<Team>> getFootballTeams() {
        log.info("/footballTeams/");
        return new ResponseEntity(teamRepository.getTeams(), HttpStatus.OK);
    }

    @RequestMapping(value = "{teamName}", method = GET)
    public HttpEntity<List<Team>> getFootballTeam(@PathVariable String teamName) {
        log.info("/footballTeams/{}", teamName);
        return new ResponseEntity(teamRepository.getTeam(teamName), HttpStatus.OK);
    }

    @RequestMapping(method = POST)
    public HttpEntity<Boolean> putFootballTeams(@RequestBody Team team) {
        log.info("Adding team: {}", team);

        return new ResponseEntity(teamRepository.addTeam(team), HttpStatus.CREATED);
    }

}
