package poker.FiveCardPoker;

import CardsMaster.Card;
import poker.*;

import java.util.SortedSet;

public class FiveCardHandAnalyzer implements HandAnalyzer {

    private final SortedSet<Card> cards;
    private final Classification handClassification;
    private final RankGroup rankGroup;
    private final SuitGroup suitGroup;

    public FiveCardHandAnalyzer(SortedSet<Card> cards) {
        this.cards = cards;
        this.rankGroup = new RankGroup(this.cards);
        this.suitGroup = new SuitGroup(this.cards);
        this.handClassification = PokerHandUtils.classifyPokerHand(getRankGroup(),getSuitGroup(),getCards());
    }

    @Override
    public SortedSet<Card> getCards() {
        return this.cards;
    }

    @Override
    public Classification getClassification() {
        return this.handClassification;
    }

    @Override
    public RankGroup getRankGroup() {
        return this.rankGroup;
    }

    @Override
    public SuitGroup getSuitGroup() {
        return this.suitGroup;
    }
}
