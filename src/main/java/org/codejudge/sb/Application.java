package org.codejudge.sb;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.facade.MultiPlayerGameFactory;
import org.codejudge.sb.facade.MultiplayerGame;
import org.codejudge.sb.model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@Slf4j
public class Application {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Application.class));
    public static void main(String[] args) {
        LOGGER.info("Starting Spring Application...");
        SpringApplication.run(Application.class, args);

        Player player1 = new Player("A");
        Player player2 = new Player("S");

        MultiplayerGame game = MultiPlayerGameFactory.createMatch();
        game.addPlayer(player1);
        game.addPlayer(player2);

        Player winner = game.start();
        System.out.println(game.getPlayer(0));
        System.out.println(game.getPlayer(1));

        System.out.println(winner);
    }
}
