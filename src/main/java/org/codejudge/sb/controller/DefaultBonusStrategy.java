package org.codejudge.sb.controller;

import org.codejudge.sb.config.AppConstants;

public class DefaultBonusStrategy implements BonusStrategy {
    @Override
    public String getStrategyName() {
        return "DEFAULT";
    }

    @Override
    public int strikeBonus() {
        return AppConstants.STRIKE_BONUS;
    }

    @Override
    public int spareBonus() {
        return AppConstants.SPARE_BONUS;
    }
}
