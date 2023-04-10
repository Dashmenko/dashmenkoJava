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
        cardStack.push(cardDeck.get(0)); //������ � ���� 1 ����� � ������
        cardDeck.remove(0); //������� �� ������ ��
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
        System.out.println("��� �������:");
        System.out.println("�����\t  ���-�� ����\t   ��� ������");

        for (int i = 0; i < players.size(); i++) //�� �������
        {
            Player player = players.get(i);    //������� ������ �������� ������
            if(cardDeck.size()==0)
            {
                System.out.println("����� ����");
                for(int l=0;l<players.size();l++){
                    System.out.println(l+" \t "+players.get(l).cards.size());
                }
                return false;
            }
            Card card = cardDeck.get(0);      //����� ����� �� ������
            cardDeck.remove(0); //������� �� �� ������
            System.out.println(i+"\t      "+player.cards.size()+"\t\t       "+card.ToString());
            //System.out.println("����\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
            //System.out.println("������\t"+cardDeck.size()+"\t");
                while (card.getCardValue().ordinal()==cardStack.peek().getCardValue().ordinal()+1   /* �������� ����� �� ������ =  */
                        ||card.getCardValue().ordinal()==cardStack.peek().getCardValue().ordinal()-1 /* �������� ����� -1 */
                        ||card.getSuit().getCardSuite()==cardStack.peek().getSuit().getCardSuite())   /* ����� ����� ��  */
                {
                    System.out.println(i+"\t      "+player.cards.size()+"\t\t       "+card.ToString());
                    //System.out.println("����\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
                    //System.out.println("������\t"+cardDeck.size()+"\t");

                    cardStack.push(card);
                    player.cards.remove(card);
                    if(cardDeck.size()==0)
                    {
                        System.out.println("����� ����");
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
                    //System.out.println("����\t"+cardStack.size()+"\t\t\t\t "+cardStack.peek().getCardValue()+" "+cardStack.peek().getSuit());
                    //System.out.println("������\t"+cardDeck.size()+"\t");
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
            System.out.println("����� ����");
            for(int l=0;l<players.size();l++){
                System.out.println(l+" \t "+players.get(l).cards.size());
            }
            return false;
        }
        return true;
    }
}