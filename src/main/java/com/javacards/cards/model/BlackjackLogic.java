package com.javacards.cards.model;

import java.util.*;
import java.util.Scanner;


public class BlackjackLogic {
    
    // This class will contain the logic for Blackjack game rules and operations
    // It will manage the game state, player actions, dealer actions, and determine the winner.
    
    // GameRunner for a blackjack game
    // Includes methods to start the game, handle player actions, dealer actions, and determine the winner.

    public BlackjackLogic(){};

    boolean playerStood = false;
    boolean gameOver = false;
    String result = "";

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
        if(playerStood == false) {
        while(scanner.hasNextLine()) {
            String decision = scanner.nextLine();
            if(decision.equalsIgnoreCase("hit") || decision.equalsIgnoreCase("h")) {
                playerHit();
                System.out.println("Player's Value: " + playerHand.getValue());
            } else if(decision.equalsIgnoreCase("stand") || decision.equalsIgnoreCase("s")) {
                playerStand();
                System.out.println("Player's Value: " + playerHand.getValue());
                playerStood = true;
                }
                break;
            }
        }
            dealerPlay();
        scanner.close();
        System.out.println("Game Over. Result: " + result);
    }

    private boolean checkGameOver() {
        int handSize = 0;
        UserHand p = new UserHand(handSize);
        DealerHand d = new DealerHand(handSize);
        if(d.getValue() == 21 && p.getValue() == 21) {
            System.out.println("Both player and dealer have Blackjack. New Hand");
            String result = "Both player and dealer have Blackjack. New Hand";
            return true;
        } 
        if(d.getValue() == 21 && p.getValue() != 21) {
            System.out.println("Dealer has Blackjack. Dealer wins.");
            String result = "Dealer has Blackjack. Dealer wins.";
            return true;
        }
        if(d.getValue() != 21 && p.getValue() == 21) {
            System.out.println("Player has Blackjack. Dealer plays.");
            playerStood = true;
            return false;
        }
        if(d.getValue() < 21 && p.getValue() < 21 && playerStood == false) {
            System.out.println("User turn");
        }
        if(d.getValue() <= 21 && p.getValue() <= 21 && playerStood == true) {
            System.out.println("Dealer plays");
        }
        return false;
    }

    public void playerHit() {
        Deck deck = new Deck();
        UserHand p = new UserHand(0);
        System.out.println("Player hits.");
        p.drawFrom(deck, 1);
        System.out.println("Player's Value: " + p.getValue());
        checkGameOver();
    }

    public void playerStand() {
        System.out.println("Player stands.");
        System.out.println("Player's Value: " );
    }

    public void dealerPlay() {
        int handSize = 0;
        DealerHand dealerHand = new DealerHand(handSize);
        Deck deck = new Deck();
        if(playerStood == false) {
            return;
        }
         if(dealerHand.getValue() < 17) {
            dealerHand.drawFrom(deck, 1);
            System.out.println("Dealer hits.");
            System.out.println("Dealer's Value: " + dealerHand.getValue());
            checkGameOver();
        }

        if(dealerHand.getValue() >= 17) {
            System.out.println("Dealer stands.");
            System.out.println("Dealer's Value: " + dealerHand.getValue());

        }

        if(dealerHand.getValue() > 21) {
            System.out.println("Dealer's Value: " + dealerHand.getValue());
            System.out.println("Dealer busts!");

            checkGameOver();
        }
    }
}


