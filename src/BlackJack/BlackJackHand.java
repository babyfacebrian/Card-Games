package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand {

    private List<BlackJackCard> hand;
    private int handScore;
    private int handCardCount;

    BlackJackHand(){
        this.hand = new ArrayList<>();
        this.handScore = setHandScore();
        this.handCardCount = setHandCardCount();
    }

    public void addCardToHand(final BlackJackCard cardDealt){
        if(!this.hand.contains(cardDealt)){
            this.hand.add(cardDealt);
        }
        throw new RuntimeException("Cards error");
    }

    private int setHandScore(){
       return this.hand.stream().mapToInt(BlackJackCard::getCardValue).sum();
    }

    private int setHandCardCount(){
        return this.hand.stream().mapToInt(BlackJackCard::getCountValue).sum();
    }

    public int getHandScore(){
        return this.handScore;
    }

    public int getHandCardCount() {
        return this.handCardCount;
    }

    public boolean isBlackJack(){
        if(getHandScore() == 21){
            return true;
        }
        return false;
    }

    public void showHand(){
        for(BlackJackCard card : this.hand){
            System.out.println(card.toString());
        }
        System.out.println("Score: " + this.handScore);
    }
}
