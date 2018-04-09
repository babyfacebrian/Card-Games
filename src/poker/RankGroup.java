package poker;

import CardsMaster.Card;
import CardsMaster.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class RankGroup implements Iterable<Map.Entry<Rank, List<Card>>> {
    private final Map<Rank, List<Card>> rankMap;
    private final int quadCount;
    private final int setCount;
    private final int pairCount;

    public RankGroup(final SortedSet<Card> cards) {
        this.rankMap = initRankGroup(cards);
        this.quadCount = groupCount(4);
        this.setCount = groupCount(3);
        this.pairCount = groupCount(2);
    }

    private int groupCount(final int count) {
        int matches = 0;

        for(final Map.Entry<Rank, List<Card>> entry : this.rankMap.entrySet()){
            if(entry.getValue().size() == count){
                matches++;
            }
        }
        return matches;
    }

    private static Map<Rank, List<Card>> initRankGroup(final SortedSet<Card> cards) {
        final Comparator<Map.Entry<Rank, List<Card>>> valueCompare =
                (o1, o2) -> o2.getValue().size() == o1.getValue().size() ?
                        o2.getKey().getRankValue() :
                        o2.getValue().size() - o1.getValue().size();

        final List<Map.Entry<Rank, List<Card>>> entryList =
                new ArrayList<>(cards.stream().collect(Collectors.groupingBy(Card::getRank)).entrySet());

        entryList.sort(valueCompare);
        final LinkedHashMap<Rank, List<Card>> sortedResults = new LinkedHashMap<>();

        for(final Map.Entry<Rank, List<Card>> entry : entryList){
            sortedResults.put(entry.getKey(), entry.getValue());
        }
        return Collections.unmodifiableMap(sortedResults);
    }

    public Map<Rank, List<Card>> getRankMap() {
        return this.rankMap;
    }

    public int getQuadCount() {
        return this.quadCount;
    }

    public int getSetCount() {
        return this.setCount;
    }

    public int getPairCount() {
        return this.pairCount;
    }


    @Override
    public Iterator<Map.Entry<Rank, List<Card>>> iterator() {
        return this.rankMap.entrySet().iterator();
    }

}
