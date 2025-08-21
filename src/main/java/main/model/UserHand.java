package main.model;

import java.util.ArrayList;
import java.util.List;
/*
 * UserHand.java
 * Represents a user's hand of cards in a card game.
 * Provides methods to add cards and retrieve the current hand.
 */
public class UserHand {
    List<Card> cards; 
    private int cardCount;
    private int handSize;
    private int handValue;

    // Constructor
    // Initializes the user's hand with a specified number of cards from the active deck
    public UserHand(int handSize) {
        this.handSize = handSize;
        this.cards = new ArrayList<>(handSize);
        this.cardCount = cards.size();
        }

    // Function
    // Draws cards from the deck and adds them to the user's hand
    // @param deck Deck from which to draw cards
    // @param n Number of cards to draw
    public void drawFrom(Deck deck, int n) {
        for(int i = 0; i < n; i++) {
            Card c = deck.drawTop();
            if(c == null) {
                System.out.println("No more cards in the deck to draw");
                break;
            }
            cards.add(c);
        }
    }

    // Function
    // Returns the current hand of cards as List
    // @return List<Card> current hand of cards
    public List<Card> getCards() {
    return List.copyOf(cards);
    }

    // Function
    // Returns the number of cards in the user's hand
    // @return int number of cards
    public int getCardCount() {
        return cards.size();
    }

    // Function
    // Returns total value of cards in the hand
    // @return int card summation value
    public int getValue() {
        int handValue = 0;
        for(Card card : cards) {
            handValue += card.getValue(card);
        }
        return handValue;
    }

    // Function
    // Can select Card by hand index instead of TITLE
    public void selectCardbyIndex(int index) {
        if(index >= 0 && index < cards.size()) {
            Card selectedCard = cards.get(index);
            System.out.println("Selected Card: " + selectedCard.getCardTitle());
        } else {
            System.out.println("Invalid card index");
        }
    }   

    // Function
    // Discard by index
    public void discardByIndex(DiscardPile pile, int index) {
        if(index < 0 || index >= cards.size()) {
            System.out.println("Invalid index for discard.");
            return;
        }
        Card c = cards.remove(index);
        pile.accept(c);
    }

    // Discard by object
    public boolean discard(DiscardPile pile, Card card) {
        if(card != null && cards.remove(card)) {
            pile.accept(card);
            return true;
        }
        System.out.println("Card not found in user's hand.");
        return false;
    }

    

    public boolean discardByTitle(DiscardPile pile, String cardTitle) {
        for(int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if(card.getCardTitle().equals(cardTitle)) {
                cards.remove(i);
                pile.accept(card);
                return true;
            }
        }
        System.out.println("Card with title '" + cardTitle + "' not found in user's hand.");
        return false;
    }
}
