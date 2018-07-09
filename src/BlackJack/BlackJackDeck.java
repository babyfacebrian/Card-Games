package BlackJack;
import java.util.*;

public class BlackJackDeck {

    private final Stack<BlackJackCard> BlackJackDeck;
    private static final Map<String, BlackJackCard> CardsInPlay = initCardMap();

    public BlackJackDeck() {
        this.BlackJackDeck = initDeck();
    }

    private Stack<BlackJackCard> initDeck() {
        Stack<BlackJackCard> cardStack = new Stack<>();

        for (final BlackJackSuit suit : BlackJackSuit.values()) {
            for (final BlackJackRank rank : BlackJackRank.values()) {
                cardStack.push(getCard(rank, suit));
            }
        }
        Collections.shuffle(cardStack);
        return cardStack;
    }

    private static String cardKey(final BlackJackRank rank, final BlackJackSuit suit) {
        return rank + "_" + suit;
    }

    private static Map<String, BlackJackCard> initCardMap() {
        final Map<String, BlackJackCard> Cards = new HashMap<>();

        for (final BlackJackSuit suit : BlackJackSuit.values()) {
            for (final BlackJackRank rank : BlackJackRank.values()) {
                Cards.put(cardKey(rank, suit), new BlackJackCard(rank, suit));
            }
        }
        return Collections.unmodifiableMap(Cards);
    }

    private static BlackJackCard getCard(final BlackJackRank rank, final BlackJackSuit suit) {
        final BlackJackCard cardRetrieved = CardsInPlay.get(cardKey(rank, suit));

        if (cardRetrieved != null) {
            return cardRetrieved;
        }
        throw new RuntimeException("Invalid Card: " + rank + " " + suit);
    }

    public Optional<BlackJackCard> deal() {
        if (this.BlackJackDeck.empty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.BlackJackDeck.pop());
        }
    }

}
