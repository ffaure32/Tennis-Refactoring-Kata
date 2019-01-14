
public class TennisGame1 implements TennisGame {

    public static final String WIN_PREFIX = "Win for ";
    public static final String ADVANTAGE_PREFIX = "Advantage ";
    private PlayerScore player1;
    private PlayerScore player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new PlayerScore(player1Name);
        this.player2 = new PlayerScore(player2Name);
    }

    public void wonPoint(String playerName) {
        PlayerScore score = getPlayerScore(playerName);
        score.addPoint();
    }

    private PlayerScore getPlayerScore(String playerName) {
        if(playerName.equals(player1.name)) {
            return player1;
        }
        return player2;
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
        scoreBuilder.append(player1.getGameScore().standardScore());
        scoreBuilder.append("-");
        scoreBuilder.append(player2.getGameScore().standardScore());
        return scoreBuilder.toString();
    }

    private String scoreForAdvantageOrWin() {
        StringBuilder score = new StringBuilder();
        int minusResult = player1.getScoreIndex() - player2.getScoreIndex();
        score.append(getAdvantageOrWin(minusResult));
        score.append(getLeader(minusResult));
        return score.toString();
    }

    private String getLeader(int minusResult) {
        if(minusResult>0) {
            return player1.name;
        } else {
            return player2.name;
        }
    }

    private String getAdvantageOrWin(int minusResult) {
        if(Math.abs(minusResult) >= 2) {
            return WIN_PREFIX;
        } else {
            return ADVANTAGE_PREFIX;
        }
    }

    private boolean advantageOrWin() {
        return player1.advantageOrWin()
                || player2.advantageOrWin();
    }

    private String scoreForEquality() {
        return player1.getGameScore().equalityScore();
    }

    private boolean equality() {
        return player1.getScoreIndex() == player2.getScoreIndex();
    }
}
