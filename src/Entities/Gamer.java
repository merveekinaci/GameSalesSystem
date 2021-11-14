package Entities;

import BaseGamer.Entity;

import java.util.ArrayList;
import java.util.List;

public class Gamer extends Entity {
    private String name;
    private String lastName;
    private String Mail;
    private String password;
    private List<Game> games;
    private List<Campaign> campaigns;

    public Gamer() {
        this.games = games = new ArrayList<>();
        this.campaigns = campaigns = new ArrayList<>();
    }

    public Gamer(String name, String lastName, String Mail, String password, List<Game> games, List<Campaign> campaigns) {
        this();
        this.name = name;
        this.lastName = lastName;
        this.Mail = Mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        this.Mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public String toString() {
        return "İsim: " + this.getName() +
                "Soyisim: " + this.getLastName() +
                "Eposta: " + this.getMail() +
                "Şifre: " + this.getPassword();
    }
}
