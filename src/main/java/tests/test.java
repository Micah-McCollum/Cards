package main.java.tests;

import main.java.model.Card;
import main.java.model.Deck;
import main.java.model.Suit;
import main.java.model.Value;
import java.util.Random;

public class test {
    public static void main(String[] args) {
       
        Card card = new Card(Value.ACE, Suit.HEARTS);
        System.out.println("Card Visibility: " + card.getVisible());
        System.out.println("Card Value: " + card.getValue());
        System.out.println("Card Suit: " + card.getSuit());
        System.out.println("Card Title: " + card.getCardTitle());
        card.setVisible(true);
        System.out.println("Card Visibility after setVisible: " + card.getVisible());

        System.out.println("Card Value: " + card.getValue());
        System.out.println("Card Suit: " + card.getSuit());
        System.out.println("Card Title: " + card.getCardTitle());
        
        Deck deck = new Deck();
        deck.snapshot();
        deck.shuffle(new Random());
        deck.snapshot();
        deck.snapshot().size();
        System.out.println("Deck Size: " + deck.snapshot().size());

        deck.drawTop();
        deck.snapshot().size();
        System.out.println("Deck Size after drawing top card: " + deck.snapshot().size());


        System.out.println("Test Ran");
    }
}
