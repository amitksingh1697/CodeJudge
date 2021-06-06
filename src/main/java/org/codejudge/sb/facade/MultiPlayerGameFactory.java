package org.codejudge.sb.facade;

public class MultiPlayerGameFactory {
    private MultiPlayerGameFactory() {
    };

    public static MultiplayerGame createMatch() {
        return new MultiplayerGame();
    }
}
