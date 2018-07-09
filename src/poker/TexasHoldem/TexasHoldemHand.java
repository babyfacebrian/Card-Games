package poker.TexasHoldem;

import CardsMaster.Card;
import poker.Hand;

import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TexasHoldemHand implements Hand {

    private static final int NUM_POCKET_CARDS = 2;
    private static final int NUM_COMMUNITY_CARDS = 5;
    private final TexasHoldemHandAnalyzer holdemHandAnalyzer;

    public TexasHoldemHand(final Builder builder) {
        this.holdemHandAnalyzer = new TexasHoldemHandAnalyzer(builder.pocketCards, builder.communityCards);
    }


    @Override
    public TexasHoldemHandAnalyzer getHandAnalyzer() {
        return this.holdemHandAnalyzer;
    }

    public static class Builder {
        private SortedSet<Card> pocketCards;
        private SortedSet<Card> communityCards;

        public Builder(){
            this.pocketCards = new TreeSet<>();
            this.communityCards = new TreeSet<>();
        }

        public Builder addPocketCard(final Optional<Card> card){
            this.pocketCards.add(card.orElseThrow(IllegalStateException::new));
            return this;
        }

        public Builder addCommunityCard(final Optional<Card> card){
            this.communityCards.add(card.orElseThrow(IllegalStateException::new));
            return this;
        }

        public Builder addAllCommunityCards(final Set<Optional<Card>> playerCards){
            final Stream<Card> cardStream = playerCards.stream()
                                                 .flatMap(optionalCard -> optionalCard.map((Stream::of)).orElseThrow(IllegalStateException::new));

            this.communityCards.addAll(cardStream.collect(Collectors.toSet()));
            return this;
        }

        public TexasHoldemHand build(){
            if(this.pocketCards.size() != NUM_POCKET_CARDS){
                throw new RuntimeException("Invalid hand size");
            }
            if(this.communityCards.size() != NUM_COMMUNITY_CARDS){
                throw new RuntimeException("Invalid community hand size");
            }
            return new TexasHoldemHand(this);
        }
    }
}
