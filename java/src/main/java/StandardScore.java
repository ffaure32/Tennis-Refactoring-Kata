public class StandardScore extends ScoreStrategy {
    public StandardScore(PlayerScore score1, PlayerScore score2) {
        super(score1, score2);
    }

    @Override
    public boolean appliable() {
        return getScoreForPlayer1() < 4 && getScoreForPlayer2() < 4;
    }

    @Override
    public String score() {
        return SCORES[getScoreForPlayer1()] + SCORE_SEPARATOR + SCORES[getScoreForPlayer2()];
    }
}
