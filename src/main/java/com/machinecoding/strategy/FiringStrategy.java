package com.machinecoding.strategy;

import com.machinecoding.models.Coordinate;
import com.machinecoding.models.Player;

public interface FiringStrategy {
    Coordinate fireMissile(Player current, Player opponent, int size);
}
