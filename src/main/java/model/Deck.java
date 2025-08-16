package main.java.model;

import java.util.*;

public final class Deck {
  private final List<Card> cards = new ArrayList<>(52);

  public Deck() {
    for(Suit s : Suit.values())
      for(Value v : Value.values())
        cards.add(new Card(v, s));
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
}