package com.machinecoding.utils;

import com.machinecoding.models.Coordinate;
import com.machinecoding.models.Player;
import com.machinecoding.models.Ship;

public class Util {

    public static boolean isOverlappingWithOtherShip(Player player, int startX, int startY, int size) {

        for (Ship s : player.getShips()) {
            for (Coordinate c : s.getOccupiedCoordinates()) {
                // Compare with the new ship's coverage
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (c.equals(new Coordinate(startX + i, startY + j))) {
                            return true; // Overlap found
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean isWithinBounds(int startX, int startY, int size, int N) {
        return startX >= 0 && startY >= 0 && (startX + size) <= N && (startY + size) <= N;
    }
}
