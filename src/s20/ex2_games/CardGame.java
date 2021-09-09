package s20.ex2_games;

import s20.ex2_games.cards.CardDeck;

public class CardGame {

    public static void main(String[] args) {
        // make a card deck and shuffle 1000 times
        CardDeck deck = new CardDeck();
        GameEngine game = new GameEngine(deck, "Bob", "Alice"); // our two players
        for (int i = 0; i < 10; i++) { // we play 10 times
            game.play();
            System.out.println("-------------------------");
        }
    }
}