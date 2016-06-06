package com.football.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeamRepository {

    @Autowired
    @Value("#{teams}")
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public List<Team> getTeam(String teamName) {

        return teams.stream()
                .filter(team -> teamName.equalsIgnoreCase(team.getName()))
                .collect(Collectors.toList());
    }

    public boolean addTeam(Team team) {
        return teams.add(team);
    }
}
