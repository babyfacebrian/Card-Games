package BlackJack;

import java.util.Comparator;

public class BlackJackHandComparator implements Comparator<BlackJackHand> {

    private final static int blackJack = 21;


    @Override
    public int compare(final BlackJackHand firstHand, final BlackJackHand secondHand) {
        return 0;
    }

    private static int compareBust(final BlackJackHand firstHand, final BlackJackHand secondHand){
        return Integer.compare(firstHand.getHandScore(), secondHand.getHandScore());
    }
}
