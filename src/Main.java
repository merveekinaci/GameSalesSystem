import Manager.GamerManager;
import Manager.SalesManagement;
import Entities.Campaign;
import Entities.Game;

import Entities.Gamer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Oyuna Hoşgeldiniz");
        System.out.println("---------------------------");
        List<Gamer> gamerList = new ArrayList<>();
        List<Campaign> campaignList = new ArrayList<>();
        List<Game> gameList = new ArrayList<>();

        gameList.add(new Game("GTA", 78.5));
        gameList.add(new Game("Mario", 103.0));
        gameList.add(new Game("Pubg", 183.6));



        campaignList.add(new Campaign("Sims", 65.3, 10));
        campaignList.add(new Campaign("Call of Duty", 150, 22));


        Start start = new Start(new GamerManager(gamerList), new SalesManagement(), gameList,gamerList, campaignList);
        start.startProgram();


    }
}

