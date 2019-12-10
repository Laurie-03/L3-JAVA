import java.util.*;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();

    /* ----- Constructors ----- */
    public Deck() {
        deck = new ArrayList<Card>();
    }

    /* ----- Methods ----- */
    public void addCard(Card cardToAdd) {
        deck.add(cardToAdd);
    }
    public Card getCard(int index) {
        return deck.get(index);
    }
    public void updateCard(int index, Card cardToUpdate) {
        deck.set(index, cardToUpdate);
    }
    public void removeCard(int index) {
        deck.remove(index);
    }
}