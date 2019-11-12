import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public abstract class Fichier {
    private String chemin, type;

    /* ---------- Constructeurs ---------- */
    public Fichier(String c, String t) {
        super();
        this.chemin = c;
        this.setType(t);
    }

    /* ---------- Accesseurs ---------- */
    public String getChemin() {
        return chemin;
    }
    public String getType() {
        return type;
    }

    /* ---------- Modifieurs ---------- */
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public void setType(String type) {
        this.type = type;
    }

    /* ---------- Méthodes ---------- */

    public void readTextFile() throws IOException {
        BufferedReader lecteur = null;
        String ligne;

        try {
            lecteur = new BufferedReader(new FileReader(this.getChemin()));
        }
        catch (FileNotFoundException exception) {
            System.out.println("Erreur !");
        }
        while ((ligne = lecteur.readLine()) != null) {
            System.out.println(ligne);
        }
    }

    public void reverseReadTextFile() throws IOException {
        BufferedReader lecteur = null;
        String ligne;
        ArrayList<String> listeLignes = new ArrayList<String>();

        try {
            lecteur = new BufferedReader(new FileReader(this.getChemin()));
        }
        catch (FileNotFoundException exception) {
            System.out.println("Erreur !");
        }
        while ((ligne = lecteur.readLine()) != null) {
            listeLignes.add(ligne);
        }
        for (int i = listeLignes.size()-1; i >= 0; i--) {
            System.out.println(listeLignes.get(i));
        }
    }

    public void lecturePalindromique() throws IOException {
        BufferedReader lecteur = null;
        String ligne;
        ArrayList<String> listeLignes = new ArrayList<String>();

        try {
            lecteur = new BufferedReader(new FileReader(this.getChemin()));
        }
        catch (FileNotFoundException exception) {
            System.out.println("Erreur !");
        }
        while ((ligne = lecteur.readLine()) != null) {
            listeLignes.add(ligne);
        }
        for (int i = listeLignes.size()-1; i >= 0; i--) {
            String reverse = listeLignes.get(i);      
            StringBuffer buffer = (new StringBuffer(reverse)).reverse();
            System.out.println(buffer);
        }
    }

    public void compareFiles(Fichier F) throws IOException {
        BufferedReader lecteurFichier1 = null;
        BufferedReader lecteurFichier2 = null;
        String ligne1, ligne2;
        ArrayList<String> listeLignesFichier1 = new ArrayList<String>();
        ArrayList<String> listeLignesFichier2 = new ArrayList<String>();
        try {
            lecteurFichier1 = new BufferedReader(new FileReader(this.getChemin()));
            lecteurFichier2 = new BufferedReader(new FileReader(this.getChemin()));
        }
        catch (FileNotFoundException exception) {
            System.out.println("Erreur !");
        }
        while (((ligne1 = lecteurFichier1.readLine()) != null) && ((ligne2 = lecteurFichier2.readLine())!= null)) {
            listeLignesFichier1.add(ligne1);
            listeLignesFichier2.add(ligne2);
        }
        for (int i = 0; i < listeLignesFichier1.size(); i++) {
            if (listeLignesFichier1.get(i).contains(listeLignesFichier2.get(i))) {
                System.out.println("Les fichiers sont identiques à la ligne "+i);
            } else if (!listeLignesFichier1.get(i).contains(listeLignesFichier2.get(i))) {
                System.out.println("Ils n'y a aucune similitudes");
            }
        }
    }
}