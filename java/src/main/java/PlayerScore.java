public class PlayerScore {
    public final String name;
    private int scoreIndex;

    public PlayerScore(String name) {
        this.name = name;
        this.scoreIndex = 0;
    }

    public void addPoint() {
        this.scoreIndex++;
    }

    public int getScoreIndex() {
        return scoreIndex;
    }

    public boolean advantageOrWin() {
        return scoreIndex >= 4;
    }

    public GameScore getGameScore() {
        return GameScore.fromIndex(scoreIndex);
    }
}
