package com.football.team;

import com.football.FootballApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FootballApplication.class)
@WebAppConfiguration
@IntegrationTest
public class TeamControllerTest {

    RestTemplate template = new TestRestTemplate();

    String baseUrl = "http://localhost:8080/footballTeams/";

    @Test
    public void getTeams_doesReturnTeams() {
        ResponseEntity<List> responseEntity = template.getForEntity(baseUrl, List.class);

        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(responseEntity.getBody().size(), is(equalTo(1)));
    }

    @Test
    public void getTeamWithCorrectTeamName_doesReturnTeam() {
        ResponseEntity<List> responseEntity = template.getForEntity(baseUrl + "/Manchester City", List.class);

        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(responseEntity.getBody().size(), is(equalTo(1)));
    }

    @Test
    public void getTeamWithIncorrectTeamName_doesReturnEmptyList() {
       ResponseEntity<List> responseEntity = template.getForEntity(baseUrl + "/New York Yankees", List.class);

       assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
       assertThat(responseEntity.getBody().size(), is(equalTo(0)));
    }

    @Test
    public void addTeamWithInvalidTeam_doesReturnUnsupportedMediaTypeHttpStatus() {
        ResponseEntity responseEntity = template.postForEntity(baseUrl, "Not a JSON object", HttpEntity.class);

        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.UNSUPPORTED_MEDIA_TYPE)));
    }

    @Test
    public void addTeamWithValidTeam_doesReturnCreatedStatus() {
        Team team = new Team();
        team.setName("Test Team");

        ResponseEntity responseEntity = template.postForEntity(baseUrl, team, Boolean.class);

        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
    }
}
