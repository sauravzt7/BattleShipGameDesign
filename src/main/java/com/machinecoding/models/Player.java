package com.machinecoding.models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Ship> ships; // List of ships owned by both players


    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }

    public void removeShip(Ship ship) {
        this.ships.remove(ship);
    }

    public boolean hasShipsRemaining(){
        return !this.ships.isEmpty();
    }

}
