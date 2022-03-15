package blackjack.domain.participant;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> playerNames) {
        return new Players(playerNames.stream()
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    public Map<Player, Result> judgeResult(Dealer dealer) {
        Map<Player, Result> result = new LinkedHashMap<>();
        for (Player player : players) {
            result.put(player, player.isWinner(dealer));
        }
        return result;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
