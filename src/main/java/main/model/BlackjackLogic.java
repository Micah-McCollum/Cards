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

    public void startGame() {
        System.out.println("Starting Blackjack game...");
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        UserHand playerHand = new UserHand(2, deck);
        DealerHand dealerHand = new DealerHand(2);
        dealerHand.drawFrom(deck, 2);
        System.out.println("Player's hand: " + playerHand.getCards());
        System.out.println("Dealer's hand: " + dealerHand.getCards());

    }

    public void playerHit() {
        System.out.println("Player hits.");
    }

    public void playerStand() {
        // Logic for player standing (ending their turn)
        System.out.println("Player stands.");
    }

    public void dealerPlay() {
        // Logic for dealer's turn
        System.out.println("Dealer plays.");
    }

    public void determineWinner() {
        // Logic to determine the winner of the game
        System.out.println("Determining winner...");
    }
}


