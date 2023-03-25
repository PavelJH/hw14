import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cardsForPlayer = 5;
        int players = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfCards = Rank.values().length * Suit.values().length;
        int maxPlayers = numberOfCards / cardsForPlayer;

        do {
            System.out.println("Пожалуйста, введите количество игроков, от 2 до " + maxPlayers);
            if (scanner.hasNextInt()) {
                players = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не число.");
                scanner = new Scanner(System.in);
            }
        } while (players < 2 || players > maxPlayers);

        Deck deck = new Deck();
        deck.shuffle();

        List<Player> playersList = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            List<Card> hand = deck.deal(cardsForPlayer);
            Player player = new Player(hand);
            playersList.add(player);
        }

        for (int i = 0; i < players; i++) {
            System.out.println("Игрок " + (i + 1) + ":");
            List<Card> hand = playersList.get(i).getHand();
            for (Card card : hand) {
                System.out.println(card);

            }
        }
    }
}