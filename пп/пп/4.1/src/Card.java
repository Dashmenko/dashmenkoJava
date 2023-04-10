public class Card {

    public readonly CardValue
    value;
    public readonly CardSuit
    suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    public override string

    ToString() {
        return $ "{value} {suit}";
    }

    public enum CardSuit
    {
        HEARTS = 0, DIAMONDS, CLUBS, SPADES
    }
}
