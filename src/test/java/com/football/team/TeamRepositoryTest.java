package com.football.team;

import com.football.FootballApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(FootballApplication.class)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void getTeams_doesReturnDefaultTeamCorrectly() {
        List<Team> teams = teamRepository.getTeams();

        assertThat(teams.size(), is(equalTo(1)));
        Team team = teams.get(0);
        assertThat(team.getName(), is(equalTo("Manchester City")));
        assertThat(team.getCity(), is(equalTo("Manchester")));
        assertThat(team.getCompetition(), is(equalTo("Premier League")));
        assertThat(team.getOwner(), is(equalTo("ADUG")));
        assertThat(team.getPlayers(), is(equalTo(Arrays.asList("Sergio Aguero","Wilfried Bony","Edin Dzeko","Kelechi Iheanacho","Stevan Jovetic"))));
    }

    @Test
    public void addTeam_doesSucessfullySaveTeam() {
        Team team = new Team();
        team.setName("Test Team");

        assertThat(teamRepository.addTeam(team), is(equalTo(true)));
        assertThat(teamRepository.getTeams().get(1).getName(), is(equalTo(team.getName())));
    }

    @Test
    public void getTeam_doesReturnTeamsWithNameEntered() {
        // Flaw in implementation because nothing forces name to be unique.
        Team team1 = new Team();
        team1.setName("Test Team");
        Team team2 = new Team();
        team2.setName("Test Team");

        teamRepository.addTeam(team1);
        teamRepository.addTeam(team2);

        List<Team> teams = teamRepository.getTeam("Test Team");

        assertThat(teams.size(), is(equalTo(2)));
        assertThat(teams.get(0).getName(), is(equalTo("Test Team")));
        assertThat(teams.get(1).getName(), is(equalTo("Test Team")));
    }



}
