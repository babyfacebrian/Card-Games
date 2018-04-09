package CardsMaster;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;
    private static final Map<String, Card> CARD_MAP = initCardMap();


    public Card(final Rank rank, final Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    private static Map<String,Card> initCardMap() {
        final Map<String, Card> Cards = new HashMap<>();

        for(final Suit suit : Suit.values()){
            for(final Rank rank : Rank.values()){
                Cards.put(cardKey(rank, suit), new Card(rank, suit));
            }
        }
        return Collections.unmodifiableMap(Cards);
    }

    private static String cardKey(final Rank rank, final Suit suit) {
        return rank + " of " + suit;
    }

    @Override
    public String toString(){
        return this.rank + " of " + this.suit;
    }

    public static Card getCard(final Rank rank, final Suit suit) {
        final Card cardRetrieved =  CARD_MAP.get(cardKey(rank, suit));

        if(cardRetrieved != null){
            return cardRetrieved;
        }
        throw new RuntimeException("Invalid CardsMaster.Card " + rank + " " + suit);
    }

    @Override
    public int compareTo(Card other) {
        final int rankCompare = Integer.compare(this.rank.getRankValue(), other.rank.getRankValue());

        if(rankCompare != 0){
            return rankCompare;
        }
        return Integer.compare(this.suit.getSuitValue(), other.suit.getSuitValue());
    }

    @Override
    public boolean equals(final Object object){
        if(this == object){
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        final Card card = (Card) object;
        return this.rank == card.rank && this.suit == card.suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }


}



















