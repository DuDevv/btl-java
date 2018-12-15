package game;

public class Game {
    private Referee referee;
    private Player[] players;
    private int currentPlayerIndex;
    private Dice[] dices;
    private boolean playing;

    public Game() {
        this.init();
    }

    public void init() {
        this.playing = true;
        this.referee = new Referee();
        this.players = new Player[4];
        this.dices = new Dice[4];
        for(int i = 0; i < 4; i++) {
            this.dices[i] = new Dice(i + 1);
        }
    }

    public void start() {
        this.referee.doTurn(Settings.INPUT_NUMBER_OF_PLAYER, this);
        while(this.playing) {
            this.referee.doTurn(Settings.PICK_NEXT_PLAYER, this);
            this.players[this.currentPlayerIndex].doTurn(Settings.THROW_DICE, this);
            this.referee.doTurn(Settings.CHECK_WINNER, this);
        }
        this.referee.doTurn(Settings.SHOW_WINNER, this);
    }

    public void printPlayerPoints() {
        for(Player player : this.players) {
            int playerPoint = player.getPoint();
            System.out.print(String.format("    %s: %s %s"
                    , player.getName()
                    , playerPoint
                    , playerPoint > 1 ? "points" : "point"));
        }
        System.out.print("\r\n");
    }

    public Referee getReferee() {
        return referee;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return this.players[this.currentPlayerIndex];
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Dice[] getDices() {
        return dices;
    }

    public Dice getRandomDice() {
        return this.dices[Utils.randomInt(4)];
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
