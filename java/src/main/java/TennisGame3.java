import java.util.Arrays;
import java.util.List;

public class TennisGame3 implements TennisGame {

    private PlayerScore score1;
    private PlayerScore score2;

    public TennisGame3(String p1N, String p2N) {
        this.score1 = new PlayerScore(p1N);
        this.score2 = new PlayerScore(p2N);
    }

    public String getScore() {
        List<ScoreStrategy> strategies = strategies();
        ScoreStrategy strategy = strategies
                .stream()
                .filter(ScoreStrategy::appliable)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        return strategy.score();
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
        if(playerName.equals(score1.name))
            score1.addPoint();
        else
            score2.addPoint();

    }

}
