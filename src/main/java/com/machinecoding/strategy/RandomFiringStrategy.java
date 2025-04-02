package com.machinecoding.strategy;

import com.machinecoding.models.Coordinate;
import com.machinecoding.models.Player;

import java.util.Random;

public class RandomFiringStrategy implements FiringStrategy {
    private Random random = new Random();

    @Override
    public Coordinate fireMissile(Player current, Player opponent, int size) {
        return new Coordinate(random.nextInt(size), random.nextInt(size));
    }
}
