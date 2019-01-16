import java.util.Arrays;
import java.util.List;

public class TennisGame3 implements TennisGame {

    private PlayerScore score1;
    private PlayerScore score2;

    public TennisGame3(String player1Name, String player2Name) {
        this.score1 = new PlayerScore(player1Name);
        this.score2 = new PlayerScore(player2Name);
    }

    public String getScore() {
        ScoreStrategy strategy = findAppliableStrategy();
        return strategy.score();
    }

    private ScoreStrategy findAppliableStrategy() {
        List<ScoreStrategy> strategies = strategies();
        return strategies
                .stream()
                .filter(ScoreStrategy::appliable)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private List<ScoreStrategy> strategies() {
        return Arrays.asList(
                new StandardEquality(score1, score2),
                new DeuceEquality(score1, score2),
                new StandardScore(score1, score2),
                new AdvantageScore(score1, score2),
                new WinScore(score1, score2));
    }

    public void wonPoint(String playerName) {
        getPlayerScoreByName(playerName).addPoint();
    }

    private PlayerScore getPlayerScoreByName(String playerName) {
        if(playerName.equals(score1.name))
            return score1;
        return score2;
    }
}
