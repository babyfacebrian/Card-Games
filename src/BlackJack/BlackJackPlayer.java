package BlackJack;

import java.util.Scanner;

public class BlackJackPlayer {

    private String playerName;
    private BlackJackHand playerHand;
    private int playerScore;

    BlackJackPlayer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in Player name: ");
        String name = input.nextLine();
        this.playerName = name;
        this.playerScore = this.playerHand.getHandScore();
    }

    public void setPlayerHand(final BlackJackDeck gameDeck) {
        this.playerHand.addCardToHand(gameDeck.deal().get());
        this.playerHand.addCardToHand(gameDeck.deal().get());
    }

    public void check(){
        System.out.println(this.playerName + " checks");
    }

    public void hit(BlackJackDeck gameDeck){
        this.playerHand.addCardToHand(gameDeck.deal().get());
    }

    public void playerMove(final BlackJackDeck gameDeck){
        Scanner input = new Scanner(System.in);
        System.out.println("Current Hand: ");
        getPlayerHand().showHand();

        System.out.println("Enter 0 to check or 1 to hit: ");
        int getMove = input.nextInt();

        if(getMove == 0){
            check();
        }else if(getMove == 1){
            hit(gameDeck);
        }else{
            playerMove(gameDeck);
            throw new RuntimeException("Move not allowed");
        }
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getPlayerScore(){
        return this.playerScore;
    }

    public BlackJackHand getPlayerHand(){
        return this.playerHand;
    }

}
