package main.model;

import java.util.*;
import java.util.Scanner;

import main.model.*;

public class BlackjackLogic {
    
    // This class will contain the logic for Blackjack game rules and operations
    // It will manage the game state, player actions, dealer actions, and determine the winner.
    
    // GameRunner for a blackjack game
    // Includes methods to start the game, handle player actions, dealer actions, and determine the winner.

    public BlackjackLogic(){};

    boolean playerStood = false;
    boolean gameOver = false;

    public void startGame() {
        System.out.println("Starting Blackjack game...");
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        UserHand playerHand = new UserHand(2);
        DealerHand dealerHand = new DealerHand(2);
        playerHand.drawFrom(deck, 1);
        dealerHand.drawFrom(deck, 1);
        playerHand.drawFrom(deck, 1);
        dealerHand.drawFrom(deck, 1);


        System.out.println("Player's hand: " + playerHand.getCards() + " Value: " + playerHand.getValue());
        System.out.println("Dealer's hand: " + dealerHand.getCards() + " Value: " + dealerHand.getValue());
        checkGameOver();
        System.out.println("Player's turn. Type 'hit' to draw a card or 'stand' to stand");
        System.out.println("Player Decision: ");
        while(scanner.hasNextLine()) {
            String decision = scanner.nextLine();
            if(decision.equalsIgnoreCase("hit") || decision.equalsIgnoreCase("h")) {
                playerHit();
            } else if(decision.equalsIgnoreCase("stand") || decision.equalsIgnoreCase("s")) {
                playerStand();
                break;
            }
            checkGameOver();
        }
        scanner.close();
    }

    private boolean checkGameOver() {
        int handSize = 0;
        UserHand p = new UserHand(handSize);
        DealerHand d = new DealerHand(handSize);
        if(p.getValue() == 21 && d.getValue() == 21) {
            return true;
        } if(d.getValue() == 21) {
            return true;
        }
        return false;
    }

    public void playerHit() {
        Deck deck = new Deck();
        UserHand p = new UserHand(p.getCardCount() + 1);
        p.drawFrom(deck, 1);
        System.out.println("Player hits.");
        p.drawFrom(deck, 1);
    }

    public void playerStand() {
        playerStood = true;
        System.out.println("Player stands.");
    }

    public void dealerPlay() {
        DealerHand dealerHand = new DealerHand(2);
        Deck deck = new Deck();
        if(playerStood == false) {
            return;
        }
        if(dealerHand.getValue() > 21) {
            System.out.println("Dealer busts!");
        } else if(dealerHand.getValue() < 17) {
            dealerHand.drawFrom(deck, 1);
            System.out.println("Dealer hits.");
            System.out.println("Dealer's Value: " + dealerHand.getValue());
        }
    }
}


