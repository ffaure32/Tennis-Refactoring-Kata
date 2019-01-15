public abstract class ScoreStrategy {
    public static final String SCORE_SEPARATOR = "-";
    static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    protected final PlayerScore score1;
    protected final PlayerScore score2;

    public ScoreStrategy(PlayerScore score1, PlayerScore score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public abstract boolean appliable();

    public abstract String score();


    protected int getScoreForPlayer1() {
        return score1.getScoreIndex();
    }

    protected int getScoreForPlayer2() {
        return score2.getScoreIndex();
    }

    protected String getLeaderName() {
        return getScoreForPlayer1() > getScoreForPlayer2() ? score1.name : score2.name;
    }

}
