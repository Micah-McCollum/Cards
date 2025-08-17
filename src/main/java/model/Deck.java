package main.java.model;

import java.util.*;
/*
 * Deck.java
 * Represents a deck of playing cards
 * Provides methods to shuffle, draw cards, and take snapshots of the deck
 * Ensures all cards in the deck are unique
 * 
 */
public final class Deck {
  private final List<Card> cards = new ArrayList<>(52);
  private int cardCount;

  // Constructor
  // Initializes the deck with all unique cards from a standard deck of playing cards
  public Deck() {
    for(Suit s : Suit.values())
      for(Value v : Value.values())
        cards.add(new Card(v, s));

    cardCount = cards.size();
  }

  // Function
  // Shuffles the deck using the provided Random instance
  public void shuffle(Random rnd) { Collections.shuffle(cards, rnd); }

  // Function
  // Draws the top card of the deck
  public Card drawTop() { return cards.remove(cards.size() - 1); }

  // Function 
  // Returns a snapshot of the current state of the deck
  public List<Card> snapshot() { return List.copyOf(cards); }

  // Function 
  // Returns
  public static boolean allUnique(Collection<Card> cs) {
    return new HashSet<>(cs).size() == cs.size();
  }

  public Deck getDeck() {
    return this;
  }

  public int getCardCount() {
    return cards.size();  

  }
}