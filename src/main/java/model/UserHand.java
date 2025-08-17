package main.java.model;

import main.java.model.Deck;
import main.java.model.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * UserHand.java
 * Represents a user's hand of cards in a card game.
 * Provides methods to add cards and retrieve the current hand.
 */
public class UserHand {
    private final List<Card> cardsList = new ArrayList<>();

    private ArrayList<Card> cards;
    private int cardCount;
    private int handSize;

    public UserHand(int handSize, Deck activeDeck) {
        this.handSize = handSize;
        this.cards = new ArrayList<>(handSize);
        this.cardCount = 0;

        // Initialize the hand with cards from the active deck
        for(int i = 0; i < handSize; i++) {
            if(activeDeck.getDeck().getCardCount() > 0) {
                Card drawnCard = activeDeck.drawTop();
                cards.add(drawnCard);
                cardCount++;
            } else {
                System.out.println("No more cards in the deck to draw");
                break; 
            }
        }
    }


    public Card[] getCards() {
        while(cardsList.size() != 0) {
    }
            return cards.toArray(new Card[0]);

}

    public List<Card> snapshot() { return List.copyOf(cardsList); }


    public int getCardCount() {
        return cardCount;
    }


}
