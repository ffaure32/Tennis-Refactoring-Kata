
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
        String score;
        if (equality()) {
            score = scoreForEquality();
        } else if (advantageOrWin()) {
            score = scoreForAdvantageOrWin();
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

    private String scoreForAdvantageOrWin() {
        StringBuilder score = new StringBuilder();
        int minusResult = m_score1 - m_score2;
        score.append(getAdvantageOrWin(minusResult));
        score.append(getLeader(minusResult));
        return score.toString();
    }

    private String getLeader(int minusResult) {
        if(minusResult>0) {
            return "player1";
        } else {
            return "player2";
        }
    }

    private String getAdvantageOrWin(int minusResult) {
        if(Math.abs(minusResult) >= 2) {
            return "Win for ";
        } else {
            return "Advantage ";
        }
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
