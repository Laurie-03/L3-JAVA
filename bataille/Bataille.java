import java.util.*;

public class Bataille {
    public static void main(String[] args) {
        /* ----- Initialisation paquet du jeu ----- */
        ArrayList<Carte> paquetJeu = new ArrayList<Carte>();
        ArrayList<Carte> paquetTemporaire = new ArrayList<Carte>();
        for (int i=0; i<13; i++) {
            for (int j=0; j<4; j++) {
                paquetJeu.add(new Carte(j,i));
            }
        }
        Collections.shuffle(paquetJeu);

        /* ----- Initialisation paquet Joueur1 ----- */
        ArrayList<Carte> paquetJ1 = new ArrayList<Carte>();
        for (int i=0; i<26; i++) {
            Carte carte = paquetJeu.get(i);
            paquetJ1.add(carte);
        };

        /* ----- Initialisation paquet Joueur2 ----- */
        ArrayList<Carte> paquetJ2 = new ArrayList<Carte>();
        for (int j=26; j<52; j++) {
            Carte carte = paquetJeu.get(j);
            paquetJ2.add(carte);
        }

        /* ----- Création des joueurs ----- */
        Joueur j1 = new Joueur(paquetJ1);
        Joueur j2 = new Joueur(paquetJ2);

        
        while (paquetJ1.size() > 0 && paquetJ2.size() > 0) {
            System.out.println("Cartes restantes Joueur 1 avant tirage: "+paquetJ1.size());
            System.out.println("Cartes restantes Joueur 2 avant tirage: "+paquetJ2.size());
            Carte carteJ1 = j1.tirerCarte();
            Carte carteJ2 = j2.tirerCarte();
            paquetTemporaire.add(carteJ1);
            paquetTemporaire.add(carteJ2);
            System.out.println("Joueur 1: "+carteJ1.getValeur()+" de "+carteJ1.getCouleur());
            System.out.println("Joueur 2: "+carteJ2.getValeur()+" de "+carteJ2.getCouleur());
            String analyse = carteJ1.compareValeur(carteJ2.getIndex());
            // System.out.println(analyse);

            switch(analyse) {
                case "V":
                    System.out.println("Le joueur 1 remporte cette manche.");
                    while (paquetTemporaire.size() > 0) {
                        if (!paquetJ1.isEmpty()) {
                            Carte carteAjoute = paquetTemporaire.remove(0);
                            j1.ajouterCarte(carteAjoute);
                        }
                    }
                break;

                case "D":
                    System.out.println("Le joueur 2 remporte cette manche.");
                    while (paquetTemporaire.size() > 0) {
                        if (!paquetJ2.isEmpty()) {
                            Carte carteAjoute = paquetTemporaire.remove(0);
                            j2.ajouterCarte(carteAjoute);
                        }
                    }
                break;

                case "B":
                    if (paquetJ1.size() >= 2 && paquetJ2.size() >= 2) {
                        while (carteJ1.getValeur() == carteJ2.getValeur()) {
                            System.out.println("Bataille !");
                            Carte carte2J1 = j1.tirerCarte();
                            Carte carte2J2 = j2.tirerCarte();
                            paquetTemporaire.add(carte2J1);
                            paquetTemporaire.add(carte2J2);
                            carteJ1 = j1.tirerCarte();
                            carteJ2 = j2.tirerCarte();
                            paquetTemporaire.add(carteJ1);
                            paquetTemporaire.add(carteJ2);
                            System.out.println("Joueur 1: "+carteJ1.getValeur()+" de "+carteJ1.getCouleur());
                            System.out.println("Joueur 2: "+carteJ2.getValeur()+" de "+carteJ2.getCouleur());
                            analyse = carteJ1.compareValeur(carteJ2.getIndex());
                        }
                    } else if (paquetJ1.size() < 2) {
                        System.out.println("Cartes restantes Joueur 1: "+paquetJ1.size());
                        System.out.println("Cartes restantes Joueur 2: "+paquetJ2.size());
                        System.out.println("Il y a bataille mais le joueur 1 ne peut pas jouer, il perd donc la partie !");
                        System.exit(0);
                    } else {
                        System.out.println("Cartes restantes Joueur 1 avant tirage: "+paquetJ1.size());
                        System.out.println("Cartes restantes Joueur 2 avant tirage: "+paquetJ2.size());
                        System.out.println("Il y a bataille mais le joueur 2 ne peut pas jouer, il perd donc la partie !");
                        System.exit(0);
                    }
                break; 
            }
            System.out.println("");
        if (paquetJ1.size() == 0 && paquetJ2.size() == 52) {
            System.out.println("Cartes restantes Joueur 1 : "+paquetJ1.size());
            System.out.println("Cartes restantes Joueur 2 : "+paquetJ2.size());
            System.out.println("Le joueur 2 remporte la partie !!");
        } 
        if (paquetJ2.size() == 0 && paquetJ1.size() == 52) {
            System.out.println("Cartes restantes Joueur 1 : "+paquetJ1.size());
            System.out.println("Cartes restantes Joueur 2 : "+paquetJ2.size());
            System.out.println("Le joueur 1 remporte la partie !!");
        }
        }
        
    }
}