package com.football.team;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TeamConfig {

    @Bean
    public List<Team> teams() {

        Team team = new Team();
        team.setName("Manchester City");
        team.setCity("Manchester");
        team.setCompetition("Premier League");
        team.setOwner("ADUG");
        team.setPlayers(Arrays.asList("Sergio Aguero",
                "Wilfried Bony",
                "Edin Dzeko",
                "Kelechi Iheanacho",
                "Stevan Jovetic"));

        List<Team> teams = new ArrayList<>();
        teams.add(team);

        return teams;
    }
}
