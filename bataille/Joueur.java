import java.util.*;

public class Joueur {
    int points;
    ArrayList<Carte> paquet = new ArrayList<Carte>(); 

    /* ---------- Constructeur ---------- */
    public Joueur(ArrayList<Carte> pa) {
        points = 26;
        this.paquet = pa;
    }  

    /* ---------- Méthodes ---------- */

    Carte tirerCarte() {
        Carte ca = paquet.remove(0);
        return ca;
    }

    void ajouterCarte(Carte carteAjouter) {
        paquet.add(carteAjouter);
    }
}