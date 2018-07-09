package BlackJack;

public class BlackJackCard {

    private final BlackJackRank rank;
    private final BlackJackSuit suit;
    private final boolean isAce;
    private int cardValue;
    private int countValue;

    public BlackJackCard(final BlackJackRank rank, final BlackJackSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.isAce = this.rank.equals(BlackJackRank.ACE);
        this.cardValue = rank.getRankValue();
        this.countValue = rank.getCountValue();
    }

    public String cardKey(final BlackJackRank rank, final BlackJackSuit suit) {
        return rank + "_" + suit;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        final BlackJackCard card = (BlackJackCard) other;
        return this.rank == card.rank && this.suit == card.suit;
    }

    // used for picking from the 2 ace values
    public void swapAceValue() {
        if (this.isAce) {
            if (this.cardValue == 1) {
                this.cardValue = 11;
            }
            if (this.cardValue == 11) {
                this.cardValue = 1;
            }
        } else {
            System.out.println("Not and Ace");
        }
    }

    public BlackJackRank getRank() {
        return this.rank;
    }

    public BlackJackSuit getSuit() {
        return this.suit;
    }

    public int getCardValue() {
        return this.cardValue;
    }

    public int getCountValue(){
        return this.countValue;
    }
}
