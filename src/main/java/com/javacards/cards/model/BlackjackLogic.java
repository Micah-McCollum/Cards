package com.javacards.cards.model;

import java.util.Scanner;

public class BlackjackLogic {

    // This class will contain the logic for Blackjack game rules and operations
    // It will manage the game state, player actions, dealer actions, and determine
    // the winner.

    // GameRunner for a blackjack game
    // Includes methods to start the game, handle player actions, dealer actions,
    // and determine the winner.

    public BlackjackLogic() {
    };

    boolean checkGameOver = false;
    String result = "";
    boolean playerStood = false;

    Deck deck;
    UserHand playerHand;
    DealerHand dealerHand;

    public void startGame() {

        System.out.println("Starting Blackjack game...");
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        playerHand = new UserHand(2);
        dealerHand = new DealerHand(2);
        playerHand.drawFrom(deck, 1);
        dealerHand.drawFrom(deck, 1);
        playerHand.drawFrom(deck, 1);
        dealerHand.drawFrom(deck, 1);

        System.out.println("Player's hand: " + playerHand.getCards() + " Value: " + playerHand.getValue());
        System.out.println("Dealer's hand: " + dealerHand.getCards() + " Value: " + dealerHand.getValue());
        checkGameOver();

        if(playerStood != true) {
            System.out.println("Player's turn. Type 'hit' to draw a card or 'stand' to stand");
            System.out.println("Player Decision: ");
            while (scanner.hasNextLine()) {
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("hit") || decision.equalsIgnoreCase("h")) {
                    playerHand.drawFrom(deck, 1);
                    System.out.println("Player's hand: " + playerHand.getCards() + " Value: " + playerHand.getValue());
                    checkGameOver();
                    return;
                } else if (decision.equalsIgnoreCase("stand") || decision.equalsIgnoreCase("s")) {
                    playerStand();
                    System.out.println("Player's hand: " + playerHand.getCards() + " Value: " + playerHand.getValue());
                    break;
                }
            }
        } else {
            System.out.println("Player turn ended. Dealer to play:");
            dealerPlay();
        }
        scanner.close();
        System.out.println("Game Over. Result: " + result);
    }

    private boolean checkGameOver() {
        if (dealerHand.getValue() == 21 && playerHand.getValue() == 21) {
            System.out.println("Both player and dealer have Blackjack. New Hand");
            result = "Both player and dealer have Blackjack. New Hand";
            checkGameOver = true;
            return checkGameOver;
        } else if (dealerHand.getValue() == 21 && playerHand.getValue() != 21) {
            System.out.println("Dealer has Blackjack. Dealer wins.");
            result = "Dealer has Blackjack. Dealer wins.";
            checkGameOver = true;
            return checkGameOver;
        } else if (dealerHand.getValue() != 21 && playerHand.getValue() == 21) {
            System.out.println("Player has Blackjack. Dealer plays.");
            playerStood = true;
            return false;
        } else if (dealerHand.getValue() < 21 && playerHand.getValue() < 21 && playerStood == false) {
            System.out.println("User turn");
            return false;
        } else if (dealerHand.getValue() <= 21 && playerHand.getValue() <= 21 && playerStood == true) {
            System.out.println("Player Stands. Dealer plays");
            return false;
        }
        return checkGameOver;
    }

    public void playerHit() {
        System.out.println("Player hits.");
        playerHand.drawFrom(deck, 1);
        Card drawnCard = deck.drawTop();
        System.out.println("Player drew: " + drawnCard.getCardTitle());
    }

    public void playerStand() {
        playerStood = true;
        System.out.println("Player stands.");
    }

    public void dealerPlay() {
        if (playerStood == false) {
            return;
        } else {
            if (dealerHand.getValue() < 17) {
                dealerHand.drawFrom(deck, 1);
                System.out.println("Dealer hits.");
                System.out.println("Dealer's Value: " + dealerHand.getValue());
                checkGameOver();
            }

            if (dealerHand.getValue() >= 17) {
                System.out.println("Dealer stands.");
                System.out.println("Dealer's Value: " + dealerHand.getValue());

            }

            if (dealerHand.getValue() > 21) {
                System.out.println("Dealer's Value: " + dealerHand.getValue());
                System.out.println("Dealer busts!");

                checkGameOver();
            }
        }
    }
}
