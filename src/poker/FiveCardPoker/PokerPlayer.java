package poker.FiveCardPoker;

import CardsMaster.Card;
import CardsMaster.Deck;
import poker.ClassificationRank;

import java.util.Scanner;

public class PokerPlayer {

    private FiveCardPokerHand.Builder builder;
    private  FiveCardPokerHand hand;

    private String playerName;
    private ClassificationRank handScore;

    public PokerPlayer(){
        this.builder = new FiveCardPokerHand.Builder();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in Player name: ");
        String name = input.nextLine();
        this.playerName = name;
    }

    public void setHand(Deck deck){
        this.builder.addCard(deck.deal());
        this.builder.addCard(deck.deal());
        this.builder.addCard(deck.deal());
        this.builder.addCard(deck.deal());
        this.builder.addCard(deck.deal());
        this.hand = builder.build();
    }

    public FiveCardPokerHand getHand(){
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
