package poker.FiveCardPoker;

import CardsMaster.Deck;
import poker.PokerHandComparator;


public class pokerGame {
    private PokerPlayer player1;
    private PokerPlayer player2;

    private Deck deck;
    private PokerHandComparator comparator;

    pokerGame(){
        this.player1 = new PokerPlayer();
        this.player2 = new PokerPlayer();

        this.deck = Deck.shuffledDeck();
        this.comparator = new PokerHandComparator();

    }

    public void Play(){
        this.player1.setHand(this.deck);
        this.player2.setHand(this.deck);

        System.out.println("_____PLAYER ONE_____");
        System.out.println(player1.toString() + "\n");

        System.out.println("_____PLAYER TWO_____");
        System.out.println(player2.toString() + "\n");


        if(player1.getHandScore().getValue() > player2.getHandScore().getValue()) {
            System.out.println(player1.getPlayerName() + " Wins with a " + player1.getHandScore());

        } else if(player1.getHandScore().getValue() == player2.getHandScore().getValue()) {
            System.out.println("Determining tie breaker...");
            final int compareTie = comparator.compare(player1.getHand(), player2.getHand());

            if(compareTie > 0){
                System.out.println(player1.getPlayerName() + " Wins with a " + player1.getHandScore());
            }else if(compareTie == 0){
                System.out.println("It's a tie!");
            }else if( compareTie < 0){
                System.out.println(player2.getPlayerName() + " Wins with a " + player2.getHandScore());
            }else {
                throw new RuntimeException("WTF");
            }

        } else if(player1.getHandScore().getValue() < player2.getHandScore().getValue()) {
            System.out.println(player2.getPlayerName() + " Wins with a " + player2.getHandScore());

        } else {
            throw new RuntimeException("WTF");
        }
    }


    public static void main(String[] args) {
        System.out.println("Playing Five Card Poker");

        pokerGame game = new pokerGame();

        game.Play();
    }
}
