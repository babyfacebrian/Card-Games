package poker.TexasHoldem;

import CardsMaster.Card;
import poker.*;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class TexasHoldemHandAnalyzer implements HandAnalyzer {

    private final SortedSet<Card> pocketCards;
    private final SortedSet<Card> communityCards;
    private final SortedSet<Card> combinedCards;
    private final Classification handClassification;
    private final RankGroup rankGroup;
    private final SuitGroup suitGroup;


    TexasHoldemHandAnalyzer(final SortedSet<Card> pocketCards, final SortedSet<Card> communityCards){
        this.pocketCards = Collections.unmodifiableSortedSet(pocketCards);
        this.communityCards = Collections.unmodifiableSortedSet(communityCards);
        this.combinedCards = initRiver(this.pocketCards, this.communityCards);
        this.rankGroup = new RankGroup(this.combinedCards);
        this.suitGroup = new SuitGroup(this.combinedCards);
        this.handClassification = PokerHandUtils.classifyPokerHand(getRankGroup(), getSuitGroup(), getCards());
    }

    private SortedSet<Card> initRiver(final SortedSet<Card> pocketCards, final SortedSet<Card> communityCards) {
        final SortedSet<Card> allCards = new TreeSet<>();
        allCards.addAll(pocketCards);
        allCards.addAll(communityCards);
        return Collections.unmodifiableSortedSet(allCards);
    }

    @Override
    public SortedSet<Card> getCards() {
        return this.combinedCards;
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

    public SortedSet<Card> getPocketCards(){
        return this.pocketCards;
    }

    public SortedSet<Card> getCommunityCards(){
        return this.communityCards;
    }
}
