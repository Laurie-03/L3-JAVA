import java.io.IOException;

public class Lecteur {
    public static void main(String[] args) throws IOException {
        Fichier fichier1 = new FichierTexte("test1.txt");
        Fichier fichier2 = new FichierTexte("test2.txt");

        /* ----- Écriture du fichier 1 normalement ----- */
        System.out.println("Lecture normale du fichier");
        fichier1.readTextFile();

        /* ----- Écriture du fichier 2 à l'envers par ligne ----- */
        System.out.println("Lecture inversée du fichier");
        fichier2.reverseReadTextFile();

        /* ----- Comparaison de deux fichiers ----- */
        
        System.out.println("Comparaison du fichier 1 avec le fichier 2");
        fichier1.compareFiles(fichier2);
    }
}