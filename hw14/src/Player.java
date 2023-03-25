import java.util.List;

public class Player {
    private List<Card> hand;

    public Player(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }
}
