package main.model;

import java.util.ArrayList;
import java.util.List;
/*
 * UserHand.java
 * Represents a user's hand of cards in a card game.
 * Provides methods to add cards and retrieve the current hand.
 */
public class UserHand {
    List<Card> cardsList = new ArrayList<>();
    private int cardCount;
    private int handSize;
    private int handValue;

    // Constructor
    // Initializes the user's hand with a specified number of cards from the active deck
    public UserHand(int handSize, Deck activeDeck) {
        this.handSize = handSize;
        cardsList = new ArrayList<>();
        
        // Initialize the hand with cards from the active deck
        for(int i = 0; i < handSize; i++) {
            if(activeDeck.getDeck().getCardCount() > 0) {
                Card drawnCard = activeDeck.drawTop();
                cardsList.add(drawnCard);
            } else {
                System.out.println("No more cards in the deck to draw");
                break; 
            }
        }
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
            cardsList.add(c);
        }
    }

    // Function
    // Returns the current hand of cards as List
    // @return List<Card> current hand of cards
    public List<Card> getCards() {
    return List.copyOf(cardsList);
    }

    // Function
    // Returns the number of cards in the user's hand
    // @return int number of cards
    public int getCardCount() {
        return cardsList.size();
    }

    // Function
    // Can select Card by hand index instead of TITLE
    public void selectCardbyIndex(int index) {
        if(index >= 0 && index < cardsList.size()) {
            Card selectedCard = cardsList.get(index);
            System.out.println("Selected Card: " + selectedCard.getCardTitle());
        } else {
            System.out.println("Invalid card index");
        }
    }   

    // Function
    // Discard by index
    public void discardByIndex(DiscardPile pile, int index) {
        if(index < 0 || index >= cardsList.size()) {
            System.out.println("Invalid index for discard.");
            return;
        }
        Card c = cardsList.remove(index);
        pile.accept(c);
    }

    // Discard by object
    public boolean discard(DiscardPile pile, Card card) {
        if(card != null && cardsList.remove(card)) {
            pile.accept(card);
            return true;
        }
        System.out.println("Card not found in user's hand.");
        return false;
    }

    

    public boolean discardByTitle(DiscardPile pile, String cardTitle) {
        for(int i = 0; i < cardsList.size(); i++) {
            Card card = cardsList.get(i);
            if(card.getCardTitle().equals(cardTitle)) {
                cardsList.remove(i);
                pile.accept(card);
                return true;
            }
        }
        System.out.println("Card with title '" + cardTitle + "' not found in user's hand.");
        return false;
    }
}
