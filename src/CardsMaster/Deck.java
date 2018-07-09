package CardsMaster;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class Deck {

    private final Stack<Card> cardDeck;

    private Deck(boolean shuffle) {
        this.cardDeck = initDeck(shuffle);
    }

    public static Deck shuffledDeck() {
        return new Deck(true);
    }

    public static Deck orderedDeck() {
        return new Deck(false);
    }

    public int getDeckSize() {
        return this.cardDeck.size();
    }

    public boolean contains(final Card card) {
        return this.cardDeck.contains(card);
    }

    private Stack<Card> initDeck(boolean shuffle) {
        final Stack<Card> cardStack = new Stack<>();

        for (final Suit suit : Suit.values()) {
            for (final Rank rank : Rank.values()) {
                cardStack.push(Card.getCard(rank, suit));
            }
        }
        if (shuffle) {
            Collections.shuffle(cardStack);
        } else {
            Collections.sort(cardStack);
        }
        return cardStack;
    }

    public Optional<Card> deal() {
        if (this.cardDeck.empty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.cardDeck.pop());
        }
    }

    public static void main(String[] args) {
        final Deck deck = Deck.shuffledDeck();
        final int numCards = 52;
        IntStream.range(0, numCards).forEach(value -> System.out.println(deck.deal().get().toString()));
    }
}
