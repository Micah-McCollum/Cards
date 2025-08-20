package main.model;

import java.util.*;
/*
 * DealerHand.java
 * Represents the dealer's hand in a card game.
 * Provides methods to add cards and retrieve the current hand.
 */
public class DealerHand {
    
    private List<Card> cards;
    private int cardCount;

    // Constructor
    // Initializes the dealer's hand with a maximum number of cards
    // @param maxCards Maximum number of cards in the dealer's hand
    public DealerHand(int maxCards) {
        this.cards = new ArrayList<>(maxCards);
        cardCount = cards.size();
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

    // Adds a card to the dealer's hand
    // @param card The card to be added
    public void addCard(Card card) {
        if(cardCount < cards.size()) {
            cards.add(card);
            cardCount++;
            System.out.println("Card added to dealer's hand: " + card.getCardTitle());
        } else {
            System.out.println("Cannot add more cards, hand is full.");
        }
    }

    // Function
    // Gets value of all cards in dealer's hand
    // @return int hand value
    public int getValue() {
        int handValue = 0;
        for(Card card : cards) {
            handValue += card.getValue(card);
        }
        return handValue;
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

    // Returns the current number of cards in the dealer's hand
    public int getCardCount() {
        return cards.size();
    }

    // Returns the List of cards in the dealer's hand
    public List<Card> getCards() {
        return List.copyOf(cards);
    }
}
