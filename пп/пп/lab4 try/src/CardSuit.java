public enum CardSuit
{
    HEARTS(0),
    SPADES(1),
    CLUBS(2),
    DIAMONDS(3);

    private int cardSuit;

    CardSuit (int value)
    {
        this.cardSuit = value;
    }

    public int getCardSuite() {
        return cardSuit;
    }
}