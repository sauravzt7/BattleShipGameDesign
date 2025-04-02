package com.machinecoding.models;

import com.machinecoding.utils.Util;

public class BattleField implements IBattleField {

    private final int N;
    public BattleField(int N) {
        this.N = N;
    }

    @Override
    public int getSize() {
        return N;
    }

    /**
     * Validate if a ship of given size can be placed at (x, y).
     * For demonstration, we simply ensure it's in bounds and doesn't overlap
     * with existing ships of the same player.
     */

    @Override
    public boolean canPlaceShip(Player player, int startX, int startY, int size) {
        // Check boundaries
        return Util.isWithinBounds(startX, startY, size, N) && !Util.isOverlappingWithOtherShip(player, startX, startY, size);
    }

    @Override
    public String toString() {
        return "BattleField{" +
                "N=" + N +
                '}';
    }
}
