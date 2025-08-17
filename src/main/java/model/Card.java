package main.java.model;
import java.util.*;
/*  
 *  Card.java
 *  Represents a playing card with a suit, value, and visibility state.
 *  Provides methods to get card details and manage visibility.
 */
public class Card {
    
    private Suit suit;
    
    private Value value;
   
    private boolean visible = false;

    private String cardTitle;

    // Constructor
    // Initializes the card with a value and suit, sets visibility to false,
    // and generates a card title based on the value and suit
    // @param value Value of the card 
    // @param suit Suit of the card
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.visible = false;
        this.cardTitle = value.name() + " of " + suit.name();
        System.out.println("Card created: " + cardTitle);
       
    }

    public Value getValue() {
        if(visible) {
            return value;
        }
        return null;
    }

    public Suit getSuit() {
        if(visible) {
            return suit;
    } return null;
    }

    public Card getCard() {
        if(visible) {
            return this;
        }
        return null;
    }

    public Card getCardInList(int index) {
        if(visible) {
            return this;
        }
        return null;
    }

    public String getCardTitle() {
        if(visible) {
            return cardTitle;
    }
        return null;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setCardTitle(String cardTitle) {
        System.out.println("disabled");
    }

    public void setCardSuit(String suit) {
        System.out.println("disabled");
    }

    public void setCardValue(int value) {
        System.out.println("disabled");
    }   

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
 