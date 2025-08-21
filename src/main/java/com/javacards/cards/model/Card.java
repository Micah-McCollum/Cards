package com.javacards.cards.model;

/*  
 *  Card.java
 *  Represents a playing card with a suit, value, and visibility state.
 *  Provides methods to get card details and manage visibility.
 */
public class Card {
    
    private Suit suit;
    
    private Value value;
   
    private boolean visible = false;


    // Constructor
    // Initializes the card with a value and suit, sets visibility to false,
    // and generates a card title based on the value and suit
    // @param value Value of the card 
    // @param suit Suit of the card
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.visible = true;
        String cardTitle = value + " of " + suit;       
    }
    // TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    // Function
    // Returns the numeric value of the card if it is visible, otherwise returns 0

    public int getValue(Card card) {

        if(card.getVisible()) {
            switch(card.getCardValue()) {
                case TWO:
                return 2;
                case THREE:
                return 3;
                case FOUR:
                return 4;
                case FIVE:
                return 5;
                case SIX:
                return 6;
                case SEVEN:
                return 7;
                case EIGHT:
                return 8;
                case NINE:
                return 9;
                case TEN, JACK, QUEEN, KING:
                return 10;
                case ACE:
                return 11;

                default:
                System.out.println("DEFAULT REACHED getValue");
                return 0;
            }
    }
    System.out.println("getValue ERROR");
        return 0;
}
    public Suit getSuit() {
        if(visible) {
            return suit;
    } return null;
    }

    public Value getCardValue() {
        if(visible) {
            return value;
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
        return value + " of " + suit;
    }

    @Override 
    public String toString() {          
        return getCardTitle();
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

    public void setCardValue(Value value) {
        System.out.println("disabled");
    }   

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
 