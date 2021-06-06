package org.codejudge.sb.controller;

public interface BonusStrategy {
    String getStrategyName();

    int strikeBonus();

    int spareBonus();
}
