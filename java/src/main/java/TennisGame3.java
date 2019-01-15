
public class TennisGame3 implements TennisGame {

    private static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};
    public static final String SCORE_SEPARATOR = "-";
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (isEquality()) {
            return scoreForEquality();
        }
        if (isStandardScore()) {
            return scoreForStandard();
        } else {
            return scoreForAdvantageOrWin();
        }
    }

    private String scoreForAdvantageOrWin() {
        return getAdvantageOrWin() + getLeader();
    }

    private String scoreForStandard() {
        return SCORES[p1] + "-" + SCORES[p2];
    }

    private boolean isStandardScore() {
        return p1 < 4 && p2 < 4;
    }

    private String getAdvantageOrWin() {
        return isAdvantage() ? "Advantage " : "Win for ";
    }

    private String getLeader() {
        return p1 > p2 ? p1N : p2N;
    }

    private boolean isAdvantage() {
        return Math.abs(p1 - p2) == 1;
    }

    private String scoreForEquality() {
        if (p1 >= 3) {
            return "Deuce";
        } else {
            return SCORES[p1] + SCORE_SEPARATOR + "All";
        }
    }

    private boolean isEquality() {
        return p1 == p2;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;

    }

}
