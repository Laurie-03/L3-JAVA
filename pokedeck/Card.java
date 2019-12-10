import java.util.*;
public class Card {
     String name;
     String lifePoints;
     String type;
     String description;

    /* ----- Constructors ----- */
    public Card(String n, String lp, String t, String desc) {
        name = n;
        lifePoints = lp;
        type = t;
        description = desc;
    }

    /* ----- Getters ----- */
    public String getName() {
        return name;
    }
    public String getLifePoints() {
        return lifePoints;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }

    /* ----- Setters ----- */
    public void setName(String name) {
        this.name = name;
    }
    public void setLifePoints(String lifePoints) {
        this.lifePoints = lifePoints;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}