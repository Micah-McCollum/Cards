package com.javacards.cards.model;

/*  
 *  Card.java
 *  Represents a playing card with a suit, value, and visibility state.
 *  Provides methods to get card details and manage visibility.
 */
public class Card {

    private final Suit suit;

    private final Value value;

    private boolean visible = false;

    String cardTitle = "";

    // Constructor
    // Initializes the card with a value and suit, sets visibility to false,
    // and generates a card title based on the value and suit
    // @param value Value of the card
    // @param suit Suit of the card
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.visible = true;
        cardTitle = value + " of " + suit;
    }
    // TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    // Function
    // Returns the numeric value of the card if it is visible, otherwise returns 0

    public int getValue(Card card) {

        if (card.getVisible()) {
            switch (card.getCardValue()) {
                case TWO: {
                    return 2;
                }
                case THREE: {
                    return 3;
                }
                case FOUR: {
                    return 4;
                }
                case FIVE: {
                    return 5;
                }
                case SIX: {
                    return 6;
                }
                case SEVEN: {
                    return 7;
                }
                case EIGHT: {
                    return 8;
                }
                case NINE: {
                    return 9;
                }
                case TEN, JACK, QUEEN, KING: {
                    return 10;
                }
                case ACE: {
                    return 11;
                }

                default: {
                    System.out.println("DEFAULT REACHED getValue");
                    return 0;
                }
            }
        }
        System.out.println("getValue ERROR");
        return 0;
    }

    // Function
    // Returns the Suit enum of the Card
    // @return Suit the card suit
    public Suit getSuit() {
        if (visible) {
            return suit;
        }
        return null;
    }

    // Function
    // Returns the Value enum of the card
    // @return Value the card value
    public Value getCardValue() {
        if (visible) {
            return value;
        }
        return null;
    }

    // Function
    // Returns the Card object
    // @return Card the card
    public Card getCard() {
        if (visible) {
            return this;
        }
        return null;
    }

    // Function
    // Returns a Card in a CardList based on passed index
    // @return Card the Card chosen with index
    // @parameter int the index in in the List to choose card
    public Card getCardInList(int index) {
        if (visible) {
            return this;
        }
        return null;
    }

    // Function
    // Returns the cardTitle of a Card
    // @return String cardTitle the Value of Suit
    public String getCardTitle() {
        return cardTitle;
    }

    // Function
    // Returns the title of a card as a String
    // @return String cardTitle the Value of Suit
    @Override
    public String toString() {
        return getCardTitle();
    }

    // Function
    // Returns whether a card is visible
    // @return boolean visible card visibility
    public boolean getVisible() {
        return visible;
    }

    // Function
    // DISABLED - Not used
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    // Function
    // DISABLED - Not used
    public void setCardTitle(String cardTitle) {
        System.out.println("disabled");
    }

    // Function
    // DISABLED - Not used
    public void setCardSuit(String suit) {
        System.out.println("disabled");
    }

    // Function
    // DISABLED - Not used
    public void setCardValue(int value) {
        System.out.println("disabled");
    }

    // Function
    // DISABLED - Not used
    public void setCardValue(Value value) {
        System.out.println("disabled");
    }
}
