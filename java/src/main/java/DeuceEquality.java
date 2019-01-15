public class DeuceEquality extends ScoreStrategy {
    public DeuceEquality(PlayerScore score1, PlayerScore score2) {
        super(score1, score2);
    }

    public boolean appliable() {
        return getScoreForPlayer1() == getScoreForPlayer2()
                && getScoreForPlayer1() >= 3;
    }

    public String score() {
        return "Deuce";

    }
}
