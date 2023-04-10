public class Program {
    static void Main() {
        Game game = new GameBuilder().setPlayersCount(6).createGame();
        while (game.playersTurn()) {

        }
    }
}
