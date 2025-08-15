package main.model;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Card {
   
    int value;
    String suit, cardTitle;
    HashMap<Integer, String> cardMap;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        Random r = new Random();
        final Integer cardId = r.nextInt(640); 
        String cardTitle = ("The " + value + " of " + suit);
        
        cardMap.put(cardId, cardTitle);
    }

    public Integer getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getCardTitle() {
        return cardTitle;
    }
}
 