package com.machinecoding.services;

import com.machinecoding.factory.FiringStrategyFactory;
import com.machinecoding.models.Coordinate;
import com.machinecoding.models.Player;
import com.machinecoding.models.Ship;
import com.machinecoding.strategy.FiringStrategy;

import java.util.HashSet;
import java.util.Set;

public class MissileService implements IMissileService {

    private final FiringStrategy firingStrategy;
    private final Set<Coordinate> usedCoordinates;
    public MissileService() {
        this.firingStrategy = FiringStrategyFactory.getRandomFiringStrategy();
        this.usedCoordinates = new HashSet<>();
    }

    @Override
    public void fireMissile(Player current, Player opponent, int battlefieldSize) {
        // Attempt a random coordinate until we find one not used before

        Coordinate coord = null;
        while(usedCoordinates.contains(coord)) {
            coord = firingStrategy.fireMissile(current, opponent, battlefieldSize);
        }
        usedCoordinates.add(coord);

        // Check if it hits an opponent's ship
        Ship hitShip = null;
        for (Ship ship : opponent.getShips()) {
            if (ship.occupiesCoordinate(coord)) {
                hitShip = ship;
                break;
            }
        }

        if (hitShip != null) {
            // Entire ship destroyed
            opponent.removeShip(hitShip);
            System.out.println(current.getName() + "'s turn: Missile fired at " + coord
                    + " → HIT! " + opponent.getName() + "'s ship " + hitShip.getId() + " destroyed.");
        } else {
            System.out.println(current.getName() + "'s turn: Missile fired at " + coord + " → MISS!");
        }
    }
}
