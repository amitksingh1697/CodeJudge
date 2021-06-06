package org.codejudge.sb.facade;

import org.codejudge.sb.config.AppConstants;
import org.codejudge.sb.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MultiplayerGame {
    private List<Player> players;
    private Player winner;

    public MultiplayerGame() {
        players = new ArrayList<>();
    }

    public MultiplayerGame(List<Player> players) {
        this.players = players;
    }

    public Player start() {
        int maxScore = 0;

        for (Player player : players) {
            int pinsRemaining = 0;
            for (int i = 0; i < AppConstants.MAX_ROLLS; i++) {
                if (i % 2 == 0) {
                    pinsRemaining = 10 - (int) (10 * Math.random());
                    player.getGame().roll(10 - pinsRemaining);
                } else {
                    if (pinsRemaining == 0) {
                        i++;
                    }
                    player.getGame().roll(ThreadLocalRandom.current().nextInt(0, pinsRemaining + 1));
                    pinsRemaining = 10;
                }
            }
            int finalScore = player.getGame().score();
            if (finalScore > maxScore) {
                maxScore = finalScore;
                winner = player;
            }
        }
        return winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    public void removePlayer(Integer index) {
        players.remove(index);
    }

    public String toString() {
        return "MultiplayerGame [players=" + players + "]";
    }
}
