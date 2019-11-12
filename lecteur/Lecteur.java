import java.io.IOException;

public class Lecteur {
    public static void main(String[] args) throws IOException {
        Fichier fichier1 = new FichierTexte("test1.txt");
        Fichier fichier2 = new FichierTexte("test2.txt");

        /* ----- Écriture du fichier 1 normalement ----- */
        System.out.println("Lecture normale du fichier 1");
        fichier1.readTextFile();

        /* ----- Écriture du fichier 2 à l'envers par ligne ----- */
        System.out.println("Lecture inversée du fichier 2");
        fichier2.reverseReadTextFile();

        /* ----- Lecture palindromique du fichier 2 ----- */
        System.out.println("Lecture palindromique du fichier 2");
        fichier2.lecturePalindromique();

        /* ----- Comparaison de deux fichiers ----- */
        System.out.println("Comparaison du fichier 1 avec le fichier 2");
        fichier2.compareFiles(fichier1);
    }
}