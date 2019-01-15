public class WinScore extends ScoreStrategy {
    public WinScore(PlayerScore score1, PlayerScore score2) {
        super(score1, score2);
    }

    @Override
    public boolean appliable() {
        return Math.abs(getScoreForPlayer1() - getScoreForPlayer2()) > 1;
    }

    @Override
    public String score() {
        return "Win for "+getLeaderName();
    }
}
