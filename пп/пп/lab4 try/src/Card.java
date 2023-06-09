public class Card
{
    private CardSuit suit;
    private CardValue cardValue;

    public Card (CardValue cardValue, CardSuit suit)
    {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public CardSuit  getSuit()
    {
        return suit;
    }

    public void setSuit(CardSuit suit)
    {
        this.suit = suit;
    }

    public CardValue getCardValue()
    {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue)
    {
        this.cardValue = cardValue;
    }
    public String ToString()
    {
        return cardValue.toString()+"  "+suit.toString();
    }
}
/*public class Card
{

    public  final CardValue value;
    public  final CardSuit suit;

    public Card(CardValue value, CardSuit suit)
    {
        this.value = value;
        this.suit = suit;
    }
    public CardSuit getSuit()
    {
        return suit;
    }

    public void setSuit(CardSuit suit)
    {
        this.suit = suit;
    }

    public CardValue getCardValue()
    {
        return value;
    }

    public void setCardValue(CardValue cardValue)
    {
        this.cardValue = cardValue;
    }
    public String ToString()
    {
        return value.toString()+"  "+suit.toString();
    }
}
}*/