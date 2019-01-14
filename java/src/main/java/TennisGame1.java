
public class TennisGame1 implements TennisGame {
    private final String[] SCORES_GAME = {"Love", "Fifteen", "Thirty", "Forty"};

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (equality()) {
            score = scoreForEquality();
        } else if (advantageOrWin()) {
            score = scoreForAdvantage();
        } else {
            score = standardCode();
        }
        return score;
    }

    private String standardCode() {
        StringBuilder scoreBuilder = new StringBuilder();
        scoreBuilder.append(SCORES_GAME[m_score1]);
        scoreBuilder.append("-");
        scoreBuilder.append(SCORES_GAME[m_score2]);
        return scoreBuilder.toString();
    }

    private String scoreForAdvantage() {
        StringBuilder score = new StringBuilder();
        int minusResult = m_score1 - m_score2;
        if(Math.abs(minusResult) >= 2) {
            score.append("Win for ");
        } else {
            score.append("Advantage ");
        }
        if(minusResult>0) {
            score.append("player1");
        } else {
            score.append("player2");
        }
        return score.toString();
    }

    private boolean advantageOrWin() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String scoreForEquality() {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private boolean equality() {
        return m_score1 == m_score2;
    }
}
