package BlackJack;

public enum BlackJackRank {
    TWO(2,1),
    THREE(3,1),
    FOUR(4,1),
    FIVE(5,1),
    SIX(6,1),

    SEVEN(7,0),
    EIGHT(8,0),
    NINE(9,0),

    TEN(10, -1),
    JACK(10,-1),
    QUEEN(10,-1),
    KING(10,-1),
    ACE(1,-1);

    private final int rankValue;
    private final int countValue;

    BlackJackRank(final int rankValue, final int countValue){

        this.rankValue = rankValue;
        this.countValue = countValue;
    }

    public int getRankValue(){
        return this.rankValue;
    }

    public int getCountValue(){
        return this.countValue;
    }
}
