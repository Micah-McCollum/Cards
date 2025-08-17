package main.java.tests;

import main.java.model.Card;
import main.java.model.Deck;
import main.java.model.Suit;
import main.java.model.Value;
import main.java.model.UserHand;
import main.java.model.DiscardPile;
import java.util.Random;

public class test {
    public static void main(String[] args) {
       
        Card card = new Card(Value.ACE, Suit.HEARTS);
        System.out.println("Card Visibility: " + card.getVisible());
        System.out.println("Card Value: " + card.getValue());
        System.out.println("Card Suit: " + card.getSuit());
        System.out.println("Card Title: " + card.getCardTitle());
        card.setVisible(true);
        System.out.println("\nCard Visibility after setVisible: " + card.getVisible());

        System.out.println("Card Value: " + card.getValue());
        System.out.println("Card Suit: " + card.getSuit());
        System.out.println("Card Title: " + card.getCardTitle() + "\n");
        
        Deck deck = new Deck();
        deck.snapshot();
        deck.shuffle(new Random());
        deck.snapshot();
        deck.snapshot().size();
        System.out.println("\nDeck Size: " + deck.snapshot().size());

        deck.drawTop();
        deck.snapshot().size();
        System.out.println("Deck Size after drawing top card: " + deck.snapshot().size() + "\n");

        Deck newDeck = new Deck();
        DiscardPile discardPile = new DiscardPile();
        System.out.println("\nNew Deck Size: " + newDeck.snapshot().size());
 
        UserHand userHand = new UserHand(3, newDeck);

        System.out.println("New Deck Size after Player Draw (of 3): " + newDeck.snapshot().size());
        System.out.println("User Hand Card Count: " + userHand.getCardCount());
        System.out.println("User Hand Cards: " + userHand.getCards());

        userHand.selectCardbyIndex(1);
        userHand.selectCardbyIndex(5); // Invalid index test
        
        userHand.discardByIndex(discardPile, 0);
        System.out.println("User Hand Cards after discard: " + userHand.getCards());
        String testTitle = userHand.getCards().get(0).getCardTitle();
        System.out.println("Discarding by title: " + testTitle);
        userHand.discardByTitle(discardPile, testTitle);
        System.out.println("Test Ran");
    }
}
