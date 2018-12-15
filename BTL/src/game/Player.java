package game;

public class Player implements PeopleInGame{
    private static final String[] LOSING_MESSAGES = {
            "I'm lost!",
            "On no! I can not got it!",
            "Not good enough for winning!"
    };
    private String name;
    private int point;
    private boolean isBot;

    public Player(String name, boolean isBot) {
        this.name = name;
        this.point = 0;
        this.isBot = isBot;
    }

    @Override
    public void doTurn(int action, Game game) {
        switch (action) {
            case Settings.THROW_DICE: {
                int point = game.getRandomDice().randomPoint();
                this.addPoint(point);
                System.out.println(String.format("-%s: Get %s %s!", this.name, point, point > 1 ? "points" : "point"));
                game.printPlayerPoints();
                break;
            }
        }
    }

    public void celebrate(boolean won) {
        if(won) {
            System.out.println(String.format("-%s: I'm won!", this.name));
        } else {
            if(this.isBot) {
                System.out.println(String.format("-%s: %s!", this.name, this.getRandomLosingMessage()));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public String getRandomLosingMessage() {
        return LOSING_MESSAGES[Utils.randomInt(LOSING_MESSAGES.length)];
    }
}
