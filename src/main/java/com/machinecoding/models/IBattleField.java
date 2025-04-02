package com.machinecoding.models;

public interface IBattleField {
    boolean canPlaceShip(Player player, int startX, int startY, int size);

    int getSize();
}
