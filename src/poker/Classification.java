package poker;

import CardsMaster.Card;

import java.util.Collections;
import java.util.SortedSet;

public class Classification {

    private final ClassificationRank classificationRank;
    private final SortedSet<Card> classifiedCards;

    public Classification(final ClassificationRank classificationRank, final SortedSet<Card> cards) {
        this.classificationRank = classificationRank;
        this.classifiedCards = Collections.unmodifiableSortedSet(cards);
    }

    public SortedSet<Card> getClassifiedCards() {

        return this.classifiedCards;
    }

    public ClassificationRank getClassificationRank() {

        return this.classificationRank;
    }

    @Override
    public String toString(){
        return this.classificationRank.toString();
    }
}
