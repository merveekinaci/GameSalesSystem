package Manager;

import BaseGamer.BaseGamerService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;
import java.util.List;
import java.util.Scanner;

public class GamerManager implements BaseGamerService {

    Scanner scan = new Scanner(System.in);
    private List<Gamer> gamerList;

    public GamerManager(List<Gamer> gamerList) {
        this.gamerList = gamerList;
    }

    @Override
    public void save(Gamer gamer) {
        System.out.println("İsminizi girin:");
        gamer.setName(scan.nextLine());
        System.out.println("Soyisminizi girin:");
        gamer.setLastName(scan.nextLine());
        System.out.println("E-posta adresiniz girin:");
        gamer.setMail(scan.nextLine());
        System.out.println("Şifrenizi oluşturun:");
        gamer.setPassword(scan.nextLine());
        gamerList.add(gamer);
        System.out.println(gamer.getName() + " kayıt oluşturuldu.");
    }

    @Override
    public void update(Gamer gamer) {
        int newVar;
        String strNewVar;
        System.out.println("Güncellemek istediğiniz bilgiyi seçin. 1-İsim  2-Soyisim   3-Mail   4-Şifre");
        int choose = scan.nextInt();
        if (choose == 1) {
            System.out.println("Yeni değeri girin:");
            strNewVar = scan.next();
            gamer.setName(strNewVar);
        } else if (choose == 2) {
            System.out.println("Yeni değeri girin:");
            strNewVar = scan.next();
            gamer.setLastName(strNewVar);
        } else if (choose == 3) {
            System.out.println("Yeni değeri girin:");
            strNewVar = scan.next();
            gamer.setMail(strNewVar);
        } else if (choose == 4) {
            System.out.println("Yeni değeri girin:");
            strNewVar = scan.next();
            gamer.setPassword(strNewVar);
        } else {
            System.out.println("Hatalı seçim yaptınız");
            update(gamer);
        }
        System.out.println("Bilgiler güncellendi.");
    }

    @Override
    public void delete(Gamer gamer) {
        gamerList.remove(gamer);
        System.out.println("Kayıt silindi.");
    }

    @Override
    public Gamer login() {
        System.out.println("Kayıtlı e-posta adresinizi girin:");
        String mail = scan.next();
        scan.nextLine();
        System.out.println("Şifrenizi girin:");
        String password = scan.nextLine();
        for (Gamer gamers : gamerList) {
            if (gamers.getPassword().equals(password) && gamers.getMail().equals(mail)) {
                return gamers;
            }
        }
        return null;
    }

    @Override
    public void showProfile(Gamer gamer) {
        String profile = gamer.toString();
        System.out.println(profile);
    }

    @Override
    public void showGames(Gamer gamer) {
        System.out.println("Kaydolduğunuz Oyunlar ");

        for (Game games : gamer.getGames()) {
            System.out.println(games.getName());
        }
        System.out.println("\n");
        System.out.println("Kaydolduğunuz Kampanyalı  Oyunlar");

        for (Campaign campaigns : gamer.getCampaigns()) {
            System.out.println(campaigns.getName());
        }
    }
}

