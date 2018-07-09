package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private final BlackJackDeck blackJackDeck;
    private final List<BlackJackPlayer> blackJackPlayers;


    BlackJackGame(){
        this.blackJackDeck = new BlackJackDeck();
        this.blackJackPlayers = new ArrayList<>();
    }

    public void initPlayers(int players){
        for(int i=0; i<players; i++){
            BlackJackPlayer player = new BlackJackPlayer();
            player.setPlayerHand(this.blackJackDeck);
            this.blackJackPlayers.add(player);
        }
    }




}
