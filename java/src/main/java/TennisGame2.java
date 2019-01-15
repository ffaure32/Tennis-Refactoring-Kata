
public class TennisGame2 implements TennisGame {
    private static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};
    private int p1Point = 0;
    private int p2Point = 0;

    public TennisGame2() {
    }


    public String getScore() {
        String score = "";
        if (p1Point == p2Point) {
            score = scoreForEquality();
        } else if (p2Point < 4 && p1Point < 4) {
            score = standardScore();
        } else {
            score = scoreForWinOrAdvantage(score);
        }

        return score;
    }

    private String scoreForWinOrAdvantage(String score) {
        if ((p1Point - p2Point) >= 2) {
            score = "Win for player1";
        } else if ((p2Point - p1Point) >= 2) {
            score = "Win for player2";
        } else if (p1Point > p2Point) {
            score = "Advantage player1";
        } else if (p2Point > p1Point) {
            score = "Advantage player2";
        }
        return score;
    }

    private String standardScore() {
        return getScore(p1Point) + "-" + getScore(p2Point);
    }

    private String scoreForEquality() {
        if (p1Point < 3) {
            return getScore(p1Point) + "-All";
        } else return "Deuce";
    }

    private String getScore(int p1point) {
        return SCORES[p1point];
    }

    public void wonPoint(String player) {
        if (player == "player1")
            p1Point++;
        else
            p2Point++;
    }
}