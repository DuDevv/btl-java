package game;

public class Dice {
    private int face20Percent;

    public Dice(int face20Percent) {
        this.face20Percent = Utils.clampNumber(face20Percent, 1, 6);
    }

    public int randomPoint() {
        int random = Utils.randomInt(100);
        for(int i = 1; i <= 6; i++) {
            if(i == this.face20Percent) {
                continue;
            }
            if(random < 16) {
                return i;
            }
            random -= 16;
        }
        return this.face20Percent;
    }
}
