package poker.TexasHoldem;

import CardsMaster.Deck;
import poker.ClassificationRank;
import poker.FiveCardPoker.FiveCardPokerHand;

import java.util.Scanner;

public class TexasHoldemPlayer {

    private TexasHoldemHand.Builder builder;
    private TexasHoldemHand hand;

    private String playerName;
    private ClassificationRank handScore;

    public TexasHoldemPlayer(){
        this.builder = new TexasHoldemHand.Builder();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in Player name: ");
        String name = input.nextLine();
        this.playerName = name;
    }

    public void setHand(Deck deck) {
        this.builder.addPocketCard(deck.deal());
        this.builder.addPocketCard(deck.deal());
        this.hand = builder.build();
    }

    public TexasHoldemHand getHand(){
        return this.hand;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public ClassificationRank getHandScore(){
        return this.hand.getHandAnalyzer().getClassification().getClassificationRank();
    }

    @Override
    public String toString(){
        return "Player: " + getPlayerName() + "\n" +
                "Hand: " + this.hand.toString() + "\n" +
                "Classification: " + getHandScore().toString();

    }
}
