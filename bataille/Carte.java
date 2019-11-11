public class Carte {
    private static String[] couleurs = {"coeur", "pique", "carreau", "trefle"};
    private static String[] valeurs = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
    String couleur;
    String valeur;
    int index;

    public Carte(int c, int v) {
        this.couleur = couleurs[c];
        this.valeur = valeurs[v];
        this.index = v;
    }
    
    /* ---------- Accesseurs ---------- */
    public String getCouleur() {
        return this.couleur;
    }
    
   public String getValeur() {
        return this.valeur;
    }

    public int getIndex() {
        return this.index;
    }

    /* ---------- Modifieurs ---------- */
    void setCouleur(String uneCouleur) { couleur = uneCouleur; }
    void setValeur(String uneValeur) { valeur = uneValeur; }

    /* ---------- Méthodes ---------- */
   public String compareValeur(int cardIndex) {
        if (this.index > cardIndex){
            return "V";
        } else if(cardIndex > this.index){
            return "D";
        }else {
            return "B";
        }
    }
}