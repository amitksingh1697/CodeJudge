package org.codejudge.sb.controller;

import org.codejudge.sb.config.AppConstants;

import java.util.Arrays;

public class BowlingGameScoreBoardImpl implements BowlingGameScoreBoard {
    private int[] rolls;
    private Integer currentRoll;
    private BonusStrategy bonusStrategy;

    public BowlingGameScoreBoardImpl() {
        this.currentRoll = 0;
        this.rolls = new int[AppConstants.MAX_ROLLS];
        this.bonusStrategy = new DefaultBonusStrategy();
    }

    public void roll(Integer r) {
        if (currentRoll == AppConstants.MAX_ROLLS - 1 && (rolls[currentRoll - 1] + rolls[currentRoll - 2] > 9)) {
            return;
        }
        rolls[currentRoll++] = r;
    }

    public Integer score() {
        int score = 0;
        int frame = 0;

        for (int i = 0; i < 10; i++) {
            int tempScore = 0;
            if (isStrike(frame)) {
                tempScore = 10 + bonusStrategy.strikeBonus();
                score += tempScore;
                frame += 2;
            } else if (isSpare(frame)) {
                tempScore = 10 + bonusStrategy.spareBonus();
                score += tempScore;
                frame += 2;
            } else {
                tempScore = sumOfRolls(frame);
                score += tempScore;
                frame += 2;
            }
        }
        return score + rolls[frame];
    }

    private boolean isStrike(int frame) {
        return rolls[frame] == 10;
    }

    private int sumOfRolls(int frame) {
        return rolls[frame] + rolls[frame + 1];
    }

    private boolean isSpare(int frame) {
        return sumOfRolls(frame) == 10;
    }

    public int[] getRolls() {
        return rolls;
    }

    public String getBonusStrategy() {
        return bonusStrategy.getStrategyName();
    }

    public void setBonusStrategy(BonusStrategy bonusStrategy) {
        this.bonusStrategy = bonusStrategy;
    }

    public String toString() {
        return "BowlingGameScoreBoardImpl [bonusStratrgy=" + bonusStrategy.getStrategyName() + ", rolls=" + Arrays.toString(rolls) + ",currentRolls=" + currentRoll + "]";
    }


}
