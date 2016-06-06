package com.football.team;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private String name;
    private String city;
    private String owner;
    private String competition;
    private List<String> players = new LinkedList<>();
    private Date dateOfCreation = Date.from(Instant.now());

    public Team() {}

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", owner='" + owner + '\'' +
                ", competition='" + competition + '\'' +
                ", players=" + players +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (city != null ? !city.equals(team.city) : team.city != null) return false;
        if (owner != null ? !owner.equals(team.owner) : team.owner != null) return false;
        if (competition != null ? !competition.equals(team.competition) : team.competition != null) return false;
        if (players != null ? !players.equals(team.players) : team.players != null) return false;
        return dateOfCreation != null ? dateOfCreation.equals(team.dateOfCreation) : team.dateOfCreation == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (competition != null ? competition.hashCode() : 0);
        result = 31 * result + (players != null ? players.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        return result;
    }
}
