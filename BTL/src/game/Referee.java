package game;

public class Referee implements PeopleInGame{
    @Override
    public void doTurn(int action, Game game) {
        switch (action) {
            case Settings.INPUT_NUMBER_OF_PLAYER: {
                while(true) {
                    try {
                        int numberOfPeople = Utils.getInputInteger("Input number of people joining game (1-4): ");
                        if(numberOfPeople < 1 || numberOfPeople > 4) {
                            throw new Exception("Number of people must be greater than 0 & less than 5!");
                        }
                        this.initPlayers(numberOfPeople, game.getPlayers());
                        break;
                    } catch(NumberFormatException nfe) {
                        System.out.println("Number of people must be integer!");
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            }
            case Settings.PICK_NEXT_PLAYER: {
                while(true) {
                    try {
                        int nextPlayerSerial = Utils.getInputInteger("Input the serial of the next player (1-4): ");
                        if(nextPlayerSerial < 1 || nextPlayerSerial > 4) {
                            throw new Exception("The serial of the next player must be greater then 0 & less than 5!");
                        }
                        game.setCurrentPlayerIndex(nextPlayerSerial - 1);
                        break;
                    } catch(NumberFormatException nfe) {
                        System.out.println("The serial of the next player must be integer!");
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            case Settings.CHECK_WINNER: {
                if(game.getCurrentPlayer().getPoint() >= Settings.WINNER_POINT) {
                    game.setPlaying(false);
                }
                break;
            }
            case Settings.SHOW_WINNER: {
                System.out.println("---Result---");
                for(int i = 0; i < 4; i++) {
                    Player player = game.getPlayers()[i];
                    player.celebrate(i == game.getCurrentPlayerIndex());
                }
                break;
            }
        }
    }

    private void initPlayers(int numberOfPeople, Player[] players) {
        int numberOfBot = 4 - numberOfPeople;
        for(int i = 0; i < 4; i++) {
            String playerName = Utils.getInputString(String.format("Please input player %s name", i + 1));
            players[i] = new Player(playerName, i >= numberOfPeople);
        }
        System.out.println(String.format("---Game contains %s %s and %s %s---"
                , numberOfPeople
                , numberOfPeople > 1 ? "people" : "person"
                , numberOfBot
                , numberOfBot > 1 ? "bots" : "bot"));
    }
}
