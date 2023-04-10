import CardValue.CardValue;

import java.io.Console;
import java.util.*;


public class Game
{
    public List<Card> cardDeck;
    public List<Player> players;

    private Random _random;
    private int _cardsAmount = 52;
    public Game()
    {
        int playersCount = 2;
        _random = new Random();

        players = new List<Player>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Player> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Player player) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Player> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Player> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Player get(int index) {
                return null;
            }

            @Override
            public Player set(int index, Player element) {
                return null;
            }

            @Override
            public void add(int index, Player element) {

            }

            @Override
            public Player remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Player> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Player> listIterator(int index) {
                return null;
            }

            @Override
            public List<Player> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

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
        cardDeck = new List<Card>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Card> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Card card) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Card> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Card> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Card get(int index) {
                return null;
            }

            @Override
            public Card set(int index, Card element) {
                return null;
            }

            @Override
            public void add(int index, Card element) {

            }

            @Override
            public Card remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Card> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Card> listIterator(int index) {
                return null;
            }

            @Override
            public List<Card> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        int suitCount = _cardsAmount / 4;

        for (int i = 0; i < suitCount; i++)
        {
            cardDeck.add(new Card((CardValue)i, (CardSuit)0));
            cardDeck.add(new Card((CardValue)i, (CardSuit)1));
            cardDeck.add(new Card((CardValue)i, (CardSuit)2));
            cardDeck.add(new Card((CardValue)i, (CardSuit)3));
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

        for (int i = 0; i < cards.; i++)
        {
            players[currentPlayer].cards.Add(cards[i]);

            currentPlayer++;
            currentPlayer %= players.Count;
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

                Console.($"{i}\t{player.cards.Count}\t\t{card}");
                player.cards.Remove(card);

                if ((int)card.value > maxValue)
                {
                    maxValue = (int)card.value;
                    playerWithMaxValue = player;
                }

                cardStack.Push(card);

            }
        }

        playerWithMaxValue.cards.add(cardStack);
        System.out.println("Забрал игрок {players.IndexOf(playerWithMaxValue)}.");
        System.out.println("------------------------------------------------");

        if (_cardsAmount == _cardsAmount)
        {
            System.out.println("Победил игрок номер {players.IndexOf(playerWithMaxValue)}");
            return false;
        }

        return true;
    }
}
