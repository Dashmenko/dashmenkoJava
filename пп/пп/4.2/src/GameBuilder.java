public class GameBuilder {
    private int playersCount;

    public GameBuilder setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
        return this;
    }

    public Game createGame() {
        return new Game(playersCount);
    }
}