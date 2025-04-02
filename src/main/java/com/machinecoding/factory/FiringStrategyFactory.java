package com.machinecoding.factory;

import com.machinecoding.strategy.FiringStrategy;
import com.machinecoding.strategy.RandomFiringStrategy;

public class FiringStrategyFactory {
    public static FiringStrategy getRandomFiringStrategy() {
        return new RandomFiringStrategy();
    }
}
