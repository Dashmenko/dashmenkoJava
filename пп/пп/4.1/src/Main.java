import java.util.List;
import java.util.Random;
import java.util.Stack;
public class Game
{
    public List<Card> cardDeck;
    public List<Player> players;

    private Random _random;
    private int _cardsAmount = 36;
    public Game(int playersCount = 2)
    {
        _random = new Random();

        players = new List<Player>();
        for (int i = 0; i < playersCount; i++)
        {
            players.add(new Player());
        }

        cardDeck = createCardDeck();
        shuffleCards(cardDeck);

        dealCardsToPlayers(players, cardDeck);
    }

    public List<Card> createCardDeck()
    {
        cardDeck = new List<Card>();
        int suitCount = _cardsAmount / 4;

        for (int i = 0; i < suitCount; i++)
        {
            cardDeck.add(new Card((CardValue)i, (Card.CardSuit)0));
            cardDeck.add(new Card((CardValue)i, (Card.CardSuit)1));
            cardDeck.add(new Card((CardValue)i, (Card.CardSuit)2));
            cardDeck.add(new Card((CardValue)i, (Card.CardSuit)3));
        }

        return cardDeck;
    }

    public void shuffleCards(List<Card> cards)
    {
        cards.sort((a, b) -> _random.nextInt(-2, 2));
    }

    public void dealCardsToPlayers(List<Player> players, List<Card> cards)
    {
        int currentPlayer = 0;

        for (int i = 0; i < cards.count; i++)
        {
            players[currentPlayer].cards.Add(cards[i]);

            currentPlayer++;
            currentPlayer %= players.count;
        }
    }

    public boolean playersTurn()
    {
        System.out.println("Ход игроков:");
        System.out.println("игрок\tкол-во карт\tход картой");

        int maxValue = -1;
        Player playerWithMaxValue = null;
        Stack<Card> cardStack = new Stack<Card>();

        for (int i = 0; i < players.Count; i++)
        {
            Player player = players[i];

            if (player.cards.Count > 0)
            {
                Card card = player.cards[_random.Next(player.cards.Count)];

                System.out.println("{i}\t{player.cards.Count}\t\t{card}");
                player.cards.Remove(card);

                if ((int)card.value > maxValue)
                {
                    maxValue = (int)card.value;
                    playerWithMaxValue = player;
                }

                cardStack.Push(card);

            }
        }

        playerWithMaxValue.cards.ddRange(cardStack);
        System.out.println("Забрал игрок {players.IndexOf(playerWithMaxValue)}.");
        System.out.println("------------------------------------------------");

        if (playerWithMaxValue.cards.Count == _cardsAmount)
        {
            System.out.println("Победил игрок номер {players.IndexOf(playerWithMaxValue)}");
            return false;
        }

        return true;
    }
}

}