import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Game
{
    public ArrayList<Card> cardDeck;
    public  ArrayList<Player> players;
    public  Stack<Card> cardStack;
    private Random _random;
    private final int _cardsAmount = 52;
    public Game()
    {
        int playersCount = 5;
        _random = new Random();
        players = new ArrayList<>();
        cardStack = new Stack<>();
        for (int i = 0; i < playersCount; i++)
        {
            players.add(new Player());
        }
        cardDeck = createCardDeck();
        shuffleCards(cardDeck);
        cardStack.push(cardDeck.get(0)); //кладем в стек 1 карту в начале
        cardDeck.remove(0); //убираем из колоды ее
    }

    public  ArrayList<Card> createCardDeck()
    {
        cardDeck = new ArrayList<>();
        for (CardValue c:CardValue.values())
        {
            cardDeck.add(new Card(c, CardSuit.HEARTS));
            cardDeck.add(new Card(c, CardSuit.SPADES));
            cardDeck.add(new Card(c, CardSuit.CLUBS));
            cardDeck.add(new Card(c, CardSuit.DIAMONDS));
        }

        return cardDeck;
    }

    public void shuffleCards( ArrayList<Card> cards)
    {
        cards.sort((a,b) -> _random.nextInt(-2, 2));
    }


    public boolean playersTurn()
    {
        System.out.println("Ход игроков:");
        System.out.println("Игрок\t  Кол-во карт\t   Ход картой");

        for (int i = 0; i < players.size(); i++) //по игрокам
        {
            Player player = players.get(i);    //создаем объект текущего игрока
            if(cardDeck.size()==0)
            {
                System.out.println("Конец игры");
                for(int l=0;l<players.size();l++){
                    System.out.println(l+" \t "+players.get(l).cards.size());
                }
                return false;
            }
            Card card = cardDeck.get(0);      //берем карту из колоды
            cardDeck.remove(0); //убираем ее из колоды
            System.out.println(i+"\t      "+player.cards.size()+"\t\t       "+card.ToString());
            //System.out.println("Стек\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
            //System.out.println("Колода\t"+cardDeck.size()+"\t");
                while (card.getCardValue().ordinal()==cardStack.peek().getCardValue().ordinal()+1   /* ценность карты из колоды =  */
                        ||card.getCardValue().ordinal()==cardStack.peek().getCardValue().ordinal()-1 /* ценность карты -1 */
                        ||card.getSuit().getCardSuite()==cardStack.peek().getSuit().getCardSuite())   /* масть карты из  */
                {
                    System.out.println(i+"\t      "+player.cards.size()+"\t\t       "+card.ToString());
                    //System.out.println("Стек\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
                    //System.out.println("Колода\t"+cardDeck.size()+"\t");

                    cardStack.push(card);
                    player.cards.remove(card);
                    if(cardDeck.size()==0)
                    {
                        System.out.println("Конец игры");
                        for(int l=0;l<players.size();l++){
                            System.out.println(l+" \t "+players.get(l).cards.size());
                        }
                        return false;
                    }
                    card=cardDeck.get(0);
                    cardDeck.remove(0);
                }
                if(player.cards.size()>0){
                    Card card1 = player.cards.get(player.cards.size()-1);
                    while ((card1.getCardValue().ordinal()==cardStack.peek().getCardValue().ordinal()+1
                    ||card1.getCardValue().getCardValue()==cardStack.peek().getCardValue().getCardValue()-1
                    ||card1.getSuit().getCardSuite()==cardStack.peek().getSuit().getCardSuite())
                            &&player.cards.size()!=0)
                {
                    //System.out.println(i+"\t      "+player.cards.size()+"\t\t       "+card.ToString());
                    //System.out.println("Стек\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
                    //System.out.println("Колода\t"+cardDeck.size()+"\t");
                    cardStack.push(card1);
                    player.cards.remove(card1);
                    if(player.cards.size()!=0){
                    card1 = player.cards.get(player.cards.size()-1);}

                }
                    if(player.cards.size()!=0){
                        player.cards.add(card1);
                    }
                }else{
                player.cards.add(card);
                }
        }
        System.out.println("------------------------------------------------");
        if (cardDeck.size()==0)
        {
            System.out.println("Конец игры");
            for(int l=0;l<players.size();l++){
                System.out.println(l+" \t "+players.get(l).cards.size());
            }
            return false;
        }
        return true;
    }
}