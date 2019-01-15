public class StandardEquality extends ScoreStrategy {
    public StandardEquality(PlayerScore score1, PlayerScore score2) {
        super(score1, score2);
    }

    public boolean appliable() {
        return getScoreForPlayer1() == getScoreForPlayer2()
                && getScoreForPlayer1() < 3;
    }

    public String score() {
        return SCORES[getScoreForPlayer1()] + SCORE_SEPARATOR + "All";

    }
}
