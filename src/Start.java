import BaseGamer.BaseGamerService;
import BaseGamer.BaseSalesManagement;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

import java.util.List;
import java.util.Scanner;

public class Start {
    static Scanner scan = new Scanner(System.in);

    private BaseGamerService gamerService;
    private BaseSalesManagement salesManagement;
    private List<Game> gameList;
    private List<Campaign> campaignList;
    private List<Gamer> gamerList;

    public Start(BaseGamerService gamerService, BaseSalesManagement salesManagement, List<Game> gameList,
                 List<Gamer> gamerList, List<Campaign> campaignList) {
        this.gamerService = gamerService;
        this.salesManagement = salesManagement;
        this.gameList = gameList;
        this.gamerList = gamerList;
        this.campaignList = campaignList;
    }

    public void startProgram() {
        System.out.println("1-Kayıt Ol     2-Oturum Aç     0-Çıkış");

        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();
        if (choose == 0) {
            System.out.println("Sistemden Çıkış ");
            return;
        } else if (choose == 1) {
            Gamer gamer = new Gamer();
            gamerService.save(gamer);
            showMenu(gamer);
        } else if (choose == 2) {
            Gamer gamer = gamerService.login();
            if (gamer != null) {
                System.out.println("Merhaba " + gamer.getName());
                showMenu(gamer);
            } else {
                System.out.println("E-posta ya da şifre hatalı");
                startProgram();
            }
        } else {
            System.out.println("Yanlış seçim yaptınız. Tekrar deneyin");
            startProgram();
        }
    }

    public void showMenu(Gamer gamer) {
        System.out.println("1- Oyun Satın al" +
                "2- Kampanyalı Oyun Satın Al" +
                "3- KaYıtlı Oyunları Göster  " +
                "4- Bilgileri Güncelle" +
                "5- Kaydımı Sil" +
                "6- Profilimi Görüntüle" +
                "0- Oturumu kapat");

        int choose = scan.nextInt();

        if (choose == 0) {
            System.out.println("Oturumunuz kapatıldı");
            startProgram();
        } else if (choose == 1) {
            salesManagement.buy(gamer, gameList);
            showMenu(gamer);
        } else if (choose == 2) {
            salesManagement.campaignBuy(gamer, campaignList);
            showMenu(gamer);
        } else if (choose == 3) {
            gamerService.showGames(gamer);
            showMenu(gamer);
        } else if (choose == 4) {
            gamerService.update(gamer);
            gamerService.showProfile(gamer);
            showMenu(gamer);
        } else if (choose == 5) {
            gamerService.delete(gamer);
            startProgram();
        } else if (choose == 6) {
            gamerService.showProfile(gamer);
            showMenu(gamer);
        } else {
            System.out.println("Yanlış seçim yaptınız.Tekrar deneyin.");
            showMenu(gamer);
        }
    }
}

