package main.java.model;

import java.util.*;
import main.java.model.Card;
import main.java.model.Deck;    
import main.java.model.UserHand;

/*
 * DiscardPile.java
 * Represents a discard pile in a card game.
 * Provides methods to discard cards and manage the discard pile.
 */

public class DiscardPile {
    private final List<Card> discardedCards;
    private int discardCount;

    // Constructor
    // Initializes the discard pile with an empty list of discarded cards
    // and sets the discard count to zero
    public DiscardPile() {
        this.discardedCards = new ArrayList<>();
        this.discardCount = 0;
    }

    public void accept(Card card) {
        if(card == null) return;
        // If your Card supports it:
        // card.setVisible(true);
        discardedCards.add(card);
        discardCount++;
        System.out.println("Card discarded: " + card.getCardTitle());
    }

    // Function
    // Returns the current discard count
    // @return int number of discarded cards
    public List<Card> getDiscardedCards() {
        return List.copyOf(discardedCards);
    }

    // Function
    // Returns a String of the Cards in discard pile
    // @return String representation of the discard pile
    public String printDiscardPile() {
        StringBuilder sb = new StringBuilder("Discard Pile:\n");
        for(Card card : discardedCards) {
            sb.append(card.getCardTitle()).append("\n");
        }
        return sb.toString();
    }
}
