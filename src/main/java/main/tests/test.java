package main.tests;

import main.model.Card;
import main.model.Deck;
import main.model.Suit;
import main.model.Value;
import main.model.UserHand;
import main.model.DiscardPile;
import java.util.Random;
import main.model.DealerHand;

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
        // newDeck.shuffle(new Random());
        UserHand userHand = new UserHand(3, newDeck);
        System.out.println("New Deck Size after Player Draw (of 3): " + newDeck.snapshot().size());

        DealerHand dealerHand = new DealerHand(2);
        dealerHand.drawFrom(newDeck, 2);
        System.out.println("New Deck Size after Dealer Draw (of 2): " + newDeck.snapshot().size());
        System.out.println("User Hand Card Count: " + userHand.getCardCount());
        System.out.println("User Hand Cards: " + userHand.getCards());
        System.out.println("Dealer Hand Card Count: " + dealerHand.getCardCount());
        System.out.println("Dealer Hand Cards: " + dealerHand.getCards());
        userHand.selectCardbyIndex(1);
        userHand.selectCardbyIndex(5); // Invalid index test
        
        userHand.discardByIndex(discardPile, 1);
        dealerHand.discardByIndex(discardPile, 0);
        System.out.println("User Hand Cards after discard: " + userHand.getCards());
        System.out.println("Dealer Hand Cards after discard: " + dealerHand.getCards());
        System.out.println("Discard Pile after discard:\n" + discardPile.getDiscardedCards());
        
        System.out.println("Test Ran");
    }
}
